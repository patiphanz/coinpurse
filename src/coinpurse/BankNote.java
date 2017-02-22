package coinpurse;

/**
 * BankNote with fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class BankNote implements Valuable {
	/**The initial of the banknote's serial nummber*/
	private static long nextSerialNumber = 1000000;
	/**Value of the banknote*/
	private double value;
	/**The default of banknote currency*/
	private String currency = "baht";
	/**Serial of banknote*/
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * @param value 
	 */
	BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;

	}

	/**
	 * A banknote with given value and currency.
	 * @param value
	 * @param currency
	 */
	BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	/**
	 * To get value of banknote.
	 * @return value
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
	 * To get currency of banknote.
	 * @return currency
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * To get serial of banknote.
	 * @return serialNumber
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Check if this banknote and other are the same of not.
	 * @param b is other banknote
	 * @return true if banknote is the same.
	 */
	public boolean equals(BankNote b) {
		if (b == null)
			return false;
		if (b.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) b;
		if (this.getValue() == other.getValue())
			return true;
		return false;
	}

	/**
	 * To return value ,currency and serialNumber of banknote.
	 * @return String with value ,currency and serialNumber of banknote.
	 */
	public String toString() {
		return String.format("%.0f-%s note [%d]", getValue(), getCurrency(), getSerial());
	}
}
