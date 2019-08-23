package frameDemo2;
/**
 * coffee sub classs that extends the drink item superclass and holds the customizations for the coffee order
 * @author justin
 *
 */
public class CoffeeItem extends DrinkItem{
	private String temp;
	private String specialInstruction;
	/**
	 * default constructor that is used to create the coffee item objects
	 */
	public CoffeeItem() {
	}
	/**
	 * overloaded constructor used to create the customizations to the orders via the parameters and adds the parameters to the variables
	 * @param flavor - holds the string name of the flavor
	 * @param size - holds the size string
	 * @param sweetness - holds sweetness string
	 * @param milk - holds the name of the type of milk in a string
	 * @param temp - string of the type of temp chosen
	 * @param specialInstruction - string of the special instructions input
	 */
	public CoffeeItem(String flavor, String size, String sweetness, String milk, String temp, String specialInstruction) {
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
		this.temp = temp;
		this.specialInstruction = specialInstruction;
	}
	/**
	 * used to get the cost of the item and return it
	 * @return - the price of the item
	 */
	public double getCost() {
		if(size == "Small") {
			cost = 1.00;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			if(temp == "Blended") {
				cost = cost + 0.25;
			}
			return cost;
		}
		if(size == "Medium") {
			cost = 1.5;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			if(temp == "Blended") {
				cost = cost + 0.25;
			}
			return cost;
		}
		if(size == "Large") {
			cost = 2.0;
			if(milk == "whole milk" || milk == "half-and-half") {
				cost = cost + 0.25;
			}
			if(temp == "Blended") {
				cost = cost + 0.25;
			}
			return cost;
		}
		
		return cost;
	}
	/**
	 * sets the temperature choice stored in parameter and sets it equal to the temp variable
	 * @param temp - string that keeps track of the temp choice made
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	/**
	 * sets the strings added to the comments parameter and set that equal to the specialInstructions variable
	 * @param comments - string of the instructions added to the textfield
	 */
	public void setComments(String comments) {
		specialInstruction = comments;
	}
	/**
	 * to string to put together how the order will be displayed on the text area
	 */
	public String toString() {
		String subString = String.format("$%.2f", getCost());
		return "\n\t --" + flavor + "(" + size + "):" + "\t\t\t" + subString + "\n" +
				"\t\t Sweetness: " + sweetness + "\n" + 
				"\t\t Milk: " + milk + "\n" +
				"\t\t Temp: " + temp + "\n" +
				"\t   Special Instructions: " + specialInstruction + "\n\n";
	}
	
}
