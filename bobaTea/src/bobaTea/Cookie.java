package bobaTea;

import java.util.Scanner;

/**
 * this is a sub class that extends the dessert item super class
 * @author justin quarress
 *
 */
public class Cookie extends DessertItem {
	private int quantity;
	private double totalPrice;
	private String dessert;
	public Cookie(String dessert, int quantity, double price) {
		super(dessert, quantity, price);
		this.dessert = dessert;
	}
	/**
	 * overrides the quantity methods
	 */
	public int getQuantity() {
		System.out.println("Amount of Cookies: " + quantity);
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost(double price) {
		return this.totalPrice = price;
	}
	/**
	 * overrides the tostring method
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", totalPrice);
		return dessert + " cookie -- amount of cookies: " + quantity + " -- subtotal: $" + totalPriceString + "\n";
	}

}
