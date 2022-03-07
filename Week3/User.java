public class User extends Account{

    private String name;
    
    public User(String name){
	this.name = name;
    }

    public String getName(){
	return this.name;
    }    
}
