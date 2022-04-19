import java.util.ArrayList;
public abstract class GUIMethods {



    //view customer
    public Boolean GetCustomerDetails(String input) {

        boolean found=false;
        ArrayList<Customer> customers =BusinessApp.database.customerArrayList();
        if (customers.size() == 0) {
            GenericMethods.print("Sorry :( We don't have any customer's yet..");
        } else {
            for (Customer customer : customers) {
                if (input.equals(customer.getAcc_num()) || input.equals(customer.getName())) {
                    found=true;
                } else {
                    GenericMethods.print("Customer not found");
                }
            }
        }

        return found;
    }


    //set customer
    public Boolean setNewCustomer(String name,String email,Long num,String Address){
        boolean success=false;
        ArrayList<Customer> customers =BusinessApp.database.customerArrayList();
        if (Database.numCustomers <= 100) {
            Customer c = new Customer(name, email, num, Address);
            customers.add(c);
            Database.numCustomers++;
            success=true;
        }


        return success;
    }


    public void setNewSupplier(String name,String email,String type,String Address){
        ArrayList<Supplier> suppliers = BusinessApp.database.getSuppliers();
        Supplier s = new Supplier(name,Address,email);
        s.SetType(type);
        suppliers.add(s);

    }

    public Boolean GetSupplierDetails(String input) {

        boolean found=false;
        ArrayList<Supplier> suppliers = BusinessApp.database.getSuppliers();
        if (suppliers.size() == 0) {
            GenericMethods.print("Sorry :( We don't have any customer's yet..");
        } else {
            for (Supplier supplier : suppliers) {
                if (input.equals(supplier.getName())) {
                    found=true;
                    break;
                }
            }
        }

        return found;
    }

    public void addProducts(String name, Double salesprice, Double CostsPrice, int stock)
    {
        BusinessApp.database.getProducts().add(new Product(name,salesprice,CostsPrice,stock));
    }




}
