package coinpurse;

public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "baht";
	private long serialNumber;

	BankNote(double value) {
		this.value = value;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;

	}

	BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	public long getSerial() {
		return this.serialNumber;
	}

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

	public String toString() {
		return String.format("%.0f-%s note [%d]", getValue(), getCurrency(), getSerial());
	}
}
