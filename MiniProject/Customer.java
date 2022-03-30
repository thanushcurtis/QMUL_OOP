public class Customer extends User{

    private final String Acc_num;
    private static int numOfCustomers=1000;

    public Customer(String name, String email, Long num, String Address){
        super(name, email, num, Address);
        this.Acc_num="CUS"+numOfCustomers++;

    }
    public String getAcc_num(){
        return this.Acc_num;
    }




}
