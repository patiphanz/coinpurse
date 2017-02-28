package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Patiphan Srisook
 *
 */
public class Coin extends AbstractValuable {
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
	
	/** Get String with value of money and currency.
	 *  @return String with value of money and currency.
	 */
	public String toString(){
		if(this.getCurrency().equals("Ringgit")){
			if(this.getValue()<1){
				return String.format("%.0f Sen coin", this.getValue()*100);
			}
		}
		if(this.getCurrency().equals("Baht")){
			if(this.getValue()<1){
				return String.format("%.0f Satang coin", this.getValue()*100);
			}
		}
		return String.format("%.0f-%s coin",this.value,this.currency);
	}

}
