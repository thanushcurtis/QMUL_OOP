import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class InvoiceMainGUI extends JFrame {

    static String[] vatTab = {"5%","8%","23%"};
    private static int i =0;

    static String[] columnNames = {"No", "Product Name", "Quantity", "Sales price", "Total", "VAT Rate", "VAT", "Gross"};
    static DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
    static JTable table = new JTable(dtm);

    static JLabel name = new JLabel("Product Name: ");
    static JTextField tf = new JTextField();

    static JLabel quantity = new JLabel("Quantity: ");
    static JTextField tf2 = new JTextField();

    static JLabel price = new JLabel("Unit price: ");
    static JTextField tf3 = new JTextField();

    static JLabel vatR = new JLabel("VAT Rate:");
    static JComboBox chooseVat = new JComboBox(vatTab);

    static JScrollPane scrollPane = new JScrollPane(table);
    static JLabel empty = new JLabel();

    private static JButton addProduct = new JButton("Add product");
    private static JButton clear = new JButton("Clear");
    private static JButton read = new JButton("Read from file");
    private static JButton save = new JButton("Save to file");

    public void addRow(String tf, int tf2, double tf3, Object chooseVat, double total, double vat, double gross)
    {
        Object[] row = {++i, tf, tf2, String.format("%.2f", tf3), chooseVat, total, String.format("%.2f", vat),
                String.format("%.2f", gross)};
        dtm.addRow(row);
    }






}
