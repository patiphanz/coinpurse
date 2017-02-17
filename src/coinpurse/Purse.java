package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Patiphan Srisook
 *
 */
public class Purse {
	/** Declare a List of Coin */
	private List<Valuable> money;
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private Comparator<Valuable> Comparator = new Comparator<Valuable>() {

		@Override
		public int compare(Valuable o1, Valuable o2) {
			return (int) Math.signum(o2.getValue() - o1.getValue());
		}
	};

	/**
	 * A constructor that creates an empty purse
	 * 
	 * @param capacity
	 *            is amount of coins
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<>();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return balance is the total value of items in the purse.
	 */
	public double getBalance() {
		if (money.size() == 0)
			return 0.0;
		double balance = 0;
		for (int a = 0; a < money.size(); a++) {
			balance += money.get(a).getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (valuable.getValue() > 0 && !isFull()) {
			money.add(valuable);
			Collections.sort(this.money, Comparator);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		List<Valuable> templist = new ArrayList<>();
		for (int i = 0; i < count(); i++) {
			Valuable v = this.money.get(i);
			if (v.getValue() <= amount) {
				amount = amount - v.getValue();
				templist.add(v);
			}
		}
		if (amount == 0) {
			for (Valuable temp : templist) {
				this.money.remove(temp);
			}
			Valuable[] withdraw = new Valuable[templist.size()];
			templist.toArray(withdraw);
			return withdraw;
		}
		return null;
	}

	/**
	 * @return String description of the purse contents.
	 */
	public String toString() {
		return String.format("%d items with value %.1f", count(), getBalance());
	}

}
