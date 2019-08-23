package bobaTea;
/**
 * created a dessertItem class that will be the super class for all of the dessert items
 * @author justin quarress
 *
 */
public abstract class DessertItem {
	private String dessertName;
	private int quantity;
	private String price;
	/**
	 * an abstract method that will promise the other sub classes that this will be used
	 * @param price - is the price that the item will cost as a double
	 * @return and this will return the cost of the item
	 */
	public abstract double getCost(double price);
	/**
	 * this is my constructor that hold 3 parameters the name of the dessert the amount of them and the price of that dessert
	 * @param dessert - this will give the name in a string
	 * @param quantity - this will carry the quantity as an int
	 * @param price - this will carry the price as a double
	 */
	public DessertItem(String dessert, int quantity, double price) {
		this.dessertName = dessert;
		this.quantity = quantity;
	}
	/**
	 * this just returns the string dessert name
	 * @return the name of the dessert chosen
	 */
	public String getDessertName() {
		System.out.println(dessertName);
		return this.dessertName;
	}
	/**
	 * this sets the dessert name 
	 * @param dessert - sets the string as a dessert name
	 * @return the name of the dessert chosen
	 */
	public String setDessertName(String dessert) {
		return this.dessertName = dessert;
	}
	/**
	 * a toString that will override how the dessert item object will be displayed.
	 * starting with the name then amount and then total
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", price);
		return dessertName + " -- amount: " + quantity + " -- subtotal: $" + totalPriceString + "\n";
	}
	/**
	 * this will get the quantity or amount of desserts chosen
	 * @return quantity which is set as an integer
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * this will set the quantity in the parameters
	 * @param quantity this is the amount of desserts chosen as an int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
