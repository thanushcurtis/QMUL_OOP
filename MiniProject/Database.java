import java.util.Date;


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
                    GenericMethods.print("Total  Due :" + customer.getTotal_due()+ ".");
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

    public void addCustomer(Customer c)
    {
        customers.add(c);
    }
    public void addProduct(Product p)
    {
        products.add(p);
    }

    //set products
    public void addProducts()
    {
        String name = GenericMethods.ask_questions("Enter Product Name?");
        double salesprice = GenericMethods.input_double("Enter Sales Price?");
        double costsprice = GenericMethods.input_double("Enter Costs Price?");
        int stock = GenericMethods.input_int("Enter how you have in Stock?");
        this.products.add(new Product(name,salesprice,costsprice,stock));
    }

    //product details
    public ArrayList<Product> getProducts()
    {
        return this.products;
    }

    //get price
    public double getProductPrice(Product product)
    {
        return product.getSalesPrice();
    }

    public Product getProduct(int index){
        return products.get(index);
    }


    // return customer object
    public Customer returnCustomer(String name)
    {
        Customer c=null;
        for (Customer customer : customers) {
            if (name.equals(customer.getName()) || name.equals(customer.getAcc_num())) {
                c = customer;
            } else {
                c = null;
            }
        }

        return c;

    }

    //return supplier object
    public Supplier returnSupplier(String name)
    {
        Supplier s=null;
        for (Supplier supplier : suppliers) {
            if (name.equals(supplier.getName())) {
                s = supplier;
            } else {
                s = null;
            }
        }

        return s;
    }


    public void addInvoice(){

        String ans = GenericMethods.ask_questions("Please enter (C) to add Customer invoice or (S) to enter Supplier Invoice..");
        if(ans.equals("C"))
        {
            Date issuedate =GenericMethods.validateJavaDate(GenericMethods.ask_questions(" Please enter IssueDate?"));
            Date duedate = GenericMethods.validateJavaDate(GenericMethods.ask_questions(" Please enter DueDate?"));
            String customer = GenericMethods.ask_questions(" Enter Customer Name or Customer Reference");
            Customer c = returnCustomer(customer);
            while(c==null)
            {
                GenericMethods.print("Customer not found");
                customer = GenericMethods.ask_questions(" Enter Customer Name or Customer Reference");
                c = returnCustomer(customer);

            }
            Invoice newInvoice = new Invoice(issuedate,duedate,c);
            newInvoice.InvoiceItems();
            c.addInvoice(newInvoice);
        }
        else if(ans.equals("S"))
        {
            Date issuedate =GenericMethods.validateJavaDate(GenericMethods.ask_questions(" Please enter IssueDate?"));
            Date duedate = GenericMethods.validateJavaDate(GenericMethods.ask_questions(" Please enter DueDate?"));
            String supplier = GenericMethods.ask_questions(" Enter Supplier Name ?");
            Supplier s =returnSupplier(supplier);
            while(s==null)
            {
                GenericMethods.print("Supplier not found");
                supplier = GenericMethods.ask_questions(" Enter Supplier Name ?");
                s = returnSupplier(supplier);

            }
            Invoice newInvoice = new Invoice(issuedate,duedate,supplier);
            newInvoice.InvoiceItems();
            s.addInvoice(newInvoice);
        }


    }






}