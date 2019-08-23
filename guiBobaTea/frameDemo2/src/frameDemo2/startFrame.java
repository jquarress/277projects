package frameDemo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * the starting frame that extends JFrame and contains only 3 buttons and a hidden done button 
 * @author justin quarress
 *
 */
public class startFrame extends JFrame{
	private JLabel instruction;
	private JButton coffeeButton;
	private JButton bobaButton;
	private JButton pastryButton;
	JButton doneButton;
	public JPanel p = new JPanel();

	/**
	 * default constructor with added components used to create the start frame
	 */
	public startFrame() {
		createComponents();// creating the components and adding them to this frame
		this.setTitle("new order");
		this.setSize(600, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * create the components and button listeners then add the components to the panel and add the panel to the frame
	 */
	private void createComponents() {
		instruction = new JLabel ("Choose Item Type: ");
		coffeeButton = new JButton("coffee");
		bobaButton = new JButton("boba");
		pastryButton = new JButton("pastry");
		doneButton = new JButton("Done");
		
		ActionListener coffeeListener = new coffeeListener();
		coffeeButton.addActionListener(coffeeListener);
		ActionListener teaListener = new teaListener();
		bobaButton.addActionListener(teaListener);
		ActionListener pastryListener = new pastryListener();
		pastryButton.addActionListener(pastryListener);
		ActionListener buttonListener = new buttonListener();
		doneButton.addActionListener(buttonListener);
		
		
		p.add(instruction);// adding the instruction label to panel
		p.add(coffeeButton);//adding coffee button to panel
		p.add(bobaButton);//adding boba button to panel
		p.add(pastryButton);
		p.add(doneButton);
		this.add(p);// adding the panel to the frame
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
			pastryFrame.setVisible(true);
			pastryFrame.muffinFlavor.setVisible(false);
			pastryFrame.cookieFlavor.setVisible(false);
			pastryFrame.danishFlavor.setVisible(false);
			pastryFrame.cheesecakeFlavor.setVisible(false);
			pastryFrame.heatedAnswer.setVisible(false);
			pastryFrame.saveButton.setVisible(false);
			pastryFrame.heated.setVisible(false);
			pastryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	/**
	 * the done button listener that terminates the program when pressed
	 * @author justin quarress
	 *
	 */
	class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent click) {
			//setVisible(false);
			System.exit(0);
		}
	}

}
