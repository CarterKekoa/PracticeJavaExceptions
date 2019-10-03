import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //exception: an exception is an event that occurs during run time
        //that disrupts the normal program instruction flow

        //two types of exceptions in java
        //unchecked: errors and runtime exceptions
        //checked: exceptions that you have to anticipate, handle, and recover from

        //runtime exception example
        try {
            int x = 5 / 0;
        }
        catch (ArithmeticException e){
            //code to handle this case...
            e.printStackTrace(); //System.err
        }
        finally{
            //this gets executed no matter what happened in the try
            System.out.println("Hello from finally");
        }

        //checked exception example
        Scanner inFile = null;

        //purposely try to open a file that DNE
        try {
            inFile = new Scanner(new File("dne.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //have to handle or acknowledge a checked exception
        System.out.println("Program execution continuess...");

        //LIST INTERFACE
        //from the Collections framework
        //two implementations: ArrayList and LinkedList
        List<String> myAutumnWords;

        myAutumnWords = new ArrayList<String>(); //like vector in c++
        myAutumnWords.add("pumpkin");
        myAutumnWords.add("spooky");
        myAutumnWords.add("flannel");
        myAutumnWords.add("leaves");

        System.out.println(myAutumnWords);
        System.out.println(myAutumnWords.size());

        myAutumnWords.remove(0);
        System.out.println(myAutumnWords);

        Collections.sort(myAutumnWords);
        System.out.println(myAutumnWords);
        Collections.shuffle(myAutumnWords);
        System.out.println(myAutumnWords);
        Collections.reverse(myAutumnWords);
        System.out.println(myAutumnWords);

        //task: make a new arrayList of the first 10 square numbers
        //print the list
        //sort the list
        //int->Integer
        //double->Double
        //char->Character
        //switch between the primitive types automatically.. autoboxing
        List<Integer> squareNumbers;
        squareNumbers = new ArrayList<Integer>();
        for(int i = 0; i <= 10; i++){
            squareNumbers.add(i*i);
        }
        System.out.println(squareNumbers);
        Collections.shuffle(squareNumbers);
        System.out.println(squareNumbers);

        Scanner kb = new Scanner(System.in);
        int userNum = 0;

        boolean valid = true;
        do {
            valid = true;
            try {
                System.out.println("Enter an integer (or else!): ");
                userNum = kb.nextInt();             //throws an unchecked input mis-match exception
            } catch (InputMismatchException f) {    //get error from test run
                f.printStackTrace();
                valid = false;
                System.out.println("Not an int");
            } finally {
                //success or failure, flush the buffer
                kb.nextLine();
            }
        } while (!valid);                           //will be infinite loop but new line character sits in the buffer
        System.out.println("Thanks for entering the int " + userNum);
    }
}
