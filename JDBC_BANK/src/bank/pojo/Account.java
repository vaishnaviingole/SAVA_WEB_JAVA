package bank.pojo;

public class Account {

	 private int id;
	 private String Name;
	 private String type;
	 private double balance;
	 
	
	//Constructor;
	public Account( int id,String name, String type, double balance) {
		super();
		this.id = id;
		Name = name;
		this.type = type;
		this.balance = balance;
	}
	
	public Account(String name, String type, double balance) {
		super();
		Name = name;
		this.type = type;
		this.balance = balance;
	}

	//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//tostring(
	@Override
	public String toString() {
		return "Account [id=" + id + ", Name=" + Name + ", type=" + type + ", balance=" + balance + "]";
	}
}
