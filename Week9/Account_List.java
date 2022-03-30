import javax.management.AttributeNotFoundException;
import java.util.ArrayList;

public class Account_List {

    private final ArrayList<Account1> accounts;


    public Account_List()
    {
         accounts = new ArrayList<>();

    }


    public void addAccount(Account1 a)
    {
        accounts.add(a);
    }

    public Account1 High_Acc()
    {

        int index=0;
        int previous=0;
        for(int i =0; i<accounts.size(); i++)
        {
           int balance = accounts.get(i).getBalance();
           if(balance>previous){
               previous=balance;
               index=i;
           }
        }
        return accounts.get(index);

    }


    public int total_list_balance()
    {
        int total_balance=0;
        boolean last_item=false;
        for(int i=0; i<accounts.size(); i++)
        {
            if(i==accounts.size()-1)
            {
                last_item=true;
            }

            if(!last_item)
            {

                total_balance+=accounts.get(i).getBalance();

            }
        }
        total_balance+=accounts.get(accounts.size()-1).getBalance();

        return total_balance;

    }
    public Account1 Low_Deposit(int amount)
    {
        int index=0;
        int previous=accounts.get(0).getBalance();
        for(int i =0; i<accounts.size(); i++)
        {
            int balance = accounts.get(i).getBalance();
            if(balance<previous){
                previous=balance;
                index=i;
            }
        }

        accounts.get(index).deposit(amount);
        return accounts.get(index);


    }

    public Account1 Get_Low_Deposit()
    {
        int index=0;
        int previous=accounts.get(0).getBalance();
        for(int i =0; i<accounts.size(); i++)
        {
            int balance = accounts.get(i).getBalance();
            if(balance<previous){
                previous=balance;
                index=i;
            }
        }
        return accounts.get(index);


    }

    public Account1 getAccount_Id(int id) throws AttributeNotFoundException  {

        Account1 acc=null;
        boolean found=false;
        for (Account1 account : accounts) {
            if (account.getUniqueId() == id) {
                System.out.println("Account Found");
                acc = account;
                found = true;

            }

        }
        if(!found)
        {
          throw  new AttributeNotFoundException("Account not Found");
        }
        return acc ;
    }

    public void Remove_Account_Id(int id) throws AttributeNotFoundException {


        boolean found=false;
        for(int i=0; i<accounts.size();i++)
        {

            if(accounts.get(i).getUniqueId()==id)
            {

                found=true;
                accounts.remove(i);
                i--;
                System.out.println("Account Removed");


            }
        }
        if(!found)
        {

            throw  new AttributeNotFoundException("Account Not Found");
        }

    }

    public void print_array()
    {
        System.out.print("[");
        for (Account1 account : accounts) {
            System.out.print(account.getUniqueId());
            System.out.print(", ");
        }
        System.out.print("]");
    }

}



