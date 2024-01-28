import java.util.HashSet;

public class AtmServices implements ATM {

	HashSet<UserBankAccount> user = new HashSet<>();

	UserBankAccount user1 = new UserBankAccount(1000, 8446, 1232);
	UserBankAccount user2 = new UserBankAccount(2000, 8447, 1233);
	UserBankAccount user3 = new UserBankAccount(3000, 8448, 1234);
	UserBankAccount user4 = new UserBankAccount(4000, 8449, 1235);

	public AtmServices() {
		user.add(user1);
		user.add(user2);
		user.add(user3);
		user.add(user4);
	}

	private int cardNum;
	private int pinNum;

	public int getCardNum() {
		return cardNum;
	}

	public int getPinNum() {
		return pinNum;
	}

	public int setPinNum(int pinNum) {
		return this.pinNum = pinNum;
	}

	public int setCardNum(int cardNum) {
		return this.cardNum = cardNum;
	}

	@Override
	public int withdraw(int amount) {
		if (isPresent(getCardNum())) {
			for (UserBankAccount customer : user) {
				if (customer.getAtmCardNum() == getCardNum() && customer.getBalance() >= amount) {
					if (customer.getAtmPinNum() == getPinNum()) {
						customer.setBalance(customer.getBalance() - amount);
						System.out.println("WithDraw Successful !!");
						System.out.println("Available balance: " + customer.getBalance());
						break;
					} else if (customer.getAtmPinNum() == getPinNum()) {
						System.out.println("Wrong Credentials !");
					}
				} else if (customer.getAtmPinNum() == getPinNum()) {
					System.out.println("Insufficient Balance.");
				}
			}
		} else {
			System.out.println("User Not found !");
		}
		return amount;
	}

	@Override
	public void deposit(int amount) {
		if (isPresent(getCardNum())) {
			for (UserBankAccount customer : user) {
				if (customer.getAtmCardNum() == getCardNum() && customer.getAtmPinNum() == getPinNum()) {
					customer.setBalance(customer.getBalance() + amount);
					System.out.println("Deposited Successful !!");
					System.out.println("Available balance: " + customer.getBalance());
					break;
				} else if (customer.getAtmCardNum() == getCardNum()) {
					System.out.println("Wrong Credentials !");
				}
			}
		} else {
			System.out.println("User Not found !");
		}
	}

	@Override
	public double balance() {
		if (isPresent(getCardNum())) {
			for (UserBankAccount customer : user) {
				if (customer.getAtmCardNum() == getCardNum() && customer.getAtmPinNum() == getPinNum()) {
					return customer.getBalance();
				} else if (customer.getAtmCardNum() == getCardNum()) {
					System.out.println("Wrong credentials !");
					return 0;
				}
			}
		}
		System.out.println("User Not found !");
		return 0;
	}

	public boolean isPresent(int cardNum) {
		for (UserBankAccount customer : user) {
			if (customer.getAtmCardNum() == cardNum)
				return true;
		}
		return false;
	}

}
