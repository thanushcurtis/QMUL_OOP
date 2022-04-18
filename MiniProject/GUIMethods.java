import java.util.Date;
public abstract class GUIMethods {

    public void addInvoice(String name, Date issueDate, Date DueDate,String choice, Database database)
    {

        if(choice.equals("C"))
        {
            Customer c = database.returnCustomer(name);
            Invoice newInvoice = new Invoice(issueDate, DueDate,c);
            newInvoice.InvoiceItems();
            c.addInvoice(newInvoice);
        }
        else if(choice.equals("S"))
        {
            Supplier s =database.returnSupplier(name);
            Invoice newInvoice = new Invoice(issueDate, DueDate, name);
            newInvoice.InvoiceItems();
            s.addInvoice(newInvoice);
        }
    }
}
