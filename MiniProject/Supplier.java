import java.util.ArrayList;
public class Supplier extends User {

    private int SupplierType;
    private ArrayList<Invoice>  purchase_invoices = new ArrayList<>();
    private double total_owe;

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

    public void addInvoice(Invoice inc)
    {
        this.purchase_invoices.add(inc);
        for (Invoice purchase_invoice : purchase_invoices) {
            this.total_owe += purchase_invoice.GetTotalAmount();
        }
    }

    public ArrayList<Invoice> getPurchase_invoices()
    {
        return this.purchase_invoices;
    }

    public double getTotal_owe()
    {
        return this.total_owe;
    }
}
