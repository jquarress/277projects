package bobaTea;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * a drinkitem super class that will hold many of the common factors that will be used in both boba and coffee
 * @author justin quarress
 *
 */
public abstract class DrinkItem {
	private String drink;
	private String sweetness;
	private String size;
	private String base;
	private String milk;
	private String toppings;
	ArrayList<String> drinkList = new ArrayList<String>();
	private String price;
	/**
	 * an abstract method that will promise the other sub classes that this will be used
	 * @param price - is the price that the item will cost as a double
	 * @return and this will return the cost of the item
	 */
	public abstract double getCost(double price);
	/**
	 * my constructor that will be the object created and keep track of three parameters 
	 * @param drink - this will hold the name of the drink
	 * @param size - this will hold the size of the drink
	 * @param price - this will hold the cost of the drink
	 */
	public DrinkItem(String drink, String size, double price) {
		this.size = size;
		this.drink = drink;
	}
	/**
	 * this will get the drink name
	 * @return - returns the drink item name
	 */
	public String getDrink() {
		System.out.println(drink);
		return this.drink;
	}
	/**
	 * this will set the drink item name
	 * @param drink - this will hold the name as a string
	 * @return also returns the drink name and sets it to instance variable
	 */
	public String setDrink(String drink) {
		return this.drink = drink;
	}
	/**
	 * gets the sweetness and returns the chosen sweetness level
	 * @return - returns an empty string or null.
	 */
	public String getSweetness() {
		System.out.println(sweetness + " sweetness");
		return "";
	}
	/**
	 * this will be used to set the sweetness to the parameters and then return the instance variable set equal to the parameter
	 * @param sweetness this is the level of sweetness as a string
	 * @return returns the string sweetness variable and sets it to the parameter
	 */
	public String setSweetness(String sweetness) {
		return this.sweetness = sweetness;
	}
	/**
	 * this will return the size chosen
	 * and print the size chosen
	 * @return returns size as a string
	 */
	public String getSize() {
		System.out.println("size: " + size);
		return this.size;
	}
	/**
	 * this will set the size of the drink chosen as a string
	 * @param drinkSize - the size chosen as a string
	 * @return returns the size variable and sets it equal to the parameter that was set
	 */
	public String setSize(String drinkSize) {
		return this.size = drinkSize;
	}
	/**
	 * gets the milk option, displays it and returns it
	 * @return - returns the milk variable
	 */
	public String getMilk() {
		System.out.println("milk: " + milk);
		return milk;
	}
	/**
	 * sets the milk decided and takes that milk set to parameter and sets it to the milk variable
	 * @param milk is set as a string to keep track of the milk chosen
	 * @return the milk variable and set it equal to the parameter
	 */
	public String setMilk(String milk) {
		return this.milk = milk;
	}
	/**
	 * a toString that will override how the drink item object will be displayed.
	 * starting with the name then size and then total
	 */
	public String toString() {
		String totalPriceString = String.format("%.2f", price);
		return "drink name: " + drink + " -- size: " + size + " -- subtotal: $" + totalPriceString + "\n";
	}
	/**
	 * sets the toppings chosen in the tester to the string parameter
	 * @param topping is the string of the name of the topping chosen
	 * @return the topping parameter
	 */
	public String setToppings(String topping) {	
		return this.toppings = toppings;
	}
	/**
	 * get the topping that was chosen and set
	 * @return a null or empty
	 */
	public String getToppings() {	
		return this.toppings;
	}
	/**
	 * gets the string base 
	 * @return the empty or null string
	 */
	public String getBase() {
		System.out.println("base: " + base);
		return this.base;
	}
	/**
	 * sets the base chosen
	 * @param base - will be the string name we set as the base we chose
	 * @return the base parameter we chose
	 */
	public String setBase(String base) {
		return this.base = base;
	}
}

