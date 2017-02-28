package coinpurse;

public class MalaiMoneyFactory extends MoneyFactory{

	/**The initial of the banknote's serial number*/
	private static long nextSerialNumber = 1000000;
	/**The array of valid value in Malay coin*/
	private final double [] coinMalay = {0.05,0.1,0.2,0.5};
	/**The array of valid value in Malay banknote*/
	private final double [] bankMalay = {1,2,5,10,20,50,100};
	
	
	@Override
	Valuable createMoney(double value) {
		if(coinValid(value)){
			Coin c = new Coin(value);
			return c;
		}
		if(bankValid(value)){
			BankNote b = new BankNote(value,nextSerialNumber++);
			return b;
		}
		throw new IllegalArgumentException();
	}

	@Override
	boolean coinValid(double value) {
		for(double x : coinMalay){
			if(value == x)
			return true;
		}
		return false;
	}

	@Override
	boolean bankValid(double value) {
		for(double x : bankMalay){
			if(value == x)
			return true;
		}
		return false;
	}

}
