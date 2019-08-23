package frameDemo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 * the coffee frame that will display options for customizing the coffee item and extends the newItemFrame
 * @author justin
 *
 */
public class coffeePurchaseFrame extends newItemFrame {
	private JLabel instructions;
	private JComboBox<String> size;
	private JComboBox<String> teaspoons;
	private JComboBox<String> milkBase;
	private JComboBox<String> base;
	private JComboBox<String> temp;
	private JTextField commentField;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel teaspoonCount;
	private JLabel milkType;
	private JLabel tempType;
	private JLabel sizeLabel;
	private JLabel fieldLabel;
	CoffeeItem coffee = new CoffeeItem();
	
	newItemFrame all = new newItemFrame();
	/**
	 * default constructor adding components and setting up the frame
	 */
	public coffeePurchaseFrame() {
		createComponents();
		this.setTitle("New Coffee Order");
		this.setSize(950,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * method to create the components for the panel, create listeners for the components, 
	 * add the components to panel, and finally add panel to the frame 
	 */
	private void createComponents() {
		instructions = new JLabel("Specify the Coffee Order: Flavor:");
		String[] b = {"choose one", "regular", "mocha", "hazelnut", "vanilla"};
		base = new JComboBox<String>(b);
		sizeLabel = new JLabel("Size:");
		String[] s = {"Choose One", "Small","Medium","Large"};
		size = new JComboBox<String>(s);
		String[] t = {"Choose One", "Hot","Iced","Blended"};
		temp = new JComboBox<String>(t);
		teaspoonCount = new JLabel("Sugar:");
		String[] numTeaspoons = {"Choose One", "1", "2", "3", "4", "5", "6", "7"};
		teaspoons = new JComboBox<String>(numTeaspoons);
		milkType = new JLabel("Milk Type:");
		tempType = new JLabel("Type:");
		String[] bases = {"Choose One", "no milk", "whole milk", "almond milk"};
		milkBase = new JComboBox<String>(bases);
		saveButton = new JButton ("save");
		cancelButton = new JButton ("cancel");
		fieldLabel = new JLabel ("Special Instructions: ");
		commentField = new JTextField(50);
		
		ActionListener saveListener = new saveButtonListener();
		saveButton.addActionListener(saveListener);// adding reaction instruction to our button
		ActionListener cancelListener = new cancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		ItemListener itemListen = new itemChangeListener();
		size.addItemListener(itemListen);
		base.addItemListener(itemListen);
		temp.addItemListener(itemListen);
		milkBase.addItemListener(itemListen);
		teaspoons.addItemListener(itemListen);
		
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(base);
		panel.add(sizeLabel);
		panel.add(size);
		panel.add(teaspoonCount);
		panel.add(teaspoons);
		panel.add(milkType);
		panel.add(milkBase);
		panel.add(tempType);
		panel.add(temp);
		panel.add(fieldLabel);
		panel.add(commentField);
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
			coffee.setComments(commentField.getText().trim());
			all.receiptItems("-");
			all.receiptItems("-------------------------------------------------------Current Order------------------------------------------------------------\n\n");
			cashRegister.setReceipt(coffee.toString());
			all.receiptItems(cashRegister.getReceipt());
			CoffeeItem coff = new CoffeeItem();
			cashRegister.setCost(coff.getCost());
			String subString = String.format("$%.2f", cashRegister.getCost());
			all.receiptItems("\n\n\t\t\t\t      SubTotal: " + subString + "\n");
			setVisible(false);// sets the visiblity to false meaning hide the frame
			newItemFrame oldFrame = new newItemFrame();
			oldFrame.setVisible(true);
			orderCount++;
			
		}
	}
	/**
	 * cancel button class that implements the action Listener and goes back to the previous frame 
	 * without adding anything to the text area.
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
	 * item change listener which just takes whatever option chosen in the combobox/ drop down menus and sets them accordingly
	 * @author justin
	 *
	 */
	class itemChangeListener implements ItemListener{

		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				if(event.getSource() == base) {
					coffee.setFlavor((String) base.getSelectedItem());
				}else if(event.getSource() == size){
					coffee.setSize((String) size.getSelectedItem());
				}else if(event.getSource() == teaspoons) {
					coffee.setSweetness((String) teaspoons.getSelectedItem());
				}else if(event.getSource() == milkBase) {
					coffee.setMilk((String) milkBase.getSelectedItem());
				}else if(event.getSource() == temp) {
					coffee.setTemp((String) temp.getSelectedItem());
				}
			}
		}	
	}
}
