public class BusinessApp implements GenericMethods {

    public static final Database database = new Database();

    public static void main(String[] args)
    {
        new BusinessApp();

    }
    //print the functions the user can use
    public static void Intro()
    {

        GenericMethods.print("Welcome to TC's Business");
        GenericMethods.print("1 : to View Customer Details");
        GenericMethods.print("2 : to Enter New Customer");
        GenericMethods.print("3 : to view Supplier's Details");
        GenericMethods.print("4 : to Enter Supplier's Details");
        GenericMethods.print("5 : Add Products");
        GenericMethods.print("6 : Add Invoice");
        GenericMethods.print("7 : Stop the program");
        GenericMethods.print("");


    }



    //getting which function to operate from user
    public static int FunQuestion(){
        int FunctionInput=0;
        try{
            FunctionInput = GenericMethods.input_int("Enter the function you want to perform?");
            while(FunctionInput<0 || FunctionInput>8)
            {
                FunctionInput=GenericMethods.input_int(("Please enter an integer between 0 and 2"));
            }
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Please enter a valid integer!!!");
            FunQuestion();
        }

        return FunctionInput;
    }

    //choosing the function to operate
    public void ChooseFunction()
    {
        boolean stop =false;
        while(!stop)
        {
            int FunChoice = FunQuestion();
            if(FunChoice==1)
            {
                database.GetCustomerDetails();
            }
            else if(FunChoice==2)
            {
                database.SetNewCustomer();
            }
            else if(FunChoice==3)
            {
                database.GetSupplierDetails();
            }
            else if(FunChoice==4)
            {
                database.SetNewSupplier();
            }
            else if(FunChoice==5)
            {
                database.addProducts();
            }
            else if(FunChoice==6)
            {

                database.addInvoice();
            }
            else if(FunChoice==7)
            {
                stop=true;
            }
        }
        GenericMethods.print("thank you");
        System.exit(0);

    }

    public BusinessApp(){
        // Adding Customer's for testing
        Customer c = new Customer("Thanush","Thanushcurtis@gmail.com", 0772L,"2, Pollard Road");
        Product p = new Product("Apple",3.4,2,15);
        Product p1 = new Product("Orange", 2.0,1,20);
        database.addCustomer(c);
        database.addProduct(p);
        database.addProduct(p1);
        System.out.println(database.getProducts().size());

        Intro();
        ChooseFunction();



    }



}
