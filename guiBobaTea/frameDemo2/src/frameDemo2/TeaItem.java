package frameDemo2;

import java.util.ArrayList;
/**
 * sub class tea item that extends the drink item superclass and keeps track of the drink item created. 
 * @author justin
 *
 */
public class TeaItem extends DrinkItem{
	private ArrayList<String> toppingsList = new ArrayList<String>();
	/**
	 * default constructor used to create tea item objects.
	 */
	public TeaItem() {
	}
	/**
	 * overloaded constructor used to set paramters of the customizations to the variable 
	 * @param size - string of size chosen
	 * @param flavor - string of flavor chosen
	 * @param sweetness - string of sweetness chosen
	 * @param milk - string of milk type chosen
	 */
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		this.size = size;
		this.flavor = flavor;
		
		this.sweetness = sweetness;
		this.milk = milk;		
	}
	/**
	 * gets the cost of the item and returns the double cost depending on the size
	 */
	public double getCost() {
		if(size == "Small") {
			cost = 2.5;
			cost = cost + toppingsList.size() * 0.25;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			return cost;
		}
		if(size == "Medium") {
			cost = 3.0;
			cost = cost + toppingsList.size() * 0.25;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			return cost;
		}
		if(size == "Large") {
			cost = 3.5;
			cost = cost + toppingsList.size() * 0.25;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			return cost;
		}
		
		return cost;
	}
	/**
	 * keeps track of the toppings chosen and adds them to an array list of toppings
	 * @param topping - string of toppings 
	 */
	public void addTopping(String topping) {
		toppingsList.add(topping);
	}
	/**
	 * to string to put together how the order will be displayed on the text area
	 */
	public String toString() {
		String subString = String.format("$%.2f", getCost());
		return "\n\t --" + flavor + "(" + size + "):" + "\t\t\t" + subString + "\n" +
				"\t\t Sweetness: " + sweetness + "\n" + 
				"\t\t Milk: " + milk + "\n" +
				"\t   Toppings: " + toppingsList + "\n\n";
	}

}
