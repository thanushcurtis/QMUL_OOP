import java.util.ArrayList;
import java.util.Date;

public class Invoice implements GenericMethods {
    private Date IssueDate;
    private Date DueDate;
    private String InvRef;
    private double TotalAmount;
    private final ArrayList<Product> InvoiceItems = new ArrayList<>();
    private final ArrayList<Double> ItemsNetAmount = new ArrayList<>();
    public static int counter=0;
    private double netAmount;

    public Invoice(Date issueDate, Date dueDate, Object obj)
    {

        this.IssueDate=issueDate;
        this.DueDate = dueDate;
        SetInvRef(obj);


    }

    public Invoice(Object obj)
    {
        SetInvRef(obj);
    }
    public void SetInvRef(Object obj){
        final boolean c = obj instanceof Customer;
        if(c)
        {
            this.InvRef = "SALES"+1000 + counter++;
        }
        final boolean s = obj instanceof Supplier;
        if(s)
        {
            this.InvRef= "PUR"+1000 + counter++;
        }

    }

    public String GetInvRef(){


        return this.InvRef;
    }

    public double GetTotalAmount(){

        return this.TotalAmount;
    }

    public void setItem(String name, int quantity)
    {
        boolean ItemFound=false;
        Product Item=null;
        for(int i =0; i<BusinessApp.database.getProducts().size(); i++)
        {
            if(name.equals(BusinessApp.database.getProduct(i).getName()))
            {

                ItemFound = true;
                Item = BusinessApp.database.getProduct(i);
            }
            else
            {
                ItemFound = false;
                Item=null;
            }
        }

        if(ItemFound)
        {
            this.InvoiceItems.add(Item);
            double price = BusinessApp.database.getProductPrice(Item);
            this.netAmount= price * quantity;
            this.ItemsNetAmount.add(netAmount);
            GenericMethods.print("Item Added");
        }
        else{
            GenericMethods.print("Product Not Found");
        }

    }


    public void InvoiceItems(){

        boolean valid=false;
        while(!valid)
        {

            String item = GenericMethods.ask_questions("What is the Product? / Press N to finish adding");
            if(!item.equals("N"))
            {
                int quantity = GenericMethods.input_int("What is the Quantity?");
                setItem(item,quantity);
            }
            else {
                valid=true;
                GenericMethods.print("Items SuccessFully Added to the Invoice");
            }

        }
        for(int i=0; i<InvoiceItems.size(); i++)
        {
            this.TotalAmount += ItemsNetAmount.get(i);
        }


    }

    public void InvoiceItemsGUI(ArrayList<Product> product,ArrayList<Double> gross){

        for(int i=0 ; i<product.size()-1;i++)
        {
            this.InvoiceItems.add(product.get(i));
            this.ItemsNetAmount.add(gross.get(i));
        }

        for(int i=0; i<InvoiceItems.size(); i++)
        {
            this.TotalAmount += ItemsNetAmount.get(i);
        }

    }


    public void printnetamounts()
    {
        System.out.println("Size  :"+ItemsNetAmount.size());
        System.out.println("Size item :"+InvoiceItems.size());
        for (int i=0; i<ItemsNetAmount.size()-1;i++)
        {
            System.out.println(ItemsNetAmount.get(i)+"test");
        }
    }











}
