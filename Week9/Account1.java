
public class Account1{
    private int balance;
    private int acc_num;
    public static int counter=0;


    public Account1(int balance){
        this.balance = balance;
        SetUniqueID();


    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount){
        this.balance += amount;
    }
    
    /*
    public void withdraw(int amount){
	if (amount > this.balance){
	    System.out.println("Error. The amount to be withdrawn exceeds this account's balance.");
	} else
    {
	    this.balance -= amount;
	}
    }*/


    public  void SetUniqueID(){
        this.acc_num= 1000 + counter++;
    }
    public int getUniqueId()
    {

        return this.acc_num;
    }

}
