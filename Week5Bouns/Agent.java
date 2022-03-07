import java.util.ArrayList;
import java.util.Iterator;
public class Agent {

    private ArrayList<Client> clients;

    public Agent(){
	clients = new ArrayList<Client>();
    }

    public int getNumberOfClients(){
	return clients.size();
    }

    public String getClientInfo(int clientNumber){
		Client c = clients.get(clientNumber);
	String text = "";
	text += "Name: " + c.getName() + "\n";
	text += "Funds: " + c.getFunds() + "\n";
	return text;
    }
	public int getClientindex(String clientName)
	{
		int index=-1;
		for (int i=0; i<this.clients.size(); i++)
		{
			Client c = clients.get(i);
			String name = c.getName();
			if(name.equals(clientName))
			{
				index=i;
			}
		}
		return index;
	}

    
    public String getListOfClientNames(){
	String text = "";
	Iterator<Client> it = clients.iterator();
	while (it.hasNext()){
	    Client c = it.next();
	    text += c.getName() + "\n";
	}
	return text;
    }
    
    public void addClient(Client c)
	{
		clients.add(c);
    }


	public boolean removeClient(String clientName)
	{
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()){
			Client c = it.next();
			if (c.getName().equals(clientName)){
				found = true;
				clients.remove(c);
				break;
			}
		}
		return found;
	}


   
    public boolean deposit(String clientName, int amount){
	Iterator<Client> it = clients.iterator();
	boolean found = false;	
	while (it.hasNext()){
	    Client c = it.next();
	    if (c.getName().equals(clientName)){
		found = true;
		c.deposit(amount);
	    }
	}
	return found;
    }

	public boolean withdraw(String clientName, int amount){
		Iterator<Client> it = clients.iterator();
		boolean found = false;
		while (it.hasNext()){
			Client c = it.next();
			if (c.getName().equals(clientName)){
				found = true;
				c.withdraw(amount);
			}
		}
		return found;

	}
}
