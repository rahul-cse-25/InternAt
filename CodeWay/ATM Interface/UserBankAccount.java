
public class UserBankAccount {
	private double balance;
	private int atmCardNum;
	private int atmPinNum;

	public UserBankAccount(double balance, int atmCardNum, int atmPinNum) {
		this.balance = balance;
		this.atmCardNum = atmCardNum;
		this.atmPinNum = atmPinNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAtmCardNum() {
		return atmCardNum;
	}

	public int getAtmPinNum() {
		return atmPinNum;
	}

	@Override
	public String toString() {
		return "UserBankAccount [balance=" + balance + ", atmCardNum=" + atmCardNum + ", atmPinNum=" + atmPinNum + "]";
	}

}
