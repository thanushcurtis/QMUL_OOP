public class User{

    private String name;
    private int num_accounts=0;
    private Account account;
    private Account [] accounts = new Account[3];
    int totalBalance;

    public User(String name)
    {
	this.name = name;
    }
    
    public void setName(String name){
	this.name = name;
    }

    public String getName(){
	return this.name;
    }

    public void addAccount(Account acc)
    {
        if(num_accounts==3)
        {
            System.out.println("Max Accounts Reached");
        }
        else
        {
            account=acc;
            accounts[num_accounts]=account;
            num_accounts++;
            this.totalBalance+=this.account.getBalance();
        }
    }
    public int getFunds()
    {
        return totalBalance;
    }

    public void deposit(int acc_num, int amount)
    {
        if(acc_num>num_accounts || accounts[acc_num]==null)
        {
            System.out.println("Error");
        }
        else
        {
            accounts[acc_num].deposit(amount);
            this.totalBalance = this.totalBalance + amount;
        }


    }
    public void withdraw(int acc_num, int amount)
    {

        if(acc_num>num_accounts || accounts[acc_num]==null)
        {
            System.out.println("Error");
        }
        else
        {
            int remain = accounts[acc_num].getBalance();
            if(remain>=amount) {
                accounts[acc_num].withdraw(amount);
                this.totalBalance = this.totalBalance - amount;
            }
        }
    }

    public String generateReport()
    {
        String report  ="Name: "+this.name+". "+"Funds: "+getFunds();
        System.out.println(report);
        return report;

    }

    public double calculateEarnings()
    {
        double earnings=0;

        for(int i=0; i<num_accounts; i++)
        {
            earnings =earnings+ accounts[i].getBalance()*(accounts[i].getInterest());
        }
        return earnings;
    }

}
