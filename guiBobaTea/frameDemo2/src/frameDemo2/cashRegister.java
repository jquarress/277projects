package frameDemo2;
/**
 * cash register class that keeps track of the cost/prices of orders and number of orders
 * @author justin
 *
 */
public class cashRegister {
	public static double price;
	private static String receipt1 = "";
	private static int orderCount;
	/**
	 * method to set the cost to double parameter price
	 * @param price - holds the value of the price or double 
	 */
	public static void setCost(double price) {
		cashRegister.price = cashRegister.price + price;
	}
	/**
	 * used to get the cost of the item and return it
	 * @return - the price of the item
	 */
	public static double getCost() {
		return price;
	}
	/**
	 * set string of items to the parameter and then adds them to static receipt1 variable
	 * @param s - string of items
	 */
	public static void setReceipt(String s) {
		receipt1 = receipt1 + s;
	}
	/**
	 * returns the receipt
	 * @return - return the static string variable receipt
	 */
	public static String getReceipt() {
		return receipt1;
	}
}
