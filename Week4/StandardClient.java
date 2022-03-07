public class StandardClient extends Client implements Resettable{

    public StandardClient(String name){
	super(name);
    }

    public void deposit(int amount)
    {
        super.getAccount().deposit(amount);

    }

    public void reset()
    {
        Account account = new Account();
        setAccount(account);
    }
}
