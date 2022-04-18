/*
 * GUI
 *
 * Grzegorz Futa (c) 2014
 *
 * version 10.0
 *
 * Grupa: KrZZIs2013
 *
 * Wyœwietlenie GUI z mo¿liwoœci¹ dodawania produktów do tabeli, czyszczenia jej zawartoœci,
 * wczytywaniem danych oraz zapisem danych do pliku
 *
 * Uruchomienie: java GUI
 *
 */

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

class Okno extends JFrame {

    static String[] vatTab = {"5%", "8%", "23%"};

    private static int i = 0;

    static String[] columnNames = {"No", "Product Description", "Quantity", "Unit price", "Total", "VAT Rate", "VAT", "Gross"};
    static DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
    static JTable table = new JTable(dtm);

    static JLabel description = new JLabel("Product Description: ");
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


    class AddRow implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //String tf = BusinessApp.database.re().getDescription();
            //int tf2 = Products.getQuantity();
            //double tf3 = Products.getPrice();
            //Object chooseVat = Products.getVatRate();
            //double total = Products.calculateTotal();
            //double vat = Products.calculateVat();
            //double gross = Products.calculateGross();
            //addRow(tf, tf2, tf3, chooseVat, total, vat, gross);
            //repaint();
        }
    }

    class Clear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dtm.setRowCount(0);
        }
    }

    static class Loading {
        static String whiteLine = "";

        public static void loadFile() throws IOException {
            BufferedReader buffer = new BufferedReader(new FileReader("products.csv"));
            while ((whiteLine = buffer.readLine()) != null) {
                dtm.addRow(whiteLine.split(","));
            }
        }
    }

    static class Saving {

        public static void saveFile() throws Exception {
            BufferedWriter buffer = new BufferedWriter(new FileWriter("products.csv"));
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    buffer.write(table.getValueAt(row, col).toString());
                    buffer.write(",");
                }
                buffer.newLine();
            }
            buffer.close();
        }
    }

    static class ReadFromFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dtm.setRowCount(0);
            try {
                Loading.loadFile();
                i = table.getRowCount();
            }
            catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    static class SaveToFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Saving.saveFile();
            }
            catch (Exception io) {
                io.printStackTrace();
            }
        }
    }


    public Okno() {
        super("Products");

        AddRow aProduct = new AddRow();
        addProduct.addActionListener(aProduct);

        Clear clearAll = new Clear();
        clear.addActionListener(clearAll);

        ReadFromFile load = new ReadFromFile();
        read.addActionListener(load);

        SaveToFile write = new SaveToFile();
        save.addActionListener(write);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        DefaultTableCellRenderer right = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        right.setHorizontalAlignment(JLabel.RIGHT);

        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        GroupLayout layout = new GroupLayout(getRootPane());
        getRootPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);


        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(description)
                                .addComponent(quantity)
                                .addComponent(price)
                                .addComponent(vatR)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tf)
                                .addComponent(tf2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 100)
                                .addComponent(tf3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 100)
                                .addComponent(chooseVat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 50)
                                .addComponent(addProduct)
                        )
                )
                .addComponent(scrollPane)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empty, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 500)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(clear)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(read)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(save)
                        )
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(description)
                        .addComponent(tf)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity)
                        .addComponent(tf2)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(price)
                        .addComponent(tf3)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(vatR)
                        .addComponent(chooseVat)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addProduct)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollPane)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(empty)
                        .addComponent(clear)
                        .addComponent(read)
                        .addComponent(save)
                )
        );

        setBackground(Color.WHITE);

    }

}


public class GUI {

    public static void main(String[] args) {
        Okno okno = new Okno();
        okno.setVisible(true);

    }
}