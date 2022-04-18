import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;


public class View_Window extends JFrame {

    private JButton submit;
    private static JTextArea transaction_area = new JTextArea("",3,20);
    JTextField input_name = new JTextField("", 20);
    JLabel label = new JLabel("Enter Customer Name or Reference: ");

    public void print_output(String text){
        transaction_area.setText(text);
        transaction_area.setEditable(false);
    }

    public View_Window(){

        this.setSize(400,400);
        this.setLayout(new FlowLayout());
        label.setHorizontalAlignment(JLabel.LEFT);
        this.add(label);
        this.add(input_name);
        this.add(transaction_area);
        submit = new JButton("Submit");
        submit.setBounds(100, 100, 50, 50);
        this.add(submit);
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
    public void set_text(String message)
    {
        transaction_area.setText(message);
    }


    public void activate(){
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
    }
    public void clear()
    {
        input_name.setText("");
    }

    public void setLabelTitle(String title)
    {
        this.label.setText(title);
    }

}
