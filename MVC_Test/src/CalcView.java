import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

class CalcView extends JFrame {
	private static final long serialVersionUID = 1L;
//as2
    private JTextField 	userInputTf 	= new JTextField(5);
    private JTextField 	userInput2Tf 	= new JTextField(5);
    private JTextField 	totalTf     	= new JTextField(20);
    private JButton	   	addBtn			= new JButton("Add");
    private JButton    	subtractBtn  	= new JButton("Subtract");
    private JButton    	multiplyBtn 	= new JButton("Multiply");
    private JButton	   	divideBtn		= new JButton("Divide");
    private JButton    	clearBtn    	= new JButton("Clear");
    
    private CalcModel model;
    
    CalcView(CalcModel model) {
        this.model = model;
        
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        
        totalTf.setText(String.valueOf(model.getValue()));
        totalTf.setEditable(false);
        
        JPanel content = new JPanel();
        content.setLayout(fl);
        content.add(new JLabel("Input"));
        content.add(userInputTf);
        content.add(userInput2Tf);
        content.add(addBtn);
        content.add(subtractBtn);
        content.add(multiplyBtn);
        content.add(divideBtn);
        content.add(new JLabel("Total"));
        content.add(totalTf);
        content.add(clearBtn);
        
        addBtn.setMnemonic(KeyEvent.VK_F1);
        subtractBtn.setMnemonic(KeyEvent.VK_F2);
        multiplyBtn.setMnemonic(KeyEvent.VK_F3);
        divideBtn.setMnemonic(KeyEvent.VK_F4);
        
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Simple Calc - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void reset() {
        totalTf.setText("");
    }
    
    public void setLookAndFeel() {
    	try {
    		 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String getUserInput() {
    	return userInputTf.getText();
    }
    
    public String getUserInput2() {
    	return userInput2Tf.getText();
    }
    
    public void setTotal(String newTotal) {
    	totalTf.setText(newTotal);
    }
    
    public void showError(String errMessage) {
    	JOptionPane.showMessageDialog(this, errMessage);
    }
    
    public void addOperationListener(ActionListener op) {
    	addBtn.addActionListener(op);
    	subtractBtn.addActionListener(op);
    	multiplyBtn.addActionListener(op);
    	divideBtn.addActionListener(op);
    }
    
    public void addClearListener(ActionListener cal) {
    	clearBtn.addActionListener(cal);
    }
}















