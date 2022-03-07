import java.util.Random;
public class Account{
    private int balance;
    private int acc_num;
    private double interest =0.01;
    public static int counter=100;


    public Account(){
        this.balance=0;
        counter+=3;
    }    

    public Account(int balance){
        this.balance = balance;
        counter+=2;
    }

    public Account(int balance, double interest)
    {
        this.balance=balance;
        this.interest=interest;
        counter+=3;
    }

    public int getBalance(){
        return this.balance;
    }

    public double getInterest()
    {
        return this.interest;
    }

    public void setBalance(int amount){
        this.balance = amount;
    }


    public void deposit(int amount){
        this.balance += amount;
    }
    
    public void withdraw(int amount){
	if (amount > this.balance){
	    System.out.println("Error. The amount to be withdrawn exceeds this account's balance.");
	} else
    {
	    this.balance -= amount;
	}
    }
    public int getUniqueId()
    {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        this.acc_num=counter+n;
        return this.acc_num;
    }

}
