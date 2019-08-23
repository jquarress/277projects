package frameDemo2;
/**
 * main class that begins the entire process
 * @author justin
 *
 */
public class newPurchase {
	public static int orderCount;
	public static void main(String[] args) {
		newItemFrame p = new newItemFrame();
		startFrame n = new startFrame();
		n.setVisible(true);
		n.doneButton.setVisible(false);
	}
}
