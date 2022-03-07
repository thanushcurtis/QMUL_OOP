import java.util.Arrays;

public class Agent extends Client{

    private static final int MAX_CLIENTS = 5;
    private int numClients;
    private Client[] clients = new Client[MAX_CLIENTS];

    public Agent(String name)
    {
        super(name);
	    this.numClients = 0;
    }

    public void addClient(Client client)
    {
        if (numClients<MAX_CLIENTS)
        {
            clients[numClients]=client;
            numClients++;
        }
        else
        {
            System.out.println("Error");
        }
    }
    public Client[] getClients()
    {

      return clients;
    }
        
}
