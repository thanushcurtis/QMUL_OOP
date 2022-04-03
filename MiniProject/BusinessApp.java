public class BusinessApp implements GenericMethods {

    private final Database database = new Database();

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
                stop=true;
            }
        }
        GenericMethods.print("thank you");
        System.exit(0);

    }

    public BusinessApp(){

        Intro();
        ChooseFunction();

    }



}
