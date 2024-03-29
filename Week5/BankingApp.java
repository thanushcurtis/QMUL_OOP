/**
 * ECS414U - Object Oriented Programming
 * Queen Mary University of London, 2021/22.
 * <p>
 * Week 5 lab session.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingApp extends Frame{

	/*
	 * We will use this to print messages to the user.
	 */
	private static TextArea infoArea = new TextArea("BankingApp 0.5");
	private static TextArea deposit_area = new TextArea("",5,20);

	public static void print(String text){
		infoArea.setText(text);
	}
	public static void print_deposit(String text){
		deposit_area.setText(text);
	}

	//---


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




		// deposit window
		Frame deposit = new Frame();
		deposit.setSize(250,400);
		deposit.setLayout(new FlowLayout());
		Label label = new Label("Enter Client Name: ");
		label.setAlignment(Label.LEFT);
		deposit.add(label);
		TextField input_name = new TextField("",20);
		deposit.add(input_name);
		Label amount_label = new Label("Enter Amount: ");
		label.setAlignment(Label.LEFT);
		deposit.add(amount_label);
		TextField amount = new TextField("",20);
		deposit.add(amount);
		deposit.add(deposit_area);
		Button depositButton = new Button("Deposit");
		this.add(depositButton);
		Button submit = new Button("Submit");
		submit.setBounds(100,100,50,50);
		deposit.add(submit);
		deposit.setLocationRelativeTo(null);
		deposit.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt) {
				((Frame)(evt.getSource())).dispose();
			}
		});

		//deposit action
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent d) {
				if(d.getSource()==depositButton)
				{
					deposit.setVisible(true);
					submit.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent g) {

							Boolean success=agent.deposit(input_name.getText(),Integer.parseInt(amount.getText()));
							if(success)
							{
								print_deposit("Success");
								deposit.dispose();
								amount.setText("0");
							}
							else
							{
								print_deposit("Error!");
							}

						}
					});
				}
			}
		});
		
		// Output console
		infoArea.setEditable(false);
		deposit_area.setEditable(false);
		this.add(infoArea);

		// Client button panel
		// Uncomment for R3
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
		this.setVisible(true);// Self explanatory

	}

	public static void main(String[] args){
		new BankingApp();
	}
}
