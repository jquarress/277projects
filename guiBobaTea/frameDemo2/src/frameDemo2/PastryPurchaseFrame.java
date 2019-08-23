package frameDemo2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * pastry frame used to create and add pastrys to the order
 * @author justin
 *
 */

public class PastryPurchaseFrame extends newItemFrame {
	private JLabel instructions;
	private JComboBox<String> type;
	JComboBox<String> muffinFlavor;
	JComboBox<String> cookieFlavor;
	JComboBox<String> cheesecakeFlavor;
	JComboBox<String> danishFlavor;
	JCheckBox heatedAnswer;
	JButton saveButton;
	private JButton cancelButton;
	JLabel heated;
	
	newItemFrame all = new newItemFrame();
	PastryItem pastry = new PastryItem();
	/**
	 * default constructor with components added and used to make pastry objects
	 */
	public PastryPurchaseFrame() {
		createComponents();
		this.setTitle("New Pastry Order");
		this.setSize(900,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * method to create the components for the panel, create listeners for the components, 
	 * add the components to panel, and finally add panel to the frame 
	 */
	private void createComponents() {
		instructions = new JLabel("Specify the Type:");
		String[] t = {"Choose Option", "Muffin","Cookie","Cheesecake Slice", "Danish"};
		type = new JComboBox<String>(t);
		String[] m = {"Choose Option", "Banana Nut","Blueberry","Chocolate Chip", "Coffee Cake"};
		muffinFlavor = new JComboBox<String>(m);
		String[] c = {"Choose Option", "Oatmeal","White Choco & Macadamias","Chocolate Chip", "Double Fudge"};
		cookieFlavor = new JComboBox<String>(c);
		String[] e = {"Choose Option", "Regular","Cherry","Blueberry"};
		cheesecakeFlavor = new JComboBox<String>(e);
		String[] f = {"Choose Option", "Double Cheese","Apple Cinnamon","Strawberry & Cheese"};
		danishFlavor = new JComboBox<String>(f);
		heated = new JLabel("Heated:");
		String[] heat = {"Choose Option", "no", "yes"};
		heatedAnswer = new JCheckBox();
		saveButton = new JButton ("save");
		cancelButton = new JButton ("cancel");
		
		
		
		ActionListener saveListener = new saveButtonListener();
		saveButton.addActionListener(saveListener);// adding reaction instruction to our button
		ActionListener cancelListener = new cancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		ActionListener heatListener = new heatListener();
		heatedAnswer.addActionListener(heatListener);
		ItemListener itemListen = new itemChangeListener();
		type.addItemListener(itemListen);
		ItemListener flavorListen = new itemFlavListener();
		muffinFlavor.addItemListener(flavorListen);
		cookieFlavor.addItemListener(flavorListen);
		cheesecakeFlavor.addItemListener(flavorListen);
		danishFlavor.addItemListener(flavorListen);
		
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(type);
		panel.add(muffinFlavor);
		panel.add(cookieFlavor);
		panel.add(cheesecakeFlavor);
		panel.add(danishFlavor);
		panel.add(heated);
		panel.add(heatedAnswer);
		panel.add(saveButton);
		panel.add(cancelButton);
		
		this.add(panel);
		
	}
	/**
	 * action listener that listens to the save button and adds the string text of the order to the textarea
	 * @author justin
	 *
	 */
	//innner class event listener
	class saveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent click) {
			// close this frame but not the program on click
			//the parameter e of the type ActionEvent refers to the actual click
			all.receiptItems("-");
			all.receiptItems("-------------------------------------------------------Current Order------------------------------------------------------------\n\n");
			cashRegister.setReceipt(pastry.toString());
			all.receiptItems(cashRegister.getReceipt());
			PastryItem past = new PastryItem();
			cashRegister.setCost(past.getCost());
			String subString = String.format("$%.2f", cashRegister.getCost());
			all.receiptItems("\n\n\t\t\t\t      SubTotal: " + subString + "\n");
			setVisible(false);// sets the visibility to false meaning hide the frame
			newItemFrame oldFrame = new newItemFrame();
			oldFrame.setVisible(true);
			orderCount++;
		}
	}
	/**
	 * action listener that listens to the heat button and sets the boolean heat to true
	 * @author justin
	 *
	 */
	class heatListener implements ActionListener{

		public void actionPerformed(ActionEvent click) {
			if (click.getSource() instanceof JCheckBox) {
				pastry.setHeat(true);
			}
		}
	}
	/**
	 * action listener that listens to the cancel button and returns to the previous frame
	 * @author justin
	 *
	 */
	class cancelButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent click) {
			setVisible(false);
			if(orderCount == 0) {
				startFrame oldFrame = new startFrame();
				oldFrame.setVisible(true);
			}else {
				newItemFrame oldFrame = new newItemFrame();
				oldFrame.setVisible(true);
			}
		}
	}
	/**
	 * item listener that listens to the type chosen and makes visible the components accordingly
	 * @author justin
	 *
	 */
	class itemChangeListener implements ItemListener{

		public void itemStateChanged(ItemEvent click) {
			if(click.getSource() == type){
				pastry.setType((String) type.getSelectedItem());
			}
				if((String) type.getSelectedItem() == "Muffin") {
					cheesecakeFlavor.setVisible(false);
					danishFlavor.setVisible(false);
					cookieFlavor.setVisible(false);
					muffinFlavor.setVisible(true);
					heated.setVisible(true);
					heatedAnswer.setVisible(true);
					saveButton.setVisible(true);
				}if((String) type.getSelectedItem() == "Cookie") {
					muffinFlavor.setVisible(false);
					cheesecakeFlavor.setVisible(false);
					danishFlavor.setVisible(false);
					cookieFlavor.setVisible(true);
					heated.setVisible(true);
					heatedAnswer.setVisible(true);
					saveButton.setVisible(true);
				}if((String) type.getSelectedItem() == "Cheesecake Slice") {
					muffinFlavor.setVisible(false);
					cheesecakeFlavor.setVisible(true);
					danishFlavor.setVisible(false);
					cookieFlavor.setVisible(false);
					heated.setVisible(true);
					heatedAnswer.setVisible(true);
					saveButton.setVisible(true);
				}if((String) type.getSelectedItem() == "Danish") {
					muffinFlavor.setVisible(false);
					cheesecakeFlavor.setVisible(false);
					danishFlavor.setVisible(true);
					cookieFlavor.setVisible(false);
					heated.setVisible(true);
					heatedAnswer.setVisible(true);
					saveButton.setVisible(true);
				}if (click.getStateChange() == ItemEvent.SELECTED) {
					if(click.getSource() == muffinFlavor) {
						pastry.setflavor((String) muffinFlavor.getSelectedItem());
					}
					if(click.getSource() == cookieFlavor) {
						pastry.setflavor((String) cookieFlavor.getSelectedItem());
					}
					if(click.getSource() == cheesecakeFlavor) {
						pastry.setflavor((String) cheesecakeFlavor.getSelectedItem());
					}
					if(click.getSource() == danishFlavor) {
						pastry.setflavor((String) danishFlavor.getSelectedItem());
				}
			}
		}
	}
	/**
	 * item listener that listens to the flavor chosen and sets the flavor to the pastry object
	 * @author justin
	 *
	 */
	class itemFlavListener implements ItemListener{

		public void itemStateChanged(ItemEvent click) {
			
			if (click.getStateChange() == ItemEvent.SELECTED) {
				if(click.getSource() == muffinFlavor) {
					pastry.setflavor((String) muffinFlavor.getSelectedItem());
				}
				if(click.getSource() == cookieFlavor) {
					pastry.setflavor((String) cookieFlavor.getSelectedItem());
				}
				if(click.getSource() == cheesecakeFlavor) {
					pastry.setflavor((String) cheesecakeFlavor.getSelectedItem());
				}
				if(click.getSource() == danishFlavor) {
					pastry.setflavor((String) danishFlavor.getSelectedItem());	
				}
			}
		}	
	}
}
