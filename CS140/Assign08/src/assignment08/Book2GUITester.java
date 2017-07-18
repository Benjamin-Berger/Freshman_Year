package assignment08;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Book2GUITester {
    private JFrame frame = new JFrame("Book Data");
    private JTextField titleFld = new JTextField(25);
    private JTextField numPgs = new JTextField(25);
    private JPanel reqdPanel  = new JPanel();
    private JCheckBox check = new JCheckBox("Check here ");
    private JTextField bookmarkPage = new JTextField(25);
    FileOutputStream outfile; 
    PrintWriter output;

    public Book2GUITester () {
        try {
            outfile = new FileOutputStream("books.txt", true);
            output = new PrintWriter(outfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(0,1));
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0,1));
        leftPanel.add(new JLabel(" Book Title: ", JLabel.RIGHT));
        leftPanel.add(new JLabel(" Number of Pages: ", JLabel.RIGHT));
        leftPanel.add(new JLabel(" Required: ", JLabel.RIGHT));
        leftPanel.add(new JLabel(" Bookmark Page: ", JLabel.RIGHT));
        frame.add(leftPanel);

        rightPanel.add(titleFld);
        rightPanel.add(numPgs);
        rightPanel.add(reqdPanel);
        reqdPanel.add(check);
        rightPanel.add(bookmarkPage);
        frame.add(rightPanel, BorderLayout.LINE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Book2GUITester();
    }
}