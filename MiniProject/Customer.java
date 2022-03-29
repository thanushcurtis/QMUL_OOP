public class Customer extends User{

    private String Acc_num;
    private static int numOfCustomers=10000;

    public Customer(String name, String email, int num, String Address){
        super(name, email, num, Address);
        this.Acc_num="CUS"+numOfCustomers+1;

    }
    public String getAcc_num(){
        return this.Acc_num;
    }

}
