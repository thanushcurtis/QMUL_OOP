import javax.management.AttributeNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws AttributeNotFoundException {
        new Main();
    }

    //Array List
    private final Account_List acc_list = new Account_List();


    // Q1 Destructive method
    public static ArrayList<String> des_sort_array(ArrayList<String> array, int n)
    {


        for (int i=0; i< array.size(); i++)
        {

            String item = String.valueOf(array.get(i));
            int item_length = item.length();
            if(item_length<n)
            {
                array.remove(i);
                i--;
            }
        }
        return array;

    }

    //Q2 Constructive Method
    public static ArrayList<String> con_sort_array(ArrayList<String> array,int n)
    {

        ArrayList<String> list_1 = new ArrayList<>();
        for (String s : array) {

            String item = String.valueOf(s);
            int item_length = item.length();
            if (item_length >= n) {
                list_1.add(s);
            }
        }
        return list_1;

    }


    //generic method
    public static <T> ArrayList<T> gen_des_sort_array(ArrayList<T> list,T m, T n)
    {
        int array_size = list.size();
        boolean first_occur  = false;
        for(int i=0; i<array_size; i++) {

            T e = list.get(i);
            if (e.equals(m) && !first_occur) {
                first_occur = true;
                list.set(i, n);
            }
        }

        return list;
    }



    public static <T> ArrayList<T> gen_con_sort_array(ArrayList<T> list,T m, T n)
    {
        ArrayList<T> list_1 = new ArrayList<>();
        boolean first_occur  = false;
        for (T e : list) {

            if (e.equals(m) && !first_occur) {
                first_occur = true;
                list_1.add(n);
            } else {
                list_1.add(e);
            }
        }

        return list_1;
    }


    public static void Q1_Test(){
        System.out.println("**************************************************");
        System.out.println("Running test 1");
        ArrayList<String> example_array = new ArrayList<>();
        example_array.add("tomato");
        example_array.add("cheese");
        example_array.add("chips");
        example_array.add("fruit");
        example_array.add("pie");
        example_array.add("butter");
        example_array.add("tea");
        example_array.add("buns");
        System.out.println("Test Array ");
        System.out.println(example_array);
        System.out.println("Output :");
        System.out.println();
        System.out.println(des_sort_array(example_array,4));

    }

    public static void Q2_Test(){
        System.out.println("**************************************************");
        System.out.println("Running test 2");
        ArrayList<String> example_array = new ArrayList<>();
        example_array.add("tomato");
        example_array.add("cheese");
        example_array.add("chips");
        example_array.add("fruit");
        example_array.add("pie");
        example_array.add("butter");
        example_array.add("tea");
        example_array.add("buns");
        System.out.println("Test Array ");
        System.out.println(example_array);
        System.out.println("Output :");
        System.out.println();
        System.out.println(con_sort_array(example_array,4));

    }

    public static void Q3_Test(){

        System.out.println("**************************************************");
        System.out.println("Running test 3");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(12);
        list.add(4);
        list.add(16);
        list.add(4);
        list.add(2);
        list.add(2);

        System.out.println("Test Array ");
        System.out.println(list);
        System.out.println("Output :");
        System.out.println();
        System.out.println(gen_des_sort_array(list,4,7));

    }

    public static void Q4_Test(){

        System.out.println("**************************************************");
        System.out.println("Running test 4");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Tree");
        list2.add("Cat");
        list2.add("Mouse");
        list2.add("Play");
        list2.add("B");
        list2.add("Mouse");
        list2.add("C");
        System.out.println("Test Array ");
        System.out.println(list2);
        System.out.println("Output :");
        System.out.println();
        System.out.println(gen_con_sort_array(list2,"Mouse","Play"));

    }


    public void R4_Test() throws AttributeNotFoundException {
        System.out.println("**************************************************");
        System.out.println("Running test 5");

        acc_list.addAccount( new Account1(1000));
        acc_list.addAccount( new Account1(1001));
        acc_list.addAccount( new Account1(2002));
        acc_list.addAccount( new Account1(1003));
        acc_list.addAccount( new Account1(1006));
        acc_list.addAccount( new Account1(1005));


        System.out.println("Checking All Accounts for Highest Balance...");
        System.out.println("Account with highest Balance is: "+acc_list.High_Acc().getBalance()+"");
        System.out.println();
        System.out.println("Total balance overall of the list: "+acc_list.total_list_balance());
        System.out.println();
        System.out.println("Balance of that Lowest Account: "+acc_list.Get_Low_Deposit().getBalance());
        System.out.println();
        System.out.println("Account with Lowest Balance: "+acc_list.Get_Low_Deposit().getBalance()+" New amount deposited into this account, new balance is "+ acc_list.Low_Deposit(150).getBalance());
        acc_list.getAccount_Id(1000);
        acc_list.Remove_Account_Id(10097);
        System.out.println("Items in the array after removal with their unique id's");
        acc_list.print_array();


    }








    public Main() throws AttributeNotFoundException {

        Q1_Test();
        Q2_Test();
        Q3_Test();
        Q4_Test();
        R4_Test();
    }
}
