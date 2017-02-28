package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	private static final String DEFAULT_CURRENCY = "Baht";
	/**The initial of the banknote's serial nummber*/
	private static long nextSerialNumber = 1000000;

	private final double [] coinThai = {0.25,0.5,1,2,5,10};
	private final double [] bankThai = {20,50,100,500,1000};
	
	@Override
	boolean coinValid(double value) {
		for(double x : coinThai){
			if(value == x)
			return true;
		}
		return false;
	}
	
	@Override
	boolean bankValid(double value) {
		for(double x : bankThai){
			if(value ==x)
			return true;
		}
		return false;
	}
	
	@Override
	Valuable createMoney(double value) {
		if(coinValid(value)){
			Coin c = new Coin(value);
			return c;
		}
		if(bankValid(value)){
			BankNote b = new BankNote(value,this.nextSerialNumber++);
			return b;
		}
		throw new IllegalArgumentException();
	}
	

}
