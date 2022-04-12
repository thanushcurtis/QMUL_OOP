import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public  class SupplierWindow  extends JFrame{

    JLabel Type = new JLabel("Type: ");
    JTextArea type = new JTextArea();

    JButton viewInvoice;
    TextField input_name = new TextField("", 20);

    JLabel Name = new JLabel("Name: ");
    JLabel Email = new JLabel("Email: ");
    JLabel Address = new JLabel("Address: ");
    JLabel Total = new JLabel("Total Due: ");



    JTextArea name = new JTextArea();
    JTextArea email = new JTextArea();
    JTextArea address = new JTextArea();
    JTextArea  totalDue= new JTextArea();

    public SupplierWindow(){

        this.setSize(400,400);
        this.setLayout(new GridLayout(6,2,20,30));
        Name.setHorizontalAlignment(JLabel.LEFT);
        this.add(Name);
        this.add(name);
        name.setEditable(false);
        Type.setHorizontalAlignment(JLabel.LEFT);
        this.add(Type);
        this.add(type);
        type.setEditable(false);
        Email.setHorizontalAlignment(JLabel.LEFT);
        this.add(Email);
        this.add(email);
        email.setEditable(false);
        Address.setHorizontalAlignment(JLabel.LEFT);
        this.add(Address);
        this.add(address);
        email.setEditable(false);
        Total.setHorizontalAlignment(JLabel.LEFT);
        this.add(Total);
        this.add(totalDue);
        totalDue.setEditable(false);
        viewInvoice = new JButton("View Invoices");
        viewInvoice.setBounds(100, 100, 50, 50);
        this.add(viewInvoice);
        viewInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });

    }

    public void addSubmitListener(ActionListener listener){
        viewInvoice.addActionListener(listener);
    }
    public void set_text(String message, JTextArea TextArea)
    {
        TextArea.setText(message);
    }

    public void set_double(double amount, JTextArea TextArea)
    {
        TextArea.setText(String.valueOf(amount));
    }


    public void activate(){
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
    }

}
