package bobaTea;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * created a sub class that overrides the drinkitem super classes methods 
 * implementing getcost, overriding the size methods and the tostring
 */

public class BobaDrink extends DrinkItem {
	private double totalPrice;
	private String drink;
	private String toppings;
	private String size;
	private String base;
	private int toppingNumber = 0;
	ArrayList<String> toppingList = new ArrayList<String>();
	/**
	 * constructor that holds name, size, and price
	 * @param drink this is the name of the dirnk as a string
	 * @param size this is the size of the drink as a string
	 * @param price this is the price of the drink as a double
	 */
	public BobaDrink(String drink, String size, double price) {
		super(drink,size,price);
		this.drink = drink;
		this.size = size;
		this.totalPrice = price;
	}
	public double getCost(double price) {
		return this.totalPrice = price;
	}
	/**
	 * just overides the getsize of the drinkitem
	 */
	public String getSize() {
		System.out.println("size: " + size);
		return this.size;
	}
	/**
	 * this overrides the setsize of the drinkitem
	 */
	public String setSize(String drinkSize) {
		return this.size = drinkSize;
	}
	/**
	 * overrides the to string method and set them equal to the 
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", totalPrice);
		return "drink type: " + drink + " -- size: " + size + " -- subtotal $" + totalPriceString + "\n";
	}
}
