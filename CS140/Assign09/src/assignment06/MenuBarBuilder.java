package assignment06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBarBuilder implements Observer {
    private JMenuItem assemble = new JMenuItem("Assemble Source...");
    private JMenuItem load = new JMenuItem("Load Program...");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem go = new JMenuItem("Go");
    private GUIMachine machine;

    public MenuBarBuilder(GUIMachine machine) {
        this.machine = machine;
        machine.addObserver(this);
    }

    public JMenu createMenu1() {
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        assemble.setMnemonic(KeyEvent.VK_A);
        assemble.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        assemble.addActionListener(new AssembleListener());
        menu.add(assemble);

// add the JMenuItem load, with mnemonic L, accelerator CTRL+L, and listener LoadListener()
        load.setMnemonic(KeyEvent.VK_L);
        load.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        load.addActionListener(new LoadListener());
        menu.add(load);
        
        menu.addSeparator(); // puts a line across the menu

// add the JMenuItem exit, with mnemonic E, accelerator CTRL+E, and listener ExitListener()
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exit.addActionListener(new ExitListener());
        menu.add(exit);
        
        return menu;
    }

    public JMenu createMenu2() {
// follow the structure of createMenu1: create a JMenu labeled "Execute" with the mnemonic X
// set up the go menu item with the accelerator CTRL-G, mnemonic G, listener ExecuteListener and add it to the menu
    	JMenu menu = new JMenu("Execute");
    	menu.setMnemonic(KeyEvent.VK_X);
    	
    	go.setMnemonic(KeyEvent.VK_G);
    	go.setAccelerator(KeyStroke.getKeyStroke(
    			KeyEvent.VK_G, ActionEvent.CTRL_MASK));
    	go.addActionListener(new ExecuteListener());
    	menu.add(go);

        return menu;
    }

    public void checkEnabledMenus() {
        assemble.setEnabled(machine.getState().getAssembleFileActive());
        load.setEnabled(machine.getState().getLoadFileActive());
        go.setEnabled(machine.getState().getStepActive());
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        checkEnabledMenus();
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            machine.exit();
        }
    }

    class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
				machine.loadFile();
			} catch (CodeAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    class AssembleListener implements ActionListener {
    // calls assembleFile in machine
    	 @Override
         public void actionPerformed(ActionEvent arg0) {
             machine.assembleFile();
         	}
    	 }

    class ExecuteListener implements ActionListener {
    // calls execute in machine
    	@Override
    	public void actionPerformed(ActionEvent arg0){
    		machine.execute();
    		}
    	}
    }
