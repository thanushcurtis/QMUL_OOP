public class Supplier extends User {

    private int SupplierType;

    public Supplier(String name,String add,String email){
        super(name,add,email);


    }

    public void SetType(String type)
    {
        switch (type) {
            case "Fruits":
                this.SupplierType = 0;
                break;
            case "Vegetables":
                this.SupplierType = 1;
                break;
            case "Dairy":
                this.SupplierType = 2;

                break;
            default:

                System.out.println("Please Enter Valid Type!!!");
                System.out.println("Valid Types are: Fruits | Vegetables | Dairy");
                SetType(GenericMethods.ask_questions("Enter Supplier Type ?"));

                break;
        }

    }

    public String GetType()
    {
        if(this.SupplierType==0)
        {
            return "Fruits";
        }
        else if(this.SupplierType==1)
        {
            return "Vegetables";
        }
        else if(this.SupplierType==2)
        {
            return "Dairy";
        }

        return "General";

    }
}
