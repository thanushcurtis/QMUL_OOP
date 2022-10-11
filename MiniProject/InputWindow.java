import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
public class InputWindow extends JFrame{

    private JButton submit;
    private static JTextArea text_area = new JTextArea("",3,20);
    JLabel Name = new JLabel("Name: ");
    JLabel Email = new JLabel("Email: ");
    JLabel Address = new JLabel("Address: ");
    JLabel Num = new JLabel("Telephone: ");


    public static void print_output(String text){
        text_area.setText(text);
       text_area.setEditable(false);
    }

   JTextField name = new JTextField();
   JTextField email = new JTextField();
   JTextField address = new JTextField();
   JTextField  num = new JTextField();


   public InputWindow(){

       //inputwindow

       this.setSize(400,400);
       this.setLayout(new GridLayout(5,2,20,30));
       Name.setHorizontalAlignment(JLabel.LEFT);
       this.add(Name);
       this.add(name);
       Email.setHorizontalAlignment(JLabel.LEFT);
       this.add(Email);
       this.add(email);
       Address.setHorizontalAlignment(JLabel.LEFT);
       this.add(Address);
       this.add(address);
       num.setHorizontalAlignment(JLabel.LEFT);
       this.add(Num);
       this.add(num);
       this.add(text_area);
       submit = new JButton("Submit");
       submit.setBounds(100,100,50,50);
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
    public void set_text(String message)
    {
        text_area.setText(message);
    }

    public void activate(){
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
    }

    public void setLabel(String title)
    {
        Num.setText(title);
    }

    public void setLabelGeneral(String title, JLabel label)
    {
        label.setText(title);
    }

    public void removeArea()
    {
        this.remove(text_area);
    }

    public void removeButton()
    {
        this.remove(submit);
    }

}
