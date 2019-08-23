package bobaTea;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
/**
 * a cash register class that will keep track of the grand total and add drinks and desserts
 * to two array lists of drinks and desserts
 * @author justin quarress
 *
 */

public class cashRegister {
	private int numberOfItems;
	private double totalPrice;
	private double totalTaxPrice;
	private DrinkItem drink;
	private DessertItem dessert;
	ArrayList<DrinkItem> drinkList = new ArrayList<DrinkItem>();
	ArrayList<DessertItem> dessertList = new ArrayList<DessertItem>();
	public cashRegister() {
	}
	/**
	 * set the grand total to the parameters
	 * @param total - sets the totalprice equal to the total from the parameters as a double
	 */
	public void setGrandTotal(double total) {
		this.totalPrice = total;
	}
	/**
	 * gets the total price then prints and returns the total
	 * @return - the grand total 
	 */
	public double getGrandTotal() {
		System.out.println(totalPrice);
		return this.totalPrice;
	}
	/**
	 * set the drink items into the register
	 * @param drink - holds the drink name as a string
	 */
	public void setDrinks(DrinkItem drink) {
		this.drinkList.add(drink);
	}
	/**
	 * prints and returns the drink names given
	 * @return - the drink name
	 */
	public DrinkItem getDrinks() {
		System.out.println(drinkList);
		return this.drink;
	}
	/**
	 * set the dessert items into the register
	 * @param dessert - holds the dessert name as a string
	 */
	public void setDessert(DessertItem dessert) {
		this.dessertList.add(dessert);
	}
	/**
	 * prints and returns the dessert names given
	 * @return - the dessert name
	 */
	public DessertItem getDessert() {
		System.out.println(dessertList);
		return this.dessert;
	}
	/**
	 * clear the register
	 */
	public void clear() {
		drinkList.clear();
		dessertList.clear();
		numberOfItems = 0;
		totalPrice = 0;
	}
}