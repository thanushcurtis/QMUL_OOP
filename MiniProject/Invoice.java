import java.util.ArrayList;
import java.util.Date;

public class Invoice extends InvoiceItems implements GenericMethods {
    private Date IssueDate;
    private Date DueDate;
    private String InvRef;
    private double TotalAmount;
    private ArrayList<InvoiceItems> items;
    public static int counter=0;


    public Invoice(Date issueDate, Date dueDate)
    {
        this.IssueDate=issueDate;
        this.DueDate = dueDate;
        items= new ArrayList<>();


    }
    public  void SetInvRef(){
        this.InvRef= "INVOICE"+1000 + counter++;
    }


    public double GetTotalAmount(){

        return this.TotalAmount;
    }


    public void InvoiceItems(){
        Boolean complete=false;
        while(!complete)
        {
            String item1 = GenericMethods.ask_questions("What is the Product?");


        }



    }









}
