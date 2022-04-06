import java.util.ArrayList;
public class Customer extends User{

    private final String Acc_num;
    private static int numOfCustomers=1000;
    private final ArrayList<Invoice> sales_invoices = new ArrayList<>();
    private double total_due;

    public Customer(String name, String email, Long num, String Address){
        super(name, email, num, Address);
        this.Acc_num="CUS"+numOfCustomers++;

    }
    public String getAcc_num(){
        return this.Acc_num;
    }


    public void addInvoice(Invoice inc)
    {
        this.sales_invoices.add(inc);
        for (Invoice sales_invoice : sales_invoices) {
            this.total_due += sales_invoice.GetTotalAmount();
        }

    }

    public double getTotal_due()
    {
        return total_due;
    }


    public ArrayList<Invoice> getSales_invoices()
    {
        return this.sales_invoices;
    }








}
