public class Product {

    private String name;
    private double SalesPrice;
    private double CostsPrice;
    private int StockCount;


    // new constructor
    public Product(String name)
    {
        this.name=name;
    }

    // new constructor
    public Product(String name, double salesprice, double costprice, int stock)
    {
        this.name=name;
        this.SalesPrice=salesprice;
        this.CostsPrice=costprice;
        this.StockCount=stock;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSalesPrice(double price)
    {
        this.SalesPrice=price;
    }

    public double getSalesPrice()
    {
        return this.SalesPrice;
    }

    public void setCostsPrice(double price)
    {
        this.CostsPrice=price;
    }

    public double getCostsPrice()
    {
        return this.CostsPrice;
    }

    public void setStockCount(int stockCount) {
       this.StockCount = stockCount;
    }

    public int getStockCount() {
        return this.StockCount;
    }
}
