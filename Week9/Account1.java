import java.util.Random;
public class Account1{
    private int balance;
    private int acc_num;
    private double interest =0.01;
    public static int counter=0;


    public Account1(){
        this.balance=0;
        SetUniqueID();

    }    

    public Account1(int balance){
        this.balance = balance;
        SetUniqueID();


    }

    public Account1(int balance, double interest)
    {
        this.balance=balance;
        this.interest=interest;
        SetUniqueID();

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
    public  void SetUniqueID(){
        int n = 1000 + counter++;
        this.acc_num=n;
    }
    public int getUniqueId()
    {

        return this.acc_num;
    }

}
