package assignment06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;


public class GUIMachine extends Observable {
 public final Instruction[] INSTRUCTION_SET = new Instruction[16];
 private States state;
 private JFrame frame;
 private Processor proc = new Processor();
 private Memory memory = new Memory();
 private boolean running = false;

 private MenuBarBuilder menuBuilder;

 public GUIMachine() {
     INSTRUCTION_SET[0] = new NOP(proc, memory);
     INSTRUCTION_SET[1] = new LOD(proc, memory);
     INSTRUCTION_SET[2] = new STO(proc, memory);
     INSTRUCTION_SET[3] = new ADD(proc, memory);
     INSTRUCTION_SET[4] = new SUB(proc, memory);
     INSTRUCTION_SET[5] = new MUL(proc, memory);
     INSTRUCTION_SET[6] = new DIV(proc, memory);
     INSTRUCTION_SET[7] = new AND(proc, memory);
     INSTRUCTION_SET[8] = new NOT(proc, memory);
     INSTRUCTION_SET[9] = new CMPZ(proc, memory);
     INSTRUCTION_SET[10] = new CMPL(proc, memory);
     INSTRUCTION_SET[11] = new JUMP(proc, memory);
     INSTRUCTION_SET[12] = new JMPZ(proc, memory);
     INSTRUCTION_SET[15] = new HALT(proc, memory);
     ((HALT)INSTRUCTION_SET[15]).setGmachine(this);
//a lot more code to come here...
     createAndShowGUI();
 }

 public void halt() {
     running = false;
 }

 private void createAndShowGUI() {
     frame = new JFrame("Pippin Simulator");
     Container content = frame.getContentPane();
     content.setLayout(new BorderLayout(1,1));
     content.setBackground(Color.BLACK);
     frame.setSize(800,600);

     menuBuilder = new MenuBarBuilder(this);

     JMenuBar bar = new JMenuBar();
     frame.setJMenuBar(bar);
     bar.add(menuBuilder.createMenu1());
     bar.add(menuBuilder.createMenu2());

     frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     frame.addWindowListener(new ExitAdapter());
     state = States.NOTHING_LOADED;
     state.enter();
     setChanged();
     notifyObservers();
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);

 }

 public States getState() {
     return state;
 }

 public void setState(States state) {
     this.state = state;
 }

 public boolean isRunning() {
     return running;
 }

 public void setRunning(boolean running) {
     this.running = running;
 }

 public static void main(String[] args) {
     javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             new GUIMachine();
         }
     });
 }

 public void exit() { // method executed when user exits the program
     int decision = JOptionPane.showConfirmDialog(
             frame,
             "Do you really wish to exit?",
             "Confirmation",
             JOptionPane.YES_NO_OPTION);
     if (decision == JOptionPane.YES_OPTION) {
         System.exit(0);
     }
 }

 public void assembleFile() {
     //WILL BE REPLACED BY A BETTER TECHNIQUE LATER

     String fileName = JOptionPane.showInputDialog("File name to assemble");
     File asm = new File(fileName.trim());
     if(asm.exists()) {
         File exe = new File("temp.pexe");
         if (!Assembler.assemble(asm, exe)) {
             JOptionPane.showMessageDialog(
                     frame,
                     "The file being selected has problems.\n" +
                             "Cannot assemble the program",
                             "Warning",
                             JOptionPane.WARNING_MESSAGE);

         }
     }
 }

 public void loadFile() throws CodeAccessException, DataAccessException {

     //WILL BE REPLACED BY A BETTER TECHNIQUE

     Loader.load(memory, new File("temp.pexe"));
     setRunning(true);
     state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
     state.enter();
     setChanged();
     notifyObservers();

     // IF YOUR load METHOD THROWS FileNotFoundException, USE THIS CODE INSTEAD 

     //      try {
     //      Loader.load(memory, new File("temp.pexe"));
     //          setRunning(true);
     //      state = States.PROGRAM_LOADED_NOT_AUTOSTEPPING;
     //      state.enter();
     //      setChanged();
     //      notifyObservers();
     //      } catch (IOException e) {
     //          JOptionPane.showMessageDialog(
     //                  frame, 
     //                  "The file being selected has problems.\n" +
     //                          "Cannot load the program",
     //                          "Warning",
     //                          JOptionPane.WARNING_MESSAGE);
     //      }           

 }

 public void execute() {
     // WILL BE REPLACED LATER
     int pc = 0;
     int arg = 0;
     try {
         while(running) {
             pc = proc.getProgramCounter();
             int opcode = memory.getOpcode(pc);
             Instruction in = INSTRUCTION_SET[opcode/4]; 
             arg = memory.getArg(pc);
             boolean immediate = opcode % 2 == 1;
             boolean indirect = (opcode/2) % 2 == 1;
             in.execute(arg, immediate, indirect);
         }
     } catch(CodeAccessException e) {
         JOptionPane.showMessageDialog(
                 frame,
                 "Code Access Exception for program counter " + pc,
                 "Warning",
                 JOptionPane.WARNING_MESSAGE);

     } catch(DataAccessException e) {
         JOptionPane.showMessageDialog(
                 frame,
                 "Data Access Exception for argument " + arg,
                 "Warning",
                 JOptionPane.WARNING_MESSAGE);

     }
     System.out.println("Content of Data Memory after execution");
     try {
         for(int i = 0; i < 32; i++) {
             for(int j = 0; j < 16; j++) {
                 System.out.print(16*i+j + ":" + memory.getData(16*i+j) + "\t|");
             }
             System.out.println();
         }
     } catch(DataAccessException e) {
         // not expected at all
         e.printStackTrace();
     }
 }
 
 private class ExitAdapter extends WindowAdapter {
     @Override
     public void windowClosing(WindowEvent arg0) {
         exit();
     }
 }
}
