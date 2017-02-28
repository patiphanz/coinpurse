package coinpurse;

public abstract class AbstractValuable implements Valuable{

	/** Value of the coin. */
	protected double value;
	/** The currency we want to get.*/
	protected String currency = "Baht";

	/** Default constructor of AbstractValuable. */
	public AbstractValuable() {
		super();
	}

	/**
	 * A method use to return value of coin.
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * A method use to return currency of this coin.
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Test if two coins are equal.
	 * @param obj is another object to compare to this one
	 * @return true if c is a Coin with same value as this Coin
	 */
	public boolean equals(Valuable v) {
		if(v == null) return false;
		if(v.getClass() != this.getClass()) return false;
		Valuable other = (Valuable) v;
		if(this.getValue() == other.getValue()) return true;
		return false;
	}

	/**
	 * Test whether which coin is more than each other.
	 * @param c is another object to compare to this one.
	 * @return 	-1 if c is more than this Coin.
	 * 			+1 if c is less than this Coin.
	 * 			 0 if c is equal this Coin.
	 */
	public int compareTo(Valuable v) {
		if (v.getValue() == 0.0) return -1;
		if (this.getValue() > v.getValue())
			return +1;
		else if(this.getValue() < v.getValue())
			return -1;
		return 0;
			
	}

}