package frameDemo2;
/**
 * item superclass that contains generic things like the item name and the cost of the item
 * @author justin quarress
 *
 */
public abstract class Item {
	protected static String name;
	protected static double cost;
	/**
	 * create a abstract method that gets the cost and returns the double value.
	 * @return - return the double cost price 
	 */
	public abstract double getCost();
	/**
	 * default constructor used to create item objects
	 */
	public Item() {
	}
	/**
	 * overloaded constructor used to set the name and cost from parameters to the variables
	 * @param name - string of name of item
	 * @param cost - double of cost of item
	 */
	public Item(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}
	/**
	 * used  to set the name using param and setting the param to the name variable
	 * @param name - string of the name of item
	 */
	public void setName(String name) {
		this.name = name;
		
	}
	/**
	 * used to return the name of the item
	 * @return the name string
	 */
	public String getName() {
		return name;
	}
	/**
	 * used to set the cost from param to the double static cost variable
	 * @param price - double of the price of item
	 */
	public static void setCost(double price) {
		cost = cost + price;
	}

}
