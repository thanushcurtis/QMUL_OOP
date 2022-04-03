import java.util.ArrayList;
public class Database implements GenericMethods {

    private static final int MAX_CUSTOMERS = 100;
    private static int numCustomers;
    private final ArrayList<Customer> customers;
    private final ArrayList<Supplier> suppliers;
    private final ArrayList<Product> products;


    //database constructor
    public Database() {

        customers = new ArrayList<>(MAX_CUSTOMERS);
        suppliers = new ArrayList<>();
        products = new ArrayList<>();

    }

    //view customer
    public void GetCustomerDetails() {


        if (customers.size() == 0) {
            GenericMethods.print("Sorry :( We don't have any customer's yet..");
        } else {
            String input = GenericMethods.ask_questions("Please Enter Customer Name or Reference to find the Details");
            for (Customer customer : customers) {
                if (input.equals(customer.getAcc_num()) || input.equals(customer.getName())) {
                    GenericMethods.print("Name : " + customer.getName() + ".");
                    GenericMethods.print("Address :" + customer.GetAddress() + ".");
                    GenericMethods.print("Email :" + customer.getEmail() + ".");
                    GenericMethods.print("Mobile Num :" + customer.getNum() + ".");
                } else {
                    GenericMethods.print("Customer not found");
                }
            }
        }
    }

    // input new details for customers
    public void SetNewCustomer() {
        String name = GenericMethods.ask_questions("Please enter the Name :");
        String email = GenericMethods.ask_questions("Please enter the email :");
        Long num = GenericMethods.input_phone("Please enter the Mobile Number :");
        String Address = GenericMethods.ask_questions("Please enter the Address :");
        if (numCustomers <= MAX_CUSTOMERS) {
            Customer c = new Customer(name, email, num, Address);
            customers.add(c);
            numCustomers++;
            GenericMethods.print("Customer Created Successfully..");
        } else {
            GenericMethods.print(" Maximum Number of Customers Reached..");
        }
    }

    // input new Supplier
    public void SetNewSupplier() {
        String name = GenericMethods.ask_questions("Please enter the Name :");
        String email = GenericMethods.ask_questions("Please enter the email :");
        String address = GenericMethods.ask_questions("Please enter the Address :");

        Supplier s = new Supplier(name, address, email);
        String ans = GenericMethods.ask_questions("Please Enter the Type of Supplier");
        GenericMethods.print("Types are: Fruits | Vegetables | Dairy");
        s.SetType(ans);
        suppliers.add(s);
    }

    // get details of the supplier
    public void GetSupplierDetails() {

        if (suppliers.size() == 0) {
            GenericMethods.print("Sorry :( We don't have any supplier's yet..");
        } else {
            String input = GenericMethods.ask_questions("Please Enter Name :");
            for (Supplier supplier : suppliers) {
                if (input.equals(supplier.getName())) {
                    GenericMethods.print("Name : " + supplier.getName() + ".");
                    GenericMethods.print("Address :" + supplier.GetAddress() + ".");
                    GenericMethods.print("Email :" + supplier.getEmail() + ".");
                    GenericMethods.print("Type :" + supplier.GetType() + ".");
                } else {
                    GenericMethods.print("Supplier not found");
                }
            }
        }

    }

    public ArrayList<Product> getProducts()
    {
        return this.products;
    }

    public Product getProduct(int index){
        return products.get(index);
    }


}