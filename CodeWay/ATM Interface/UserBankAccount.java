import java.util.ArrayList;
import java.util.List;

public class UserBankAccount {
	private double balance;
	private int atmCardNum;
	private int atmPinNum;
	private List<Transaction> statement = new ArrayList<>();

	public class Transaction {
		private double amount;
		private double balance;
		private String description;

		public Transaction(double amount, double balance, String description) {
			this.amount = amount;
			this.balance = balance;
			this.description = description;
		}

		public double getAmount() {
			return amount;
		}

		public String getDescription() {
			return description;
		}

		public double getBalance() {
			return balance;
		}
	}
	
	public void addTransaction(double amount, String description) {
		statement.add(new Transaction(amount, balance, description));
	}

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

	public List<UserBankAccount.Transaction> getStatement() {
		return statement;
	}

}
