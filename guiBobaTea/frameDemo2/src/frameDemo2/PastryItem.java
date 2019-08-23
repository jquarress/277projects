package frameDemo2;
/**
 * pastry item sub class that extends the item superclass used to create pastry order
 * @author justin
 *
 */
public class PastryItem extends Item{
	private String flavor;
	private String type;
	private String heatChoice = "not heated";
	private boolean heat;
	/**
	 * default constructor that is used to create pastry item objects
	 */
	public PastryItem() {
	}
	/**
	 * overloaded constructor that will take the string type and flavor and boolean heat
	 * @param type - string of the type of pastry chosen
	 * @param flavor - string of the pastry flavor chosen
	 * @param heat - boolean that keeps track if heated or not
	 */
	public PastryItem(String type, String flavor, boolean heat) {
		this.type = type;
		this.flavor = flavor;
		this.heat = heat;
		if (heat == true) {
			heatChoice = "heated";
		}
	}
	/**
	 * sets the type of pastry chosen in parameter to the type variable 
	 * @param type - string of the type of pastry
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * returns the pastry type
	 * @return - returns the type of pastry
	 */
	public String getType() {
		return type;
	}
	/**
	 * set the flavor from the parameter and adds it to the flavor variable
	 * @param flavor - string that holds the flavor chosen
	 */
	public void setflavor(String flavor) {
		this.flavor = flavor;
	}
	/**
	 * returns the string flavor 
	 * @return - string variable flavor
	 */
	public String getflavor() {
		return flavor;
	}
	/**
	 * set the heat option chosen 
	 * @param heat - boolean for the heated option
	 */
	public void setHeat(boolean heat) {
		this.heat = heat;
		if (heat == true) {
			heatChoice = "heated";
		}
	}
	/**
	 * get heat/ return boolean heat
	 * @return - the boolean heat
	 */
	public boolean getheat() {
		return heat;
	}
	/**
	 * get the type and return the cost accordingly
	 */
	public double getCost() {
		if(type == "Muffin") {
			cost = 2.0;
			return cost;
		}
		if(type == "Cookie") {
			cost = 1.5;
			return cost;
		}
		if(type == "Danish") {
			cost = 2.5;
			return cost;
		}
		if(type == "Cheesecake Slice") {
			if(flavor == "Regular") {
				cost = 4.0;
			}
			if(flavor == "Cherry") {
				cost = 4.5;
			}
			if(flavor == "Blueberry") {
				cost = 4.5;
			}
			return cost;
		}
		return cost;
	}
	/**
	 * to string to put together how the order will be displayed on the text area
	 */
	public String toString() {
		String subString = String.format("$%.2f", getCost());
		return "\n\t --" + type + "(" + heatChoice + "):" + "\t\t\t" + subString + "\n" +
				"\t\t Flavor: " + flavor + "\n\n";
	}
}
