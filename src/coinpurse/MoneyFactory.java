package coinpurse;

public abstract class MoneyFactory {
	
	protected static MoneyFactory factory = null;

	/**Default constructor of Money Factory*/
	protected MoneyFactory() {
		
	}
	
	/**
	 * Return a MoneyFactory depending on the properties file.
	 * @return MoneyFactory instance
	 */
	static MoneyFactory getInstance() {
		if (factory == null) factory = new ThaiMoneyFactory();
		return factory;
	}
	
	/**
	 * This method use to createMoney between Coin and Banknote by value in double
	 * @param value is amount of money to crete in purse
	 * @return a Valuable object of the specified amount
	 */
	abstract Valuable createMoney(double value);
	
	/**
	 * This method use to createMoney between Coin and Banknote by value in String
	 * @param value is amount of money to crete in purse
	 * @return a Valuable object of the specified amount
	 */
	Valuable createMoney(String value){
		return this.createMoney(Double.parseDouble(value));
	}
	
	/**
	 * Check if value is a valid coin or not
	 * @return true if value is one of the coin array index.
	 */
	abstract boolean coinValid(double value);
	
	/**
	 * Check if value is a valid  banknote or not
	 * @return true if value is one of the banknote array index.
	 */
	abstract boolean bankValid(double value);
}
