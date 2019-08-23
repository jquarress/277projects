package frameDemo2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 * last frame that displays the amount of change given back and a thank you message 
 * and has a exit button that terminates the program this extends the finalize frame
 * @author justin quarress
 *
 */
public class thankYouFrame extends finalizeFrame{
	private static JTextArea receipt;
	private JLabel instruction;
	private JButton exitButton;
	private String text;
	private JScrollPane scroll;
	public JPanel p = new JPanel();
	/**
	 * default constructor that adds components and sets up the custom frame.
	 */
	public thankYouFrame() {
		createComponents();// creating the components and adding them to this frame
		exitButton  = new JButton("Exit");
		receipt = new JTextArea();
		receipt.setEditable(false);
		this.setTitle("new order");
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * used to set the items that will be added to the text area
	 */
	public void receiptItems(String items1) {
		items = items + items1;
		text = receipt.getText();
		receipt.setText(text);
	}
	/**
	 * method to create the components for the panel, create listeners for the components, 
	 * add the components to panel, and finally add panel to the frame 
	 */
	private void createComponents() {
		instruction = new JLabel ("Thank You");
		exitButton  = new JButton("Exit");
		receipt = new JTextArea(items, 40, 55);
		scroll = new JScrollPane(receipt);
		receipt.setEditable(false);
		
		ActionListener buttonListener = new buttonListener();
		exitButton.addActionListener(buttonListener);
		
		
		p.add(instruction);
		p.add(scroll);
		p.add(exitButton);
		
		this.add(p);// adding the panel to the frame
	}
	/**
	 * exit button listener that terminates the program when pressed
	 * @author justin
	 *
	 */
	class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent click) {
			System.exit(0);
		}
	}
}
