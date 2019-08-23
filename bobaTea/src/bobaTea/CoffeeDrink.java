package bobaTea;

import java.util.Scanner;
/**
 * created a sub class called coffee drink that overrides the drinkitem super classes methods 
 * implementing abstract getcost, overriding the size methods, sweetness methods, milk methods, and the tostring method
 */
public class CoffeeDrink extends DrinkItem {
	private String sweetness;
	private String milk;
	private String size;
	private String drink;
	private double totalPrice;
/**
 * constructor that will hold and create the coffee object
 * @param drink - holds the name of the drink as a string
 * @param size - holds the size of the drink as a string
 * @param price - holds the price of the drink as a double
 */
	public CoffeeDrink(String drink, String size, double price) {
		super(drink, size, price);
		this.drink = drink;
		this.size = size;
		this.totalPrice = price;
	}
	/**
	 * override the size methods
	 */
	public String getSize() {
		System.out.println("size: " + size);
		return this.size;
	}
	public String setSize(String drinkSize) {
		return this.size = drinkSize;
	}
	/**
	 * overrides the sweetness methods
	 */
	public String getSweetness() {
		System.out.println(sweetness + " teaspoons of sugar");
		return this.sweetness;
	}
	public String setSweetness(String sweetness) {
		return this.sweetness = sweetness;
	}
	/**
	 * overrides the milk methods
	 */
	public String getMilk() {
		System.out.println("base: " + milk);
		return milk;
	}
	public String setMilk(String milk) {
		return this.milk = milk;
	}
	public double getCost(double price) {
		return this.totalPrice = price;
	}
	/**
	 * overrides the tostring methods
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", totalPrice);
		return "drink: " + drink + " -- size: " + size + " -- subtotal $" + totalPriceString + "\n";
	}
}
