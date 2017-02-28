package coinpurse;

/**
 * BankNote with fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class BankNote extends AbstractValuable {
	/**Serial of banknote*/
	private long serialNumber;

	/**
	 * A banknote with given value using the default currency.
	 * @param value 
	 */
	BankNote(double value,long serialNumber) {
		this.value = value;
		this.serialNumber = serialNumber;
	}

	/**
	 * A banknote with given value and currency.
	 * @param value
	 * @param currency
	 */
	BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		
	}

	/**
	 * To return a serial of each banknote
	 * @return serial number of each banknote
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	/**
	 * To return value ,currency and serialNumber of banknote.
	 * @return String with value ,currency and serialNumber of banknote.
	 */
	public String toString() {
		return String.format("%.0f %s note [%d]", getValue(), getCurrency(), getSerial());
	}

}
