import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class InvoicePanel extends InvoiceWindow{

    public InvoicePanel(){


        this.setSize(400,400);
        this.setLayout(new FlowLayout());
        JPanel InvoiceButtonsPanel = new JPanel();
        InvoiceButtonsPanel.setLayout(new GridLayout(0,1));
        InvoiceButtonsPanel.setVisible(true);
        this.getContentPane().add(InvoiceButtonsPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }


}
