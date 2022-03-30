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

    static long input_phone(String message) //converting string to method
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message); //asks the questions passed when the method called
        return scanner.nextLong();
    }
}
