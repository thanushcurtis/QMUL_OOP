import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public interface GenericMethods {

    static void print(String message)
    {
        System.out.println(message);
    }

    // methods for asking a questions, and return the value that user inputted
    static String ask_questions(String question) //initialises the method
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question); //asks the questions passed when the method called
        return scanner.nextLine(); //returns the value user types in
    }

    //converting string to method
    static int input_int(String message) //converting string to method
    {
        return Integer.parseInt(ask_questions(message));
    }
    static double input_double(String message) //converting string to method
    {
        return Double.parseDouble(ask_questions(message));
    }

    static long input_phone(String message) //converting string to method
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message); //asks the questions passed when the method called
        return scanner.nextLong();
    }

    //date validation
    static Date validateJavaDate(String strDate)
    {
        /* Check if date is 'null' */
        if (strDate.trim().equals(""))
        {
            return validateJavaDate(GenericMethods.ask_questions("Enter a Valid Date!!!"));

        }
        else
        {

            //Set preferred date format,
            SimpleDateFormat simpleDateFmt = new SimpleDateFormat("MM/dd/yyyy");
            simpleDateFmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try
            {
                return simpleDateFmt.parse(strDate);
            }
            /* Date format is invalid */
            catch (ParseException e)
            {
                return validateJavaDate(GenericMethods.ask_questions("Enter a Valid Date!!!"));
            }
            /* Return true if date format is valid */
        }
    }
}
