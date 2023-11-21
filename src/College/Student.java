package College;
import java.util.Scanner;
public class Student {
    // Java Program to Illustrate Student Class
// to take Input from the student and related Information

// Importing required classes
//import java.util.Scanner;


    // Class member variables
    public String studentName;
    public String regNum;
    private int SNo;


       public static  book[] borrowedBooks = new book[3];
        public static int booksCount = 0;





    // Creating object of Scanner class to
        // take input from user
        Scanner input = new Scanner(System.in);
    private Object SerialNo;

    // Constructor
        private void  student(int regNum, String studentName, String book, int booksCount)
        {
            // Print statement
            System.out.println("Enter Students[i].StudentName:");
            System.out.println("regNum");

            // This keywords refers to current instance
            this.studentName = input.nextLine();


            // Print statement
            System.out.println("Enter Registration Number:");
            this.regNum = input.nextLine();
            //System.out.println(booksCount);

        }

    public int getSerialNo() {
        return (int) SerialNo;
    }

    public void setSNo(int SerialNo) {
        final var serialNo = this.SerialNo;


    }  }