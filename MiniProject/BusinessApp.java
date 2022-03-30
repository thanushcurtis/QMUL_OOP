public class BusinessApp implements GenericMethods {

    Database database = new Database();

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
        GenericMethods.print("5 : Stop the program");
        GenericMethods.print("");

    }

    //getting which function to operate from user
    public static int FunQuestion(){
        int FunctionInput=0;
        try{
            FunctionInput = GenericMethods.input_int("Enter the function you want to perform?");
            while(FunctionInput<0 || FunctionInput>6)
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
                GetCustomerDetails();
            }
            else if(FunChoice==2)
            {
                SetCustomer();
            }
            else if(FunChoice==3)
            {
                GetSupplierDetails();
            }
            else if(FunChoice==4)
            {
                SetSupplier();
            }
            else if(FunChoice==5)
            {
                stop=true;
            }
        }
        GenericMethods.print("thank you");
        System.exit(0);

    }

    //method for getting customer's details
    public  void GetCustomerDetails()
    {
        String input =GenericMethods.ask_questions("Please Enter Customer Name or Reference to find the Details");
        database.GetCustomerDetails(input);

    }

    //method for input new customer
    public void SetCustomer()
    {
        String name =GenericMethods.ask_questions("Please enter the Name :");
        String email = GenericMethods.ask_questions("Please enter the email :");
        Long num = GenericMethods.input_phone("Please enter the Mobile Number :");
        String Address = GenericMethods.ask_questions("Please enter the Address :");
        database.SetNewCustomer(name, email, num, Address);
    }

    //method for getting supplier's details
    public void GetSupplierDetails()
    {
        String input =GenericMethods.ask_questions("Please Enter Name :");
        database.GetSupplierDetails(input);
    }

    //method for input new supplier
    public void SetSupplier()
    {
        String name =GenericMethods.ask_questions("Please enter the Name :");
        String email = GenericMethods.ask_questions("Please enter the email :");
        String Address = GenericMethods.ask_questions("Please enter the Address :");
        database.SetNewSupplier(name, email,Address);
    }


    public BusinessApp(){

        Intro();
        ChooseFunction();

    }



}
