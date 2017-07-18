package assignment05;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GradesGUI {
  private JFrame frame;
  
  private JTextField finalGrade = new JTextField("Approximate final letter grade is ");
  private JButton submit = new JButton("Submit all and compute letter grade");
  
  private Map<EvaluationType, JTextField[]> eMapTextFields
  = new EnumMap<EvaluationType, JTextField[]>(EvaluationType.class);
  
  private Map<EvaluationType, Integer> eMapNumEvals
  = new EnumMap<EvaluationType, Integer>(EvaluationType.class);
  
  private Map<EvaluationType, String> eMapTitles
  = new EnumMap<EvaluationType, String>(EvaluationType.class);
  
  private Map<EvaluationType, Integer> eMapChars
  = new EnumMap<EvaluationType, Integer>(EvaluationType.class);
  
  public GradesGUI() {
    eMapNumEvals.put(EvaluationType.EXAM, 3);
    eMapNumEvals.put(EvaluationType.QUIZ, 12);
    eMapNumEvals.put(EvaluationType.LAB, 11);
    eMapNumEvals.put(EvaluationType.ASSIGNMENT, 10);
    eMapNumEvals.put(EvaluationType.PROJECT, 1);
    eMapTitles.put(EvaluationType.EXAM, "Exam Grades");
    eMapTitles.put(EvaluationType.QUIZ, "Quiz Grades");
    eMapTitles.put(EvaluationType.LAB, "Lab Grades");
    eMapTitles.put(EvaluationType.ASSIGNMENT, "Assignment Grades");
    eMapTitles.put(EvaluationType.PROJECT, "Project Grades");
    eMapChars.put(EvaluationType.EXAM, KeyEvent.VK_E);
    eMapChars.put(EvaluationType.QUIZ, KeyEvent.VK_Q);
    eMapChars.put(EvaluationType.LAB, KeyEvent.VK_L);
    eMapChars.put(EvaluationType.ASSIGNMENT, KeyEvent.VK_A);
    eMapChars.put(EvaluationType.PROJECT, KeyEvent.VK_P);
    createAndShowGUI();
  }
  
  private void createAndShowGUI() {
    frame = new JFrame("Grades Entry System");
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.addWindowListener(new ExitAdapter());
    
    JTabbedPane tabbedPane = new JTabbedPane();
    
    for(EvaluationType eval : EvaluationType.values()){
      setupFields(eval);
      JComponent comp = makePanel(getLabels(eval),eMapTextFields.get(eval));
      tabbedPane.addTab(eMapTitles.get(eval).split(" ")[0], null, comp, eMapTitles.get(eval));
      tabbedPane.setMnemonicAt(eval.ordinal(), eMapChars.get(eval));
    }
    frame.add(tabbedPane);
    frame.add(finalGrade, BorderLayout.PAGE_START);
    frame.add(submit, BorderLayout.PAGE_END);
    submit.addActionListener(new ComputeListener());
    frame.setVisible(true);
  }
  
  private JComponent makePanel(String[] labels, JTextField[] fields){
    JPanel panel = new JPanel();
    if(labels != null){
      JPanel upper = new JPanel();
      upper.setBackground(Color.WHITE);
      panel.setLayout(new BorderLayout());
      upper.setLayout(new GridLayout(0,2));
      panel.add(upper, BorderLayout.PAGE_START);
      for(int i = 0; i < labels.length; i++){
        upper.add(new JLabel(labels[i], JLabel.RIGHT));
        upper.add(fields[i]);
      }
    }
    return panel;
  }
  
  private void setupFields(EvaluationType eval) {
    JTextField[] fields = new JTextField[eMapNumEvals.get(eval)];
    for(int i = 0; i < fields.length; i++) {
      fields[i] = new JTextField();
    }
    eMapTextFields.put(eval, fields);
  }
  
  private String[] getLabels(EvaluationType eval) {
    String[] strings = new String[eMapNumEvals.get(eval)];
    for(int i = 0; i < strings.length; i++) {
      strings[i] = eMapTitles.get(eval) + " " + (i + 1) + ": ";
    }
    return strings;
  }

  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new GradesGUI ();
      }
    });
  }
  
  private class ExitAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent arg0) {
      int i = JOptionPane.showConfirmDialog(frame, "Do you wish to exit?",
          "Confirm Exit", JOptionPane.YES_NO_OPTION);
      if(i == JOptionPane.YES_OPTION) System.exit(0);
      else frame.repaint();
    }
  }
  
  /**
   * Select the list of grade objects from the list of all Evaluations, whose 
   * type is the specified EvaluationType, QUIZ, LAB, etc. Remove the
   * number of objects specified by the numDropped field. Find the average
   * score for the remaining objects and return its contribution to the final
   * grade. For example, the average grade of quizzes will be a value between 0
   * and 5 and that score is exactly the 5% contribution to the final grade; 
   * the average grade of assignments will be a value between 0 and 10. Since 
   * assignments contribute 30% to the final grade, the assignment average is 
   * multiplied by a contributionFactor of 3.
   * 
   * @param t the EvaluationType to select from the list of Evaluations
   * @param list a list of Evaluations
   * @return the contribution to the final grade of this EvaluationType 
   */
  public static double computePartialGrade(EvaluationType t, ArrayList<Evaluation> list) {
      double returnValue = 0;
      if (list != null && list.size() > 0) {
          ArrayList<Evaluation> sublist = new ArrayList<Evaluation>();
          for(Evaluation e : list) {
              if(e.type == t) {
                  sublist.add(e);
              }
          }
          Collections.sort(sublist, new EvaluationComparator());
          System.out.println(sublist);
          for(int i = 0; i < t.getNumDropped(); i++) {
              if(sublist.size() > 0) {
                  sublist.remove(0);
              }
          }
          System.out.println(sublist);
          double sum = 0.0;
          for(Evaluation e : sublist) {
              sum += e.getScore();
          }
          if(sublist.size() > 0) {
              returnValue = sum/sublist.size() * t.getContributionFactor();
          }
      }
      return returnValue;
  }
  
  public class ComputeListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
      ArrayList<Evaluation> list = new ArrayList<Evaluation>();
      ArrayList<Evaluation> maxList = new ArrayList<Evaluation>();
      looping: for(EvaluationType eval : EvaluationType.values()) {
        for(JTextField field : eMapTextFields.get(eval)) {
          String text = field.getText().trim();
          String value = text;
          if(value.length() == 0){
            value = "0";
          }
          Scanner scanner = new Scanner(value);
          if(scanner.hasNextDouble()) {
            list.add(eval.makeGradeObject(scanner.nextDouble()));
            maxList.add(eval.makeMaxGradeObject(text.length() == 0));
          } else {
            JOptionPane.showMessageDialog(frame, 
                "The " + eval.toString() + " field containing" +
                " the text: " + text +  
                "\ncould not be scanned as a number.",
                "Data Error", JOptionPane.WARNING_MESSAGE);
            break looping;
          }
          scanner.close();
        }
      }
      double totalGrade = 0.0;
      double maxGrade = 0.0;
      
      for(EvaluationType eval : EvaluationType.values()){
        totalGrade += computePartialGrade(eval,list);
        maxGrade += computePartialGrade(eval, maxList);
      }
      
      System.out.print(totalGrade);
      System.out.print(maxGrade);
      
      if(maxGrade > 0){
        totalGrade = 100*(totalGrade/maxGrade);
      }
      
      if(totalGrade >= 93) {
        finalGrade.setText("Approximate final letter grade is A");
      } else if(totalGrade >= 90) {
        finalGrade.setText("Approximate final letter grade is A-");
      } else if(totalGrade >= 87.5) {
        finalGrade.setText("Approximate final letter grade is B+");
      } else if(totalGrade >= 82.5) {
        finalGrade.setText("Approximate final letter grade is B");
      } else if(totalGrade >= 80) {
        finalGrade.setText("Approximate final letter grade is B-");
      } else if(totalGrade >= 77.5) {
        finalGrade.setText("Approximate final letter grade is C+");
      } else if(totalGrade >= 72.5) {
        finalGrade.setText("Approximate final letter grade is C");
      } else if(totalGrade >= 70) {
        finalGrade.setText("Approximate final letter grade is C-");
      } else if(totalGrade >= 65) {
        finalGrade.setText("Approximate final letter grade is D");
      } else {
        finalGrade.setText("Approximate final letter grade is F");
      }
    }

    
  }
  
}
