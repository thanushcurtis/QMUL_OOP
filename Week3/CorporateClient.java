public class CorporateClient extends Client{
    private int companyRegistrationNumber;

    public CorporateClient(String name, int num) {
        super(name);
        this.companyRegistrationNumber =num;
    }

    public int getCompanyRegistrationNumber(){
	return companyRegistrationNumber;
    }
}
