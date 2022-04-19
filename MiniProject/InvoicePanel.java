import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class InvoicePanel extends InvoiceWindow{
    JPanel InvoiceButtonsPanel =new JPanel();
    JTextArea output = new JTextArea();

    public InvoicePanel(){


        this.setSize(400,400);
        this.setLayout(new FlowLayout());
        InvoiceButtonsPanel.setLayout(new GridLayout(0,1));
        InvoiceButtonsPanel.setVisible(true);
        this.add(InvoiceButtonsPanel);
        this.add(output);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });

    }
    public void AddButton(JButton btn)
    {
        InvoiceButtonsPanel.add(btn);
    }

    public void print(String text){
        output.setText(text);
    }

    public void activate()
    {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}
