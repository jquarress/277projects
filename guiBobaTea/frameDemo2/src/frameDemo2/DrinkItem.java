package frameDemo2;
/**
 * the drink item sub class that extends the item superclass used for generic drink things
 * @author justin
 *
 */
public abstract class DrinkItem extends Item{
	protected String size = "n/a";
	protected String flavor = "n/a";
	protected String sweetness = "n/a";
	protected String milk = "n/a";
	/**
	 * default constructor that is used to create drink item objects
	 */
	public DrinkItem() {
		super(name, cost);
	}
	/**
	 * overloaded constructor that takes the parameters and sets them to the individual variables
	 * @param size - string for the size 
	 * @param flavor - string that holds the flavor chosen
	 * @param sweetness - string that holds the sweetness chosen
	 * @param milk - string for the milk type chosen.
	 */
	public DrinkItem(String size, String flavor, String sweetness, String milk){
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	/**
	 * a way to set the size and set the param to the size variable
	 * @param size - string of the size chosen
	 */
	public void setSize(String size) {
		this.size = size;
		
	}
	/**
	 * used to get the size/ return the size held in the variable
	 * @return - the string size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * a way to set the milk type and set the param to the milk variable
	 * @param milk - string of the milk type chosen
	 */
	public void setMilk(String milk) {
		this.milk = milk;
	}
	/**
	 * used to get the milk type/ return the milk type held in the variable
	 * @return - the string milk
	 */
	public String getMilk() {
		return milk;
	}
	/**
	 * a way to set the sweetness type and set the param to the sweetness variable
	 * @param sweetness - string of the sweetness chosen
	 */
	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}
	/**
	 * used to get the sweetness/ return the sweetness string held in the variable
	 * @return - the string sweetness
	 */
	public String getSweetness() {
		return sweetness;
	}
	/**
	 * a way to set the flavor type and set the param to the flavor variable
	 * @param flavor - string of the flavor chosen
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	/**
	 * used to get the flavor/ return the flavor string held in the variable
	 * @return - the string flavor
	 */
	public String getFlavor() {
		return flavor;
	}
	/**
	 * to string to put together how the order will be displayed on the text area
	 */
	public String toString() {
		String totalPriceString = String.format("$%.2f", cost);
		return "\t\t\t\t--base: " + flavor + " (" + size + "):\t\t\t\t  " + totalPriceString + "\n";
	}
	
}
