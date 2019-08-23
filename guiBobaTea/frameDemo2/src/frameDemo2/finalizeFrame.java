package frameDemo2;

import java.awt.Component;
import java.awt.ComponentOrientation;
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
 * sets up the final frame made for entering the payment.
 * @author justin quarress
 *
 */
public class finalizeFrame extends newItemFrame{
	private JLabel instruction;
	private JLabel enterHere;
	private ArrayList<String> item = new ArrayList<String>();
	private JTextField finalizeField;
	private JButton payButton;
	private String text;
	private String info = "";
	private JScrollPane scroll;
	private JTextArea receipt;
	private double topTotal;
	private double tax;
	private double total;
	private double subtotal;
	private double fieldText;
	private double amountDue;
	private double newAmountDue;
	private double totalPaid;
	public JPanel p = new JPanel();
	
	/**
	 * default constructor that adds components and sets up the custom frame.
	 */
	public finalizeFrame() {
		createComponents();// creating the components and adding them to this frame
		enterHere = new JLabel("Enter Amount Due Here");
		payButton  = new JButton("Pay");
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
		topTotal = cashRegister.getCost()*0.10 + cashRegister.getCost();
		String topString = String.format("$%.2f", topTotal);
		instruction = new JLabel ("Amount Due: " + topString);
		enterHere = new JLabel("Enter Amount Due Here");
		payButton  = new JButton("Pay");
		receipt = new JTextArea(items, 40, 55);
		scroll = new JScrollPane(receipt);
		receipt.setEditable(false);
		finalizeField = new JTextField(10);
		
		ActionListener fieldListener = new fieldListener();
		finalizeField.addActionListener(fieldListener);
		ActionListener buttonListener = new buttonListener();
		payButton.addActionListener(buttonListener);
		
		
		p.add(instruction);
		p.add(scroll);
		p.add(enterHere);
		p.add(finalizeField);
		p.add(payButton);
		this.add(p);// adding the panel to the frame
	}
	/**
	 * action listener that uses the button that takes the number added to the text field to make the payment calculations
	 * @author justin
	 *
	 */
	class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent click) {
			
			Component b1 = (JButton) click.getSource();// this returns the button object from the source. i.e button object/one reponsible for event
			//we want the button because we want to know which frame the button is located. that way we can close frame
			finalizeFrame frame = (finalizeFrame) SwingUtilities.getRoot(b1);
			tax = cashRegister.getCost()*0.10;
			total = cashRegister.getCost() + tax;
			fieldText = Double.parseDouble(finalizeField.getText().trim());
			totalPaid = totalPaid + fieldText;
			amountDue = total - totalPaid;

			String amtInput = String.format("$%.2f", totalPaid);
			if (amountDue == 0) {
				frame.instruction.setText("Thank You");
				total = 0;
				String subString = String.format("$%.2f", total);
				items = items + ("\n\t\t\t\t      Amount Paid: " + amtInput);
				items = items + ("\n\t\t\t\t      Change Due: " + subString);
				items = items + ("\n\n------------------------------------------------Thank You For Your Order---------------------------------------------------");
				setVisible(false);
				thankYouFrame bleh = new thankYouFrame();
				bleh.setVisible(true);
			}
			else if(amountDue > 0) {
				String amtDue = String.format("$%.2f", amountDue);
					frame.instruction.setText("you have not entered enough. you still owe " + amtDue);
					
			}else if (amountDue < 0) {
				frame.instruction.setText("Thank You");
				amountDue = totalPaid - total;
				String subString = String.format("$%.2f", amountDue);
				items = items + ("\n\t\t\t\t      Amount Paid: " + amtInput);
				items = items + ("\n\t\t\t\t      Change Due: " + subString);
				items = items + ("\n\n------------------------------------------------Thank You For Your Order---------------------------------------------------");
				setVisible(false);
				thankYouFrame bleh = new thankYouFrame();
				bleh.setVisible(true);
			}
			
		}
	}
	/**
	 * action listener that uses the enter key pressed and that takes the number added to the text field to make the payment calculations
	 * @author justin
	 *
	 */
	class fieldListener implements ActionListener{

		public void actionPerformed(ActionEvent field) {
			
			tax = cashRegister.getCost()*0.10;
			total = cashRegister.getCost() + tax;
			fieldText = Double.parseDouble(finalizeField.getText().trim());
			totalPaid = totalPaid + fieldText;
			amountDue = total - totalPaid;

			String amtInput = String.format("$%.2f", totalPaid);
			if (amountDue == 0) {
				instruction.setText("Thank You");
				total = 0;
				String subString = String.format("$%.2f", total);
				items = items + ("\n\t\t\t\t      Amount Paid: " + amtInput);
				items = items + ("\n\t\t\t\t      Change Due: " + subString);
				items = items + ("\n\n------------------------------------------------Thank You For Your Order---------------------------------------------------");
				setVisible(false);
				thankYouFrame bleh = new thankYouFrame();
				bleh.setVisible(true);
			}
			else if(amountDue > 0) {
				String amtDue = String.format("$%.2f", amountDue);
					instruction.setText("you have not entered enough. you still owe " + amtDue);
					
			}else if (amountDue < 0) {
				instruction.setText("Thank You");
				amountDue = totalPaid - total;
				String subString = String.format("$%.2f", amountDue);
				items = items + ("\n\t\t\t\t      Amount Paid: " + amtInput);
				items = items + ("\n\t\t\t\t      Change Due: " + subString);
				items = items + ("\n\n------------------------------------------------Thank You For Your Order---------------------------------------------------");
				setVisible(false);
				thankYouFrame bleh = new thankYouFrame();
				bleh.setVisible(true);
			}
		}
	}
}
