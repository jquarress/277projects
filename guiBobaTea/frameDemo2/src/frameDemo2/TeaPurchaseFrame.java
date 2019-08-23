package frameDemo2;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * the tea frame that will display options for customizing the tea item and extends the newItemFrame
 * @author justin
 *
 */
public class TeaPurchaseFrame extends newItemFrame{
	private JLabel instructions;
	private JCheckBox boba;
	private JComboBox<String> sweetness;
	private static JComboBox<String> size;
	private JComboBox<String> milkBase;
	private JComboBox<String> base;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel milkType;
	private JLabel sweetnessCount;
	private JLabel sizeLabel;
	private JCheckBox pop;
	private JCheckBox grass;
	private JCheckBox lychee;
	private JCheckBox coconut;
	private JCheckBox mochi;
	newItemFrame all = new newItemFrame();
	TeaItem bobaTea = new TeaItem();
	/**
	 * default constructor adding components and setting up the frame
	 */
	public TeaPurchaseFrame() {
		createComponents();
		this.setTitle("New Tea Order");
		this.setSize(950,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * method to create the components for the panel, create listeners for the components, 
	 * add the components to panel, and finally add panel to the frame 
	 */
	private void createComponents() {
		instructions = new JLabel("Specify the Tea Order: type:");
		String[] b = {"choose one", "green tea", "black tea", "jasmine", "rose tea", "oolong tea"};
		base = new JComboBox<String>(b);
		sizeLabel = new JLabel("Size:");
		String[] s = {"choose one","Small","Medium","Large"};
		size = new JComboBox<String>(s);
		sweetnessCount = new JLabel("Sweetness Level:");
		String[] numTeaspoons = {"choose one", "Unsweetened", "1/4 sweet", "1/2 sweet", "3/4 sweet", "Full sweet"};
		sweetness = new JComboBox<String>(numTeaspoons);
		milkType = new JLabel("Milk Type:");
		String[] bases = {"choose one", "no milk", "whole milk", "half-and-half"};
		milkBase = new JComboBox<String>(bases);
		saveButton = new JButton ("save");
		cancelButton = new JButton ("cancel");
		boba = new JCheckBox("boba");
		pop = new JCheckBox("popping boba");
		grass = new JCheckBox("grass jelly");
		lychee = new JCheckBox("lychee jelly");
		coconut = new JCheckBox("coconut jelly");
		mochi = new JCheckBox("mini mochi");
		
		ActionListener saveListener = new saveButtonListener();
		saveButton.addActionListener(saveListener);// adding reaction instruction to our button
		ActionListener cancelListener = new cancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		ActionListener toppingListener = new toppingListener();
		boba.addActionListener(toppingListener);
		pop.addActionListener(toppingListener);
		grass.addActionListener(toppingListener);
		lychee.addActionListener(toppingListener);
		coconut.addActionListener(toppingListener);
		mochi.addActionListener(toppingListener);
		ItemListener itemListen = new itemChangeListener();
		base.addItemListener(itemListen);
		size.addItemListener(itemListen);
		sweetness.addItemListener(itemListen);
		milkBase.addItemListener(itemListen);
		
		
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(base);
		panel.add(sizeLabel);
		panel.add(size);
		panel.add(sweetnessCount);
		panel.add(sweetness);
		panel.add(milkType);
		panel.add(milkBase);
		panel.add(saveButton);
		panel.add(cancelButton);
		panel.add(boba);
		panel.add(pop);
		panel.add(grass);
		panel.add(lychee);
		panel.add(coconut);
		panel.add(mochi);
		
		this.add(panel);
		
	}
	//innner class event listener
	/**
	 * action listener that listens to the save button and adds the string text of the order to the textarea
	 * @author justin
	 *
	 */
	class saveButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent click) {
			// close this frame but not the program on click
			//the parameter e of the type ActionEvent refers to the actual click
			all.receiptItems("-");
			all.receiptItems("-------------------------------------------------------Current Order------------------------------------------------------------\n\n");
			cashRegister.setReceipt(bobaTea.toString());
			all.receiptItems(cashRegister.getReceipt());
			TeaItem tea = new TeaItem();
			cashRegister.setCost(tea.getCost());
			String subString = String.format("$%.2f", cashRegister.getCost());
			all.receiptItems("\n\n\t\t\t\t      SubTotal: " + subString + "\n");
			setVisible(false);// sets the visibility to false meaning hide the frame
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
	 * topping listener class that implements the action listener and adds toppings to the array of toppings
	 * @author justin
	 *
	 */
	class toppingListener implements ActionListener{
		public void actionPerformed(ActionEvent click) {
			// close this frame but not the program on click
			//the parameter e of the type ActionEvent refers to the actual click
			
			if (click.getSource() instanceof JCheckBox) {
				if(click.getSource() == boba) {
					bobaTea.addTopping("boba ");
				}
				if(click.getSource() == pop) {
					bobaTea.addTopping("popping boba ");
				}
				if(click.getSource() == grass) {
					bobaTea.addTopping("grass jelly ");
				}
				if(click.getSource() == lychee) {
					bobaTea.addTopping("lychee jelly ");
				}
				if(click.getSource() == coconut) {
					bobaTea.addTopping("coconut jelly ");
				}
				if(click.getSource() == mochi) {
					bobaTea.addTopping("mini mochi ");
				}
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
					bobaTea.setFlavor((String) base.getSelectedItem());
				}else if(event.getSource() == size){
					Object item = size.getSelectedItem();
					bobaTea.setSize((String) size.getSelectedItem());
				}else if(event.getSource() == sweetness){
					bobaTea.setSweetness((String) sweetness.getSelectedItem());
				}else if(event.getSource() == milkBase) {
					bobaTea.setMilk((String) milkBase.getSelectedItem());
				}
			}
		}	
	}
}
