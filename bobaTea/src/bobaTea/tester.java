package bobaTea;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * tester class with the main that will be creating objects of and implementing all of my other classes into the main boba tea lounge.
 * @author Justin Quarress
 * - 2/19/2019
 *
 */

public class tester {
	private static int totalItems;
	private static int totalDrinkItems;
	private static int totalDessertItems;
	private static double dessertTotal;
	private static double drinkTotal;
	private static double grandTotal;
	private static double dessertGrandTotal;
	private static double drinkGrandTotal;
	private static double grandGrandTotal;
	private static double payment;
	private static double amountDue;
	private static double total;
	private static boolean isValid;
	private static int toppingNumber = 0;
	private static String toppings;
	private static String drink;
	private static String dessert;
	private static String size;
	private static String sweetness;
	private static String milk;
	private static String base;
	private static String topping;
	private static int saleCount = 0;
	private static int quantity;
	private static double totalPrice;
	private static double totalTaxPrice;
	static ArrayList<DrinkItem> drinkSaleList = new ArrayList<DrinkItem>();
	static ArrayList<DessertItem> dessertSaleList = new ArrayList<DessertItem>();
	private static int choice;
	private static int amount;
	private static String sChoice;
	static ArrayList<String> toppingList = new ArrayList<String>();
	private static double couponTotal;
	private static double grandTotalTaxPrice;
	
	public static void main(String[] args) {
		cashRegister reg = new cashRegister();
		Receipt r = new Receipt();
		Scanner Enter = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		do {
			while (isValid == false) {
				System.out.println("1)New Sale\n2)Print all sales\n3)close the register");
				choice = in.nextInt();
				System.out.println();
			switch(choice) {
			case 1:
				do {
					System.out.println("1)purchase a drink\n2)purchase pastries\n3)purchase cookies\n4)purchase macaroons\n5)finalize sale");
					choice = in.nextInt();
					switch (choice) {
					case 1:
						System.out.println("which Drink Would u Like?: boba tea or coffee");
						sChoice = Enter.nextLine();
						switch(sChoice) {
						case "boba tea":
							DrinkItem b1 = new BobaDrink(sChoice, size, total);
							drink = b1.setDrink(sChoice);
							isValid = false;
							while(isValid == false) {
								System.out.println("which size would u like: small: $3.00, medium: $4.00, large: $5.00");
								size = Enter.nextLine();
								switch (size) {
								case "small":
									total = 3.00;
									drinkTotal = 3.00;
									isValid = true;
									break;
								case "medium":
									total = 4.00;
									drinkTotal = 4.00;
									isValid = true;
									break;
								case "large":
									total = 5.00;
									drinkTotal = 5.00;
									isValid = true;
									break;
								default:
									isValid = false;
									System.out.println("not a valid entry");
								}
							}
							b1.setSize(size);
							isValid = false;
							while (isValid == false) {
								System.out.println("Which base would u like?: green tea, black tea, jasmine green tea, rose tea, or oolong tea");
								base = Enter.nextLine();
								switch (base) {
								case "green tea":
									isValid = true;
									break;
								case "black tea":
									isValid = true;
									break;
								case "jasmine green tea":
									isValid = true;
									break;
								case "rose tea":
									isValid = true;
									break;
								case "oolong tea":
									isValid = true;
									break;
								default:
									isValid = false;
								}
							}
							b1.setBase(base);
							isValid = false;
							while (isValid == false) {
							System.out.println("Sweetness level?: full, 3/4, 1/2, 1/4");
							sweetness = Enter.nextLine();
							switch (sweetness) {
								case "full":
									isValid = true;
									break;
								case "3/4":
									isValid = true;
									break;
								case "1/2":
									isValid = true;
									break;
								case "1/4":
									isValid = true;
									break;
								default:
									isValid = false;
									System.out.println("not a valid entry");
								}
							}
							b1.setSweetness(sweetness);
							isValid = false;
							while(isValid == false) {
								System.out.println("Which milk would u like?: whole milk, half and half, almond milk, coconut milk, or no milk");
								milk = Enter.nextLine();
								switch (milk) {
								case "whole milk":
									isValid = true;
									break;
								case "half and half":
									isValid = true;
									break;
								case "almond milk":
									isValid = true;
									break;
								case "coconut milk":
									isValid = true;
									break;
								case "no milk":
									isValid = true;
									break;
								default:
									isValid = false;
									System.out.println("not a valid entry");
								}
							}
							b1.setMilk(milk);
							System.out.println("Which toppings would u like? $0.50 each: none, boba, popping boba, grass jelly, \nlychee jelly, coconut jelly, and mini mochi");
							toppings = Enter.nextLine();
							isValid = true;
							switch (toppings) {
							case "boba":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "popping boba":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "grass jelly":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "lychee jelly":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "coconut jelly":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "mini mochi":
								System.out.println(", and");
								toppingList.add(toppings);
								toppingNumber++;
								total = total + 0.50;
								drinkTotal = drinkTotal + 0.50;
								break;
							case "none":
									isValid = false;
									break;
							case "thats it":
									isValid = false;
									break;
							default:
								System.out.println("not a valid entry");
								break;
							}
							if (toppingNumber >= 1) {
								while ( isValid == true) {
									toppings = Enter.nextLine();
									switch (toppings) {
									case "boba":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "popping boba":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "grass jelly":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "lychee jelly":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "coconut jelly":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "mini mochi":
										System.out.println(", and ");
										toppingList.add(toppings);
										toppingNumber++;
										total = total + 0.50;
										drinkTotal = drinkTotal + 0.50;
										break;
									case "none":
											isValid = false;
											break;
									case "thats it":
											isValid = false;
											break;
									default:
										System.out.println("not a valid entry");
										break;
									}
								}
							}
							b1.setToppings(topping);
							System.out.println();
							System.out.println(sChoice);
							size = b1.getSize();
							b1.getBase();
							b1.getSweetness();
							b1.getMilk();
							System.out.println("number of toppings: " + toppingNumber);
							System.out.println("list of toppings:" + toppingList);
							b1.getToppings();
							System.out.printf("Boba Tea Drink Total: $%.2f" , b1.getCost(drinkTotal));
							System.out.println();
							drinkGrandTotal = drinkGrandTotal + drinkTotal;
							grandTotal = grandTotal + drinkTotal;
							reg.setDrinks(b1);
							drinkSaleList.add(b1);
							totalItems++;
							toppingNumber = 0;
							toppingList.clear();
							totalDrinkItems++;
							System.out.println();
							sChoice = "";
							break;
						case "coffee":
							DrinkItem c1 = new CoffeeDrink(sChoice, size, total);
							drink = c1.setDrink(sChoice);
							isValid = false;
							while (isValid == false) {
								System.out.println("which size would u like: small: $1.50, medium: $2.50, large: $3.50");
								size = Enter.nextLine();
								switch (size) {
								case "small":
									total = 1.50;
									drinkTotal = drinkTotal + 1.50;
									isValid = true;
									break;
								case "medium":
									total = 2.50;
									drinkTotal = drinkTotal + 2.50;
									isValid = true;
									break;
								case "large":
									total = 3.50;
									drinkTotal = drinkTotal + 3.50;
									isValid = true;
									break;
								default:
									System.out.println("not a valid entry");
									isValid = false;
								}
							}
							c1.setSize(size);
							System.out.println("how many teaspoons of sugar?: ");
							sweetness = Enter.nextLine();
							c1.setSweetness(sweetness);
							isValid = false;
							while (isValid == false) {
								System.out.println("Which base would u like?: whole milk, almond milk, or water");
								milk = Enter.nextLine();
								switch (milk) {
								case "whole milk":
									isValid = true;
									break;
								case "almond milk":
									isValid = true;
									break;
								case "water":
									isValid = true;
									break;
								default:
									System.out.println("not a valid entry");
									isValid = false;
								}
							}
							c1.setMilk(milk);
							System.out.println();
							System.out.println(sChoice);
							size = c1.getSize();
							c1.getSweetness();
							c1.getMilk();
							System.out.printf("Coffee Drink Total: $%.2f" , c1.getCost(drinkTotal));
							System.out.println();
							drinkGrandTotal = drinkGrandTotal + drinkTotal;
							grandTotal = grandTotal + drinkTotal;
							drinkSaleList.add(c1);
							reg.setDrinks(c1);
							totalItems++;
							totalDrinkItems++;
							System.out.println();
							sChoice = "";
							break;
						default:
							System.out.println("not a valid entry\n");
							break;
						}
						if (drinkTotal > couponTotal)
							couponTotal = drinkTotal;
						drinkTotal = 0;
						break;
					case 2:
						System.out.println("what type of pastry would you like? $1.50 each: apple strudel, bear claw, cinnamon roll ");
						sChoice = Enter.nextLine();
						DessertItem p1 = new Pastry(sChoice, quantity, total);
						dessert = p1.setDessertName(sChoice);
						System.out.println("how many would you like? $1.50 per pastry");
						quantity = in.nextInt();
						for (int i = 0; i < quantity; i++) {
							total = total + 1.50;
							dessertTotal = dessertTotal + 1.50;
						}
						p1.setQuantity(quantity);
						System.out.println("would you like the pastries heated for $0.25 each?");
						sChoice = Enter.nextLine();
						isValid = false;
						while (isValid == false) {
							switch(sChoice) {
							case "yes":
								total = total + (0.25*quantity);
								dessertTotal = dessertTotal + (0.25*quantity);
								System.out.printf("total price of heating $%.2f" , quantity*0.25);
								System.out.println();
								isValid = true;
								break;
							case "no":
								isValid = true;
								break;
							default:
								isValid = false;
							}	
						}
						System.out.println();
						System.out.println("pastry: " + sChoice);
						System.out.printf("total pastry price: $%.2f" , p1.getCost(dessertTotal));
						System.out.println();
						grandTotal = grandTotal + dessertTotal;
						dessertGrandTotal = dessertGrandTotal + dessertTotal;
						dessertSaleList.add(p1);
						reg.setDessert(p1);
						totalItems = totalItems + quantity;
						totalDessertItems = totalDessertItems + quantity;
						sChoice = "";
						System.out.println();
						dessertTotal = dessertTotal/quantity;
						if (dessertTotal > couponTotal)
							couponTotal = dessertTotal;
						quantity = 0;
						dessertTotal = 0;
						break;
					case 3:
						System.out.println("what type of Cookie would you like? $1.00 each: chocolate chip, sugar, oatmeal");
						sChoice = Enter.nextLine();
						DessertItem cookie = new Cookie(sChoice, quantity, total);
						dessert = cookie.setDessertName(sChoice);
						System.out.println("how many Cookies would you like? $1.00 per cookie, $10.00 per dozen");
						quantity = in.nextInt();
						if (quantity >= 12) {
							total = total + 10.00;
							dessertTotal = dessertTotal + 10.00;
							if (quantity > 12) {
								for (int i = 12; i < quantity; i++) {
									total = total + 1.00;
									dessertTotal = dessertTotal + 1.00;
								}
							}
						System.out.println("Dozen Price $" + dessertTotal + "0");
						}else {
							for (int i = 0; i < quantity; i++) {
								total = total + 1.00;
								dessertTotal = dessertTotal + 1.00;
							}
						}
						cookie.setQuantity(quantity);
						System.out.println();
						System.out.println("cookie: " + sChoice);
						System.out.printf("price: $%.2f" , cookie.getCost(dessertTotal));
						System.out.println();
						reg.setDessert(cookie);
						grandTotal = grandTotal + dessertTotal;
						dessertGrandTotal = dessertGrandTotal + dessertTotal;
						dessertSaleList.add(cookie);
						totalItems = totalItems + quantity;
						totalDessertItems = totalDessertItems + quantity;
						sChoice = "";
						dessertTotal = 0;
						quantity = 0;
						System.out.println();
						break;
					case 4:
						System.out.println("Which Flavor Macaroon would you like? green tea or chocolate");
						sChoice = Enter.nextLine();
						DessertItem m1 = new Macaroon(sChoice, quantity, total);
						dessert = m1.setDessertName(sChoice);
						switch(sChoice) {
						case ("green tea"):{
							System.out.println("1 green tea @ unit price = $1.50 \n3 green tea @ trio price = $3.50\nhow many would you like?");
							Scanner inn = new Scanner(System.in);
							amount = inn.nextInt();
							if (amount >= 3) {
								total = total + 3.50;
								dessertTotal = dessertTotal + 3.50;
								if (amount > 3) {
									for (int i = 3; i < amount; i++) {
										total = total + 1.50;
										dessertTotal = dessertTotal + 1.50;
									}
								}
							}else {
								for (int i = 0; i < amount; i++) {
									totalPrice = totalPrice + 1.50;
								}
							}
							break;
						}
						case("chocolate"):{
							System.out.println("1 chocolate @ unit price = $1.00 \n3 chocolate @ trio price = $2.50\nhow many would you like?");
							Scanner inn = new Scanner(System.in);
							amount = inn.nextInt();
							if (amount >= 3) {
								total = total + 2.50;
								dessertTotal = dessertTotal +2.50;
								if (amount > 3) {
									for (int i = 3; i < amount; i++) {
										total = total + 1.00;
										dessertTotal = dessertTotal + 1.00;
									}
								}
							}else {
								for (int i = 0; i < amount; i++) {
									total = total + 1.00;
									dessertTotal = dessertTotal + 1.00;
								}
							}
							break;
						}
						default:
							break;
						}
						m1.setQuantity(amount);
						System.out.println();
						m1.getQuantity();
						System.out.printf("price: $%.2f" , m1.getCost(dessertTotal));
						System.out.println();
						reg.setDessert(m1);
						grandTotal = grandTotal + dessertTotal;
						dessertGrandTotal = dessertGrandTotal + dessertTotal;
						dessertSaleList.add(m1);
						totalItems = totalItems + amount;
						totalDessertItems = totalDessertItems + amount;
						amount = 0;
						dessertTotal = 0;
						System.out.println();
						break;
					case 5:
						System.out.println();
						System.out.println("sale #: " + ++saleCount);
						System.out.println("total items: " + totalItems);
						System.out.println("Drinks:");
						System.out.println(drinkSaleList);
						System.out.println("Desserts:");
						System.out.println(dessertSaleList);
						System.out.println();
						System.out.printf("SubTotal: $%.2f", grandTotal);
						System.out.println();
						totalTaxPrice = grandTotal * 0.10;
						grandTotalTaxPrice = grandTotalTaxPrice + totalTaxPrice;
						grandTotal = grandTotal + totalTaxPrice;
						System.out.printf("sales tax: $%.2f" , totalTaxPrice);
						System.out.println();
						System.out.printf("Sale Total With Tax: $%.2f", grandTotal); 
						System.out.println();
						System.out.println("Do you have a coupon?");
						sChoice = "";
						isValid = false;
						while (isValid == false) {
							sChoice = Enter.nextLine();
						switch(sChoice) {
						case "yes":
							System.out.println("which coupon?: drink or pastry");
							while (isValid == false) {
								sChoice = Enter.nextLine();
							switch(sChoice) {
							case "drink":
								Coupon drinkCoupon = new Coupon("Drink", 0.50);
								System.out.println(drinkCoupon);
								couponTotal = couponTotal * 0.50;
								grandTotal = grandTotal - couponTotal;
								drinkGrandTotal = drinkGrandTotal - couponTotal;
								System.out.printf("Amount of money saved with your coupon -$%.2f", couponTotal);
								System.out.println();
								System.out.printf("Sale Total With Tax And Coupon Is Now: $%.2f", grandTotal);
								System.out.println();
								isValid = true;
								break;
							case "pastry":
								Coupon pastryCoupon = new Coupon("pastry", 0.25);
								System.out.println(pastryCoupon);
								couponTotal = couponTotal * 0.25;
								grandTotal = grandTotal - couponTotal;
								dessertGrandTotal = dessertGrandTotal - couponTotal;
								System.out.printf("Amount of money saved with your coupon: -$%.2f", couponTotal);
								System.out.println();
								System.out.printf("Sale Total With Tax And Coupon Is Now: $%.2f", grandTotal);
								System.out.println();
								isValid = true;
								break;
								default:
									System.out.println("invalid response");
									isValid = false;
							}
							}
						case "no":
							System.out.println();
							isValid = true;
							break;
						default:
							System.out.println("invalid response");
							isValid = false;
						}
						}
						sChoice = "";
						System.out.println("please enter payment");
						payment = in.nextDouble();
						System.out.printf("you paid $%.2f" , payment);
						System.out.printf(" the sale total was $%.2f" , grandTotal);
						System.out.println();
						amountDue = grandTotal - payment;
						if (payment == grandTotal) {
							System.out.println("you have paid in full");
						}else if(payment < grandTotal) {
							while (amountDue > 0) {	
								System.out.printf("you have not entered enough. you still owe $%.2f" , amountDue);
								System.out.println();
								System.out.println("please enter payment");
								payment = in.nextDouble();
								amountDue = amountDue - payment;
							}
						}
						System.out.printf("your change is $%.2f" , amountDue - amountDue*2);
						isValid = false;
						System.out.println();
						System.out.println();
						r.setDessertItems(totalDessertItems, dessertGrandTotal);
						r.setDrinkItems(totalDrinkItems, drinkGrandTotal);
						drinkSaleList.clear();
						dessertSaleList.clear();
						totalItems = 0;
						total = 0;
						grandTotal = 0;
						amountDue = 0;
						payment = 0;
						System.out.println();
					
					}
				}while (choice != 5);
				break;
					
			case 2:
				grandGrandTotal = grandGrandTotal + dessertGrandTotal + drinkGrandTotal + grandTotalTaxPrice;
				r.setGrandTotal(grandGrandTotal);
				System.out.println("total number of sales: " + saleCount);
				System.out.println("Drinks:");
				reg.getDrinks();
				System.out.println("Desserts:");
				reg.getDessert();
				r.getDrinkItems();
				r.getDessertItems();
				System.out.printf("total made from sales tax: $%.2f" , grandTotalTaxPrice);
				System.out.println();
				r.getGrandTotal();
				System.out.println();
				saleCount = 0;
				break;
			case 3:
				reg.clear();
				System.out.println("closing register... goodbye!");
				isValid = true;
				break;
			default:
				isValid = false;
				System.out.println("not a valid input\n");
				break;
			}
		}
		}while (choice != 3);
	}
}