package bobaTea;

import java.util.Scanner;
/**
 * a macaroon sub class that extends the cookie class
 * @author justin
 *
 */
public class Macaroon extends Cookie {

	private int quantity;
	private double totalPrice;
	private String flavor;
	private String dessert;
	public Macaroon(String dessert, int quantity, double price) {
		super(dessert, quantity, price);
		this.dessert = dessert;
	}
	/**
	 * overrides the quantity methods
	 */
	public int getQuantity() {
		System.out.println("Amount of Macaroons: " + quantity);
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
		return dessert + " macaroons -- amount of macaroons: " + quantity + " -- amount: $" + totalPriceString + "\n";
	}
}
