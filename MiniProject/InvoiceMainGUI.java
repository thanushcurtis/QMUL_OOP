import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
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

    static JLabel output = new JLabel("Output: ");
    static JTextField tf3 = new JTextField();

    static JLabel vatR = new JLabel("VAT Rate:");
    static JComboBox<String> chooseVat = new JComboBox<>(vatTab);

    static JScrollPane scrollPane = new JScrollPane(table);
    static JLabel empty = new JLabel();


    private static JButton addProduct = new JButton("Add product");
    private static JButton clear = new JButton("Clear");
    private static JButton save = new JButton("Save to file");
    private static JButton addInvoice = new JButton("Add Invoice");



    private final ArrayList <Product> Product_Array = new ArrayList<>();
    private final ArrayList <Double> Gross_Array = new ArrayList<>();

    public void addRow(String tf, int tf2, double tf3, Object chooseVat, double total, double vat, double gross)
    {
        Object[] row = {++i, tf, tf2, String.format("%.2f", tf3), total,chooseVat, String.format("%.2f", vat),
                String.format("%.2f", gross)};
        dtm.addRow(row);
    }



    class AddRow implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String tf = Product.getDescription();
            Product p = BusinessApp.database.getProductByName(tf);
            Product_Array.add(p);
            int tf2 = Product.getQuantity();
            double tf3 = Product.getPrice();
            Object chooseVat = Product.getVatRate();
            double total = Product.calculateTotal();
            double vat = Product.calculateVat();
            double gross = Product.calculateGross();
            Gross_Array.add(gross);
            addRow(tf, tf2, tf3, chooseVat, total, vat, gross);
            repaint();
        }
    }

    class Clear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dtm.setRowCount(0);
        }
    }



    static class Saving {

        public static void saveFile() throws Exception {
            BufferedWriter buffer = new BufferedWriter(new FileWriter("invoice.csv"));
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



    public InvoiceMainGUI(){
        this.setTitle("Invoice");
        AddRow aProduct = new AddRow();
        addProduct.addActionListener(aProduct);

        Clear clearAll = new Clear();
        clear.addActionListener(clearAll);


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
                                .addComponent(name)
                                .addComponent(quantity)
                                .addComponent(output)
                                .addComponent(vatR)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tf)
                                .addComponent(tf2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 100)
                                .addComponent(tf3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
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
                                .addComponent(save)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addInvoice)
                        )
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(name)
                        .addComponent(tf)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity)
                        .addComponent(tf2)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(output)
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
                        .addComponent(save)
                        .addComponent(addInvoice)
                )
        );

        setBackground(Color.WHITE);


        addInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dtm.setRowCount(0);
                i=0;
                dispose();


            }

        });
    }

    public ArrayList<Product> getProduct_Array() {
        return this.Product_Array;
    }

    public ArrayList<Double> getGross_Array() {
        return this.Gross_Array;
    }


    public JButton returnAddInvoice()
    {
        return addInvoice;
    }

    public void activate(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }




}
