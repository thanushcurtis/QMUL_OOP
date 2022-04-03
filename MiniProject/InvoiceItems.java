public abstract class InvoiceItems {

    private Product product;
    private double price;
    private int Quantity;
    private double netAmount;


    public void setItem(Database database, String name,int quantity)
    {
        for(int i =0; i<database.getProducts().size();)
        {
            if(name.equals(database.getProduct(i).getName()))
            {

                this.product=database.getProduct(i);
                this.price = database.getProduct(i).getSalesPrice();
                this.Quantity=quantity;
                this.netAmount= price*Quantity;

            }
            else
            {
                GenericMethods.print("Product Not Found");
            }
        }

    }

    public double getNetAmount(){
        return this.netAmount;
    }
    public String getProductName(){
        return this.product.getName();
    }
}
