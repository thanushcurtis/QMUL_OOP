public class Product {

    private String name;
    private double SalesPrice;
    private double CostsPrice;
    private int StockCount;


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

    public static String getDescription() {
        return BusinessApp.database.getProductByName(InvoiceMainGUI.tf.getText()).getName();
    }

    public static int getQuantity() {
        return Integer.parseInt(InvoiceMainGUI.tf2.getText());
    }

    public static double getPrice() {
        return BusinessApp.database.getProductByName(InvoiceMainGUI.tf.getText()).getSalesPrice();
    }

    public static Object getVatRate() {
        return InvoiceMainGUI.chooseVat.getSelectedItem();
    }

    public static double calculateTotal() {
        int ilosc = Integer.parseInt(InvoiceMainGUI.tf2.getText());
        double cena = getPrice();
        return ilosc * cena;
    }

    public static double calculateVat() {
        double cena = getPrice();
        String var = (String) getVatRate();
        String var2 = var.substring(0, var.length() - 1);
        double vat = Double.parseDouble(var2);
        return cena * (vat / 100);

    }

    public static double calculateGross() {
        return calculateTotal() + calculateVat();
    }
}
