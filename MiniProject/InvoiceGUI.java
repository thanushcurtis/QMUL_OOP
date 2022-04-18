import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InvoiceGUI extends JFrame {
    JLabel enter_type = new JLabel("Enter Type");

    JRadioButton supplier = new JRadioButton("Supplier");
    JRadioButton customer = new JRadioButton("Customer");
    JLabel name = new JLabel("Name:  ");
    JTextField Name = new JTextField();
    JTextArea output = new JTextArea();
    JButton submit = new JButton("Submit");
    GridBagConstraints c = new GridBagConstraints();
    ButtonGroup btg = new ButtonGroup();
    String selection;


    public InvoiceGUI() {
        this.setSize(300, 250);
        this.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(enter_type, c);
        enter_type.setHorizontalAlignment(JLabel.LEFT);
        supplier.setBounds(100, 100, 50, 50);
        supplier.setActionCommand("s");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        this.add(supplier, c);
        customer.setBounds(100, 100, 50, 50);
        customer.setActionCommand("c");
        btg.add(supplier);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        this.add(customer, c);
        btg.add(customer);
        c.insets = new Insets(10, 0, 0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(name, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        this.add(Name, c);
        c.ipady = 40;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(output, c);
        submit.setBounds(100, 100, 50, 50);
        c.ipady = 0;
        c.gridwidth = 0;
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(submit, c);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });

    }
    public void addSubmitListener(ActionListener listener){
        submit.addActionListener(listener);
    }
    public void set_text(String message)
    {
        output.setText(message);
    }

    public String get_selection()
    {
        selection = this.btg.getSelection().getActionCommand();
        return selection;
    }

    public String get_input_text()
    {
        return  Name.getText();
    }
    public void activate(){
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
        this.pack();
    }


}
