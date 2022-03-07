public class PremiumClient extends Client{

    private static final double BONUS_RATE=0.001;
    private double bonus;

    public double getEarnedBonus(){
	return this.bonus;
    }

    public PremiumClient(String name)
    {
        super(name);
        this.bonus=0;
    }

    public void deposit(int amount)
    {
        super.getAccount().deposit(amount);
        bonus += amount*BONUS_RATE;
    }
                                                                                                                                                                                                                                                                            
    public void reset()
    {
        super.getAccount()= Account();
    }
}
