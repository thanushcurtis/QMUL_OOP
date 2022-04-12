import java.awt.*;
import java.awt.event.*;
public class transaction_window extends Frame {
    private Button submit;
    private static TextArea transaction_area = new TextArea("",5,20);
    TextField input_name = new TextField("", 20);
    TextField amount = new TextField("", 20);
    Label label = new Label("Enter Client Name: ");
    Label amount_label = new Label("Enter Amount: ");
    public static void print_output(String text){
        transaction_area.setText(text);
        transaction_area.setEditable(false);
    }

    public transaction_window() {
        this.setSize(250, 500);
        this.setLayout(new FlowLayout());
        label.setAlignment(Label.LEFT);
        this.add(label);
        this.add(input_name);
        label.setAlignment(Label.LEFT);
        this.add(amount_label);
        this.add(amount);
        this.add(transaction_area);
        submit = new Button("Submit");
        submit.setBounds(100, 100, 50, 50);
        this.add(submit);
        submit.addActionListener(new ActionListener() {
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
        submit.addActionListener(listener);
    }

    public String get_name()
    {
        return input_name.getText();
    }
    public int get_amount()
    {
        return Integer.parseInt(amount.getText());
    }

    public void set_text()
    {
        amount.setText("0");
    }

    public void clear()
    {
        print_output("");
    }


    public void activate(){
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
    }
}