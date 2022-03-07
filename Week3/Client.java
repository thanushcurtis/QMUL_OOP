public class Client extends User{

    private Account account;

    public Account getAccount(){
	return this.account;
    }

    public Client(String name)
    {
        super(name);
        account= new Account();
    }

    public void deposit(int amount){
	this.account.deposit(amount);
    }

    public int getBalance(){
	return this.account.getBalance();
    }    
}
