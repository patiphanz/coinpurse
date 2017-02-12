package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class Coin implements Comparable<Coin>{
	/** Value of the coin. */
	private double value;
	/** The currency we want to get.*/
	private String currency = "Baht";
	
	/**
	 * A coin with given value using the default currency.
	 * @param value
	 */
	public Coin(double value){
			this.value = value;
	}
	
	/**
	 * A coin with given value and currency.
	 * @param value
	 * @param currency
	 */
	
	public Coin(double value,String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * A method use to return value of coin.
	 * @return value
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * A method use to return currency of this coin.
	 * @return currency
	 */
	public String getCurrency(){
		return this.currency;
	}
	/**
	 * Test if two coins are equal.
	 * @param obj is another object to compare to this one
	 * @return true if c is a Coin with same value as this Coin
	 */
	public boolean equals(Coin c){
		if(c == null) return false;
		if(c.getClass() != this.getClass()) return false;
		Coin other = (Coin) c;
		if(this.value == other.value) return true;
		return false;
	}
	
	/**
	 * Test whether which coin is more than each other.
	 * @param c is another object to compare to this one.
	 * @return 	-1 if c is more than this Coin.
	 * 			+1 if c is less than this Coin.
	 * 			 0 if c is equal this Coin.
	 */
	public int compareTo(Coin c) {
		if (c.getValue() == 0.0) return -1;
		if (this.getValue() > c.getValue())
			return +1;
		else if(this.getValue() < c.getValue())
			return -1;
		return 0;
			
	}
	
	/** Get String with value of money and currency.
	 *  @return String with value of money and currency.
	 */
	public String toString(){
		return String.format("%.0f %s",this.value,this.currency);
	}
}
