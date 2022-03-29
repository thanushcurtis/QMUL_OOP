public class User {

    private String name;
    private String email;
    private int mobile_num;
    private String Address;

    public User(String name, String email, int num, String Address){
        this.name=name;
        this.email=email;
        this.mobile_num=num;
        this.Address=Address;

    }
    public User(String name, String Add, String email)
    {
        this.name=name;
        this.Address=Add;
        this.email=email;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void set_email(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setNum(int num){
        this.mobile_num=num;
    }

    public int getNum(){
        return this.mobile_num;

    }

    public void SetAddress(String add){
        this.Address=add;
    }
    public String GetAddress(){
        return this.Address;
    }




}
