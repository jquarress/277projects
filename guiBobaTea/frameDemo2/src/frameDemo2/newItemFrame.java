package frameDemo2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//must extend JFrame and import of course
/**
 * sets up the new order frame made for displaying the receipt. extends JFrame
 * @author justin quarress
 *
 */
public class newItemFrame extends startFrame {
	private JLabel instruction;
	private JButton coffeeButton;
	private JButton bobaButton;
	private JTextArea receipt;
	protected static String items = "";
	private JButton pastryButton;
	private JButton doneButton;
	private JScrollPane scroll;
	private String text;
	private double tax;
	private double total;
	public static int orderCount;
	public JPanel p = new JPanel();
	
	/**
	 * default constructor that adds components and sets up the custom frame.
	 */
	public newItemFrame() {
		createComponents();// creating the components and adding them to this frame
		instruction = new JLabel ("Choose Item Type: ");
		coffeeButton = new JButton("coffee");
		bobaButton = new JButton("boba");
		pastryButton = new JButton("pastry");
		doneButton = new JButton("Done");
		receipt = new JTextArea();
		receipt.setEditable(false);
		this.setTitle("new order");
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	/**
	 * used to set the items that will be added to the text area
	 * @param items - string of items set to the 
	 */
	public void receiptItems(String items) {
		if (items == "-") {
			this.items = items;
			text = receipt.getText();
			receipt.setText(text);
		}else {
		this.items = this.items + items;
		text = receipt.getText();
		receipt.setText(text);
		}
	}
	/**
	 * method to create the components for the panel, create listeners for the components, 
	 * add the components to panel, and finally add panel to the frame 
	 */
	private void createComponents() {
		instruction = new JLabel ("Choose Item Type: ");
		coffeeButton = new JButton("coffee");
		bobaButton = new JButton("boba");
		pastryButton = new JButton("pastry");
		doneButton = new JButton("Done");
		receipt = new JTextArea(items, 40, 55);
		scroll = new JScrollPane(receipt);
		receipt.setEditable(false);
		
		ActionListener coffeeListener = new coffeeListener();
		coffeeButton.addActionListener(coffeeListener);
		ActionListener teaListener = new teaListener();
		bobaButton.addActionListener(teaListener);
		ActionListener pastryListener = new pastryListener();
		pastryButton.addActionListener(pastryListener);
		ActionListener doneListener = new doneListener();
		doneButton.addActionListener(doneListener);
		
		p.add(instruction);// adding the instruction label to panel
		p.add(coffeeButton);//adding coffee button to panel
		p.add(bobaButton);//adding boba button to panel
		p.add(pastryButton);
		p.add(scroll);
		p.add(doneButton);
		this.add(p);// adding the panel to the frame
	}
	/**
	 * done button using the action listener to finish the order and move on to the finalize frame
	 * @author justin
	 *
	 */
	class doneListener implements ActionListener{

		public void actionPerformed(ActionEvent doneButton1) {
			setVisible(false);
			tax = cashRegister.getCost()*0.10;
			total = cashRegister.getCost() + tax;
			String subString = String.format("$%.2f", total);
			String taxString = String.format("$%.2f", tax);
			items = items + ("\n\t\t\t\t      Tax Total: " + taxString);
			items = items + ("\n\t\t\t\t      Grand Total: " + subString);
			finalizeFrame bleh = new finalizeFrame();
			bleh.setVisible(true);
		}
	}
	// innner class: action listener class
	/**
	 * the coffee button listener that will open a coffee purchase frame when pressed
	 * @author justin quarress
	 *
	 */
	class coffeeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent coffeeButton) {
			//when the coffee is pushed open a different frame with drop down menus for the different coffee options
			setVisible(false);
			coffeePurchaseFrame coffeeFrame = new coffeePurchaseFrame();
			coffeeFrame.setVisible(true);
			coffeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	/**
	 * the tea button listener that opens the tea purchase frame when pressed
	 * @author justin quarress
	 *
	 */
	class teaListener implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent teaButton) {
			//when the coffee is pushed open a different frame with drop down menus for the different coffee options
			TeaPurchaseFrame teaFrame = new TeaPurchaseFrame();
			setVisible(false);
			teaFrame.setVisible(true);
			teaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p.add(doneButton);
			
		}
	}
	/**
	 * the pastry button listener that opens the pastry purchase frame when pressed
	 * @author justin quarress
	 *
	 */
	class pastryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent pastryButton) {
			//when the coffee is pushed open a different frame with drop down menus for the different coffee options
			setVisible(false);
			PastryPurchaseFrame pastryFrame = new PastryPurchaseFrame();
			pastryFrame.muffinFlavor.setVisible(false);
			pastryFrame.cookieFlavor.setVisible(false);
			pastryFrame.danishFlavor.setVisible(false);
			pastryFrame.cheesecakeFlavor.setVisible(false);
			pastryFrame.heatedAnswer.setVisible(false);
			pastryFrame.saveButton.setVisible(false);
			pastryFrame.heated.setVisible(false);
			pastryFrame.setVisible(true);
			pastryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
}