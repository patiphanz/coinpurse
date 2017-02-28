package coinpurse;

/**
 * A main class to create objects and connectt objects together.
 * The user interface needs a reference to coin purse.
 * @author Patiphan Srisook
 *
 */
public class Main {
	private static int CAPACITY = 10;
	/**
	 * Configure and start the application.
	 * @param args
	 */
	public static void main(String[] args){
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		consoleDialog.run();
		
	}
}
