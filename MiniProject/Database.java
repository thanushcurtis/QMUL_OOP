import java.util.ArrayList;
public class Database implements GenericMethods {

    private static final int MAX_CUSTOMERS =100;
    private  static int numCustomers;
    private final ArrayList<Customer> customers;
    private final ArrayList<Supplier> suppliers;


    //database constructor
    public Database(){

        customers= new ArrayList<>(MAX_CUSTOMERS);
        suppliers =new ArrayList<>();

    }

    //view customer
    public  void GetCustomerDetails(String input)
    {


        if(customers.size()==0)
        {
            GenericMethods.print("Sorry :( We don't have any customer's yet..");
        }
        else
        {
            for(Customer customer : customers)
            {
                if(input.equals(customer.getAcc_num())||input.equals(customer.getName()))
                {
                    GenericMethods.print("Name : "+customer.getName()+".");
                    GenericMethods.print("Address :"+customer.GetAddress()+".");
                    GenericMethods.print("Email :"+customer.getEmail()+".");
                    GenericMethods.print("Mobile Num :"+customer.getNum()+".");
                }
                else
                {
                    GenericMethods.print("Customer not found");
                }
            }
        }
    }

    // input new details for customers
    public void SetNewCustomer(String name, String email, Long mobile_num, String Address)
    {
        if(numCustomers<=MAX_CUSTOMERS)
        {
            Customer c = new Customer(name,email, mobile_num,Address);
            customers.add(c);
            numCustomers++;
            GenericMethods.print("Customer Created Successfully..");
        }
        else
        {
            GenericMethods.print(" Maximum Number of Customers Reached..");
        }
    }

    // input new Supplier
    public void SetNewSupplier(String name,String address, String email)
    {
        Supplier s = new Supplier(name, address, email);
        String ans=GenericMethods.ask_questions("Please Enter the Type of Supplier");
        GenericMethods.print("Types are: Fruits | Vegetables | Dairy");
        s.SetType(ans);
        suppliers.add(s);
    }

    // get details of the supplier
    public void GetSupplierDetails(String input)
    {
        if(suppliers.size()==0)
        {
            GenericMethods.print("Sorry :( We don't have any supplier's yet..");
        }
        else
        {
            for(Supplier supplier : suppliers)
            {
                if(input.equals(supplier.getName()))
                {
                    GenericMethods.print("Name : "+supplier.getName()+".");
                    GenericMethods.print("Address :"+supplier.GetAddress()+".");
                    GenericMethods.print("Email :"+supplier.getEmail()+".");
                    GenericMethods.print("Type :"+supplier.GetType()+".");
                }
                else
                {
                    GenericMethods.print("Supplier not found");
                }
            }
        }

    }
}
