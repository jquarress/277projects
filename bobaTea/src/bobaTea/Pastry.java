package bobaTea;

import java.util.Scanner;
/**
 * this is a sub class the overrides some of the dessert item methods
 * @author justin quarress
 */
public class Pastry extends DessertItem {
private int quantity;
private double totalPrice;
private String dessert;
/**
 * the constructor that holds 3 parameters the name of the dessert the amount and the price
 * @param dessert - holds the name of the dessert as a string
 * @param quantity - holds the quantity chosen as a string
 * @param price - holds the price as a double
 */
	public Pastry(String dessert, int quantity, double price) {
		super(dessert, quantity, price);
		this.dessert = dessert;
	}
	/**
	 * overrides the quantity methods
	 */
	public int getQuantity() {
		System.out.println("Number of Pastries: " + quantity);
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost(double price) {
		return this.totalPrice = price;
	}
	/**
	 * overrides the to string method
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", totalPrice);
		return dessert + " -- amount of pastries: " + quantity + " -- subtotal: $" + totalPriceString + "\n";
	}
}
