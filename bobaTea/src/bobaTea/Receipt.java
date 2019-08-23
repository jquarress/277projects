package bobaTea;

import java.util.ArrayList;
/**
 * a receipt class that takes care of holding the drinks and desserts to be displayed in the end as a receipt
 * @author justin quarress
 *
 */
public class Receipt {
	private int drinkItems;
	private double drinkTotal;
	private int dessertItems;
	private double dessertTotal;
	private double grandTotal;
	public Receipt() {
	}
	/**
	 * get the drink items that were set and print and return the amount of items and totals
	 * @return the drink items
	 */
	public int getDrinkItems() {
		System.out.println("total drink items: " + drinkItems);
		System.out.printf("total made from drink sales: $%.2f", drinkTotal);
		System.out.println();
		return drinkItems;
	}
	/**
	 * set the amount of drink items and total as int and double
	 * @param drinkItems sets the amount of drink items as an int 
	 * @param drinkTotal total cost as a double
	 */
	public void setDrinkItems(int drinkItems, double drinkTotal) {
		this.drinkItems = drinkItems;
		this.drinkTotal = drinkTotal;
	}
	/**
	 * gets the drink price
	 * @return - the drink price 
	 */
	public double getDrinkTotal() {
		return drinkTotal;
	}
	/**
	 * sets the drink cost and sets the variable equal to the parameter
	 * @param drinkTotal sets that double cost to parameters 
	 */
	public void setDrinkTotal(double drinkTotal) {
		this.drinkTotal = drinkTotal;
	}
	/**
	 * get the dessert items that were set and print and return the amount of items and totals
	 * @return the dessert items
	 */
	public int getDessertItems() {
		System.out.println("total dessert items: " + dessertItems);
		System.out.printf("total made from dessert Sales: $%.2f" , dessertTotal);
		System.out.println();
		return dessertItems;
	}
	/**
	 * set the amount of dessert items and total as int and double
	 * @param dessertItems sets the amount of drink items as an int 
	 * @param dessertTotal total cost as a double
	 */
	public void setDessertItems(int dessertItems, double dessertTotal) {
		this.dessertItems = dessertItems;
		this.dessertTotal = dessertTotal;
	}
	/**
	 * gets the dessert price
	 * @return - the dessert price 
	 */
	public double getDessertTotal() {
		return dessertTotal;
	}
	/**
	 * sets the dessert cost and sets the variable equal to the parameter
	 * @param dessertTotal sets that double cost to parameters 
	 */
	public void setDessertTotal(double dessertTotal) {
		this.dessertTotal = dessertTotal;
	}
	/**
	 * get the grand total for the receipt and print the total
	 * @return - the total
	 */
	public double getGrandTotal() {
		System.out.printf("Grand Total Made With Taxes: $%.2f" , grandTotal);
		System.out.println();
		return grandTotal;
	}
	/**
	 * set the grand total to a double 
	 * @param grandTotal set the grand total to a double
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

}
