import com.sun.tools.javah.Gen;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class BusinessApp extends JFrame implements GenericMethods {

    public static final Database database = new Database();

    public static void main(String[] args)
    {
        new BusinessApp();
    }


    //print the functions the user can use
    public static void Intro()
    {

        GenericMethods.print("Welcome to TC's Business");
        GenericMethods.print("1 : to View Customer Details");
        GenericMethods.print("2 : to Enter New Customer");
        GenericMethods.print("3 : to view Supplier's Details");
        GenericMethods.print("4 : to Enter Supplier's Details");
        GenericMethods.print("5 : Add Products");
        GenericMethods.print("6 : Add Invoice");
        GenericMethods.print("7 : Stop the program");
        GenericMethods.print("");


    }


    //getting which function to operate from user
    public static int FunQuestion(){
        int FunctionInput=0;
        try{
            FunctionInput = GenericMethods.input_int("Enter the function you want to perform?");
            while(FunctionInput<0 || FunctionInput>8)
            {
                FunctionInput=GenericMethods.input_int(("Please enter an integer between 0 and 2"));
            }
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Please enter a valid integer!!!");
            FunQuestion();
        }

        return FunctionInput;
    }

    //choosing the function to operate
    public void ChooseFunction()
    {
        boolean stop =false;
        while(!stop)
        {
            int FunChoice = FunQuestion();
            if(FunChoice==1)
            {
                database.GetCustomerDetails();
            }
            else if(FunChoice==2)
            {
                database.SetNewCustomer();
            }
            else if(FunChoice==3)
            {
                database.GetSupplierDetails();
            }
            else if(FunChoice==4)
            {
                database.SetNewSupplier();
            }
            else if(FunChoice==5)
            {
                database.addProducts();
            }
            else if(FunChoice==6)
            {

                database.addInvoice();
            }
            else if(FunChoice==7)
            {
                stop=true;
            }
        }
        GenericMethods.print("thank you");
        System.exit(0);

    }

    public BusinessApp(){

        // Adding Customer's for testing
        Customer c = new Customer("Thanush","Thanushcurtis@gmail.com", 0772L,"2, Pollard Road");
        Product p = new Product("Apple",3.4,2,15);
        Product p1 = new Product("Orange", 2.0,1,20);
        Supplier s = new Supplier("Jack","34, Prade Street","jack@gmail.com");
        s.SetType("Fruits");
        database.addCustomer(c);
        database.addSupplier(s);
        database.addProduct(p);
        database.addProduct(p1);

        //Intro();
        //ChooseFunction();




        //GUI workings
        JFrame MainFrame =  new JFrame();
        MainFrame.setTitle("TK's Business");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setSize(600,400);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);



        JLabel title_label = new JLabel();
        title_label.setText("Welcome to TK's Business");
        title_label.setHorizontalAlignment(JLabel.CENTER);
        title_label.setVerticalAlignment(JLabel.TOP);
        title_label.setFont(new Font("MV Boli", Font.BOLD,20));
        title_label.setBorder(createRootPane().getBorder());
        MainFrame.getContentPane().add(BorderLayout.NORTH,title_label);
        MainFrame.getContentPane().setBackground(new Color(242, 242, 242));



        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(4,3,20,40));
        MainPanel.setVisible(true);
        MainFrame.getContentPane().add(BorderLayout.CENTER,MainPanel);


        JButton CustomerButton  = new JButton("View Customers");
        CustomerButton.setBounds(100,100,50,50);
        CustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               View_Window win = new View_Window();
               win.activate();
               win.setSize(250,200);
               win.set_text("");
               win.addSubmitListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {

                       if(database.GetCustomerDetailsGUI(win.get_name()))
                       {
                           GenericMethods.print(win.get_name());
                           win.set_text("Customer found");
                           DetailsWindow detailsWindow = new DetailsWindow();
                           detailsWindow.activate();
                           Customer c = database.returnCustomer(win.get_name());
                           detailsWindow.set_text(database.GetCustomerName(c), detailsWindow.name );
                           detailsWindow.set_text(database.GetCustomerEmail(c),detailsWindow.email);
                           detailsWindow.set_text(database.GetCustomerAddress(c),detailsWindow.address);
                           detailsWindow.set_double(database.GetCustomerDue(c),detailsWindow.totalDue);
                           detailsWindow.addSubmitListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   InvoicePanel invoicePanel =new InvoicePanel();
                                   for(int i=0; i<database.InvoiceArray(c).size()-1; i++)
                                   {
                                       JButton InvoiceButton = new JButton(c.getInvoiceRef(i));
                                       InvoiceButton.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               if(e.getSource()==InvoiceButton)
                                               {
                                                   //new panel with invoice details
                                               }
                                           }
                                       });
                                       invoicePanel.getContentPane().add(InvoiceButton);
                                   }
                               }
                           });
                       }
                       else
                       {
                           win.set_text("Customer not found");
                       }
                   }
               });

            }
        });

        JButton SupplierButton  = new JButton("View Suppliers");
        SupplierButton.setBounds(100,100,50,50);
        SupplierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_Window win = new View_Window();
                win.activate();
                win.setSize(250,200);
                win.label.setText("Enter Supplier Name ");
                win.addSubmitListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(database.GetSupplierDetailsGUI(win.get_name()))
                        {
                            win.set_text("Supplier found");
                            SupplierWindow supplierWindow = new SupplierWindow();
                            supplierWindow.activate();
                            Supplier s = database.returnSupplier(win.get_name());
                            supplierWindow.set_text(database.GetSupplierName(s),supplierWindow.name);
                            supplierWindow.set_text(database.GetSupplierType(s),supplierWindow.type);
                            supplierWindow.set_text(database.GetSupplierEmail(s),supplierWindow.email);
                            supplierWindow.set_text(database.GetSupplierAddress(s),supplierWindow.address);
                            supplierWindow.set_double(database.GetSupplierOwe(s),supplierWindow.totalDue);
                            supplierWindow.addSubmitListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    InvoicePanel invoicePanel =new InvoicePanel();
                                    GenericMethods.print(("test"));
                                    for(int i=0; i<database.InvoiceArraySupplier(database.returnSupplier(win.get_name())).size()-1; i++)
                                    {
                                        JButton InvoiceButton = new JButton(database.returnCustomer(win.get_name()).getInvoiceRef(i));
                                        InvoiceButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                if(e.getSource()==InvoiceButton)
                                                {
                                                    //new panel with invoice details
                                                }
                                            }
                                        });
                                        invoicePanel.getContentPane().add(InvoiceButton);
                                    }
                                }
                            });
                        }
                        else
                        {
                            win.set_text("Supplier not found");
                            win.clear();
                        }
                    }
                });

            }
        });


        JButton EnterCustomer =  new JButton("Enter Customer");
        EnterCustomer.setBounds(100,100,50,50);
        EnterCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputWindow win = new InputWindow();
                win.activate();
                win.setSize(350,400);
                win.setTitle("Enter New Customer");
                win.addSubmitListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = win.name.getText();
                        String email = win.email.getText();
                        String address = win.address.getText();
                        Long num = Long.parseLong(win.num.getText());
                        if(database.setNewCustomerGUI(name,email,num,address))
                        {
                            win.set_text("Customer Successfully Created");
                        }
                        else
                        {
                            win.set_text("Error");
                        }
                    }
                });
                //win.dispose();
            }
        });


        JButton EnterSupplier = new JButton("Enter Supplier");
        EnterSupplier.setBounds(100,100,50,50);
        EnterSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputWindow win = new InputWindow();
                win.activate();
                win.setSize(350,400);
                win.setTitle("Enter New Supplier");
                win.setLabel("Type");
                win.addSubmitListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = win.name.getText();
                        String email = win.email.getText();
                        String address = win.address.getText();
                        String type = win.num.getText();
                        database.setNewSupplierGUI(name,email,type,address);
                    }
                });

                //win.dispose();
            }
        });


        JButton EnterProducts = new JButton("Enter Products");
        EnterProducts.setBounds(100,100,50,50);
        EnterProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputWindow win = new InputWindow();
                win.activate();
                win.setTitle("Products");
                JButton ViewProduct = new JButton("View Product");
                win.setLabelGeneral("Sales Price ",win.Email);
                win.setLabelGeneral("Costs Price ",win.Address);
                win.setLabelGeneral("Stock Count ",win.Num);
                win.removeArea();
                win.add(ViewProduct);
                win.addSubmitListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = win.name.getText();
                        Double salesPrice = Double.parseDouble(win.email.getText());
                        Double costsPrice = Double.parseDouble(win.address.getText());
                        int stockcount = Integer.parseInt(win.num.getText());
                        database.addProdctsGUI(name,salesPrice,costsPrice,stockcount);

                    }
                });
                ViewProduct.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        View_Window win = new View_Window();
                        win.activate();
                        win.setSize(250,200);
                        win.setLabelTitle("Enter Product Name ");
                        win.addSubmitListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                win.print_output("");
                                String product_name = win.get_name();
                                Product p = database.getProductByName(product_name);
                                if(p!=null)
                                {
                                    win.addSubmitListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            InputWindow win = new InputWindow();
                                            win.activate();
                                            win.setTitle("Product Details");
                                            win.setLabelGeneral("Sales Price ",win.Email);
                                            win.setLabelGeneral("Costs Price ",win.Address);
                                            win.setLabelGeneral("Stock Count ",win.Num);
                                            win.removeArea();
                                            win.name.setText(p.getName());
                                            win.email.setText("£"+p.getSalesPrice());
                                            win.address.setText("£"+p.getCostsPrice());
                                            win.num.setText(String.valueOf(p.getStockCount()));
                                            win.removeButton();
                                        }
                                    });
                                }
                                else
                                {
                                    win.print_output("Product Not Found");
                                    win.clear();
                                }
                                win.clear();
                            }
                        });
                    }
                });
            }
        });

        JButton AddInvoice = new JButton("Add Invoice");
        AddInvoice.setBounds(100,100,50,50);
        AddInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvoiceGUI  win = new InvoiceGUI();
                win.activate();
                win.addSubmitListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GenericMethods.print(win.get_selection());
                        String choice = win.get_selection();
                        if(choice.equals("c"))
                        {
                            String name = win.get_input_text();
                            GenericMethods.print(name);
                            Customer c = database.returnCustomer(name);
                            while(c!=null)
                            {
                                GenericMethods.print("test");

                            }
                            win.set_text("Customer not found!!!");
                            win.Name.setText("");

                        }
                        else if(choice.equals("s"))
                        {
                            String name = win.get_input_text();
                            GenericMethods.print(name);
                            Supplier s = database.returnSupplier(name);
                            while(s!=null)
                            {
                                GenericMethods.print("test");

                            }
                            win.set_text("Supplier not found!!!");
                            win.Name.setText("");
                        }
                    }
                });
            }
        });

        JButton StopProgram = new JButton("Stop Program");
        StopProgram.setBounds(100,100,50,100);


        MainPanel.add(CustomerButton);
        MainPanel.add(SupplierButton);
        MainPanel.add(EnterCustomer);
        MainPanel.add(EnterSupplier);
        MainPanel.add(EnterProducts);
        MainPanel.add(AddInvoice);
        MainFrame.add(BorderLayout.SOUTH,StopProgram);


        MainFrame.setVisible(true);



    }



}
