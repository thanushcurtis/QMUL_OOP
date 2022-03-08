/**
 * ECS414U - Object Oriented Programming
 * Queen Mary University of London, 2021/22.
 * <p>
 * Week 5 lab session.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
public class BankingApp extends Frame{

	/*
	 * We will use this to print messages to the user.
	 */
	private static TextArea infoArea = new TextArea("BankingApp 0.5");

	// printing main outputs into the output text field
	public static void print(String text){
		infoArea.setText(text);
	}


	private Agent agent;
	private Panel clientButtonsPanel;



	/**
	 * This method prints the names of all clients.
	 */
	public void printClients(){
		String text = agent.getListOfClientNames();
		print(text);
	}

	/**
	 * This method prints the information of the client with the given index.
	 */
	public void printClientInfo(int index){
		String text = agent.getClientInfo(index);
		print(text);
	}


	/**
	 * This method takes all the necessary steps when a client is added.
	 */
	public void addClient(String name){
		agent.addClient(new Client(name));

		// Uncomment for R3
		int numClients = agent.getNumberOfClients();
		Button btn = new Button("Client " + numClients);
		// print client's name and info
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s){
				if(s.getSource()==btn)
				{
					print(agent.getClientInfo(numClients-1));
				}
			}
		});
		clientButtonsPanel.add(btn);
		this.setVisible(true); // Just to refresh the frame, so that the button shows up

	}

	// method for remove the clients
	public Boolean removeClient(String name){

		int index = agent.getClientindex(name);
		System.out.println(index);
		clientButtonsPanel.remove(index);
		Boolean success = agent.removeClient(name);
		return success;
	}


	public BankingApp(){


		this.agent = new Agent();
		this.setLayout(new FlowLayout());

		// Print client details
		Button reportButton=new Button("Print client list");
		this.add(reportButton);
		reportButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				if(evt.getSource()==reportButton)
				{
					printClients();
				}
			}
		});

		// add clients
		Button addClientButton=new Button("Add client");
		addClientButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Prompt acp = new Prompt();
				acp.setSize(400,400);
				acp.setLayout(new GridLayout(3,1));
				Label label = new Label("Enter Client Name: ");
				label.setAlignment(Label.CENTER);
				acp.add(label);
				TextField input_name = new TextField("",20);
				acp.add(input_name);
				acp.activate();
				acp.addSubmitListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						addClient(input_name.getText());
					}
				});
			}
		});

		this.add(addClientButton);

		//remove clients
		Button removeClientButton = new Button(" Remove Client");
		removeClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				transaction_window win = new transaction_window();
				win.activate();
				win.setSize(250,300);
				win.amount.setVisible(false);
				win.amount_label.setVisible(false);
				win.addSubmitListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Boolean success = removeClient(win.get_name());
						if(success)
						{
							win.print_output("Success");
							win.dispose();
						}
						else
						{
							win.print_output("Error");
						}
					}
				});

			}
		});

		this.add(removeClientButton);

		// deposit window
		Button depositButton = new Button("Deposit");
		this.add(depositButton);
		//deposit action
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				if(d.getSource()==depositButton)
				{
					transaction_window win = new transaction_window();
					win.activate();
					win.addSubmitListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Boolean success = agent.deposit(win.get_name(),win.get_amount());
							if(success)
							{
								win.print_output("Success");
								win.dispose();
							}
							else
							{
								win.print_output("Error");
							}
						}
					});
				}
			}
		});

		//withdraw button
		Button Withdrawbutton = new Button("Withdraw");
		this.add(Withdrawbutton);
		//withdraw action
		Withdrawbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				if(d.getSource()==Withdrawbutton)
				{
					transaction_window win = new transaction_window();
					win.activate();
					win.addSubmitListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Boolean success = agent.withdraw(win.get_name(),win.get_amount());
							if(success)
							{
								win.print_output("Success");
								win.dispose();
								win.set_text();
							}
							else
							{
								win.print_output("Error");
							}
						}
					});
				}
			}
		});
		this.add(infoArea);

		// Client button panel
		//
		clientButtonsPanel = new Panel();
		clientButtonsPanel.setLayout(new GridLayout(0,1));
		clientButtonsPanel.setVisible(true);
		this.add(clientButtonsPanel);



		// We add a couple of clients of testing purposes
		this.addClient("Alice Alison");
		this.addClient("Bob Robertson");


		// This is just so the X button closes our app
		WindowCloser wc = new WindowCloser();
		this.addWindowListener(wc);

		this.setSize(500,500);// Self explanatory
		this.setLocationRelativeTo(null); // Centers the window on the screen
		this.setVisible(true);//

	}

	public static void main(String[] args){
		new BankingApp();
	}
}
