package College;
 // Java Program to Illustrate students Class
// To Do all the Operations related to students:
// add Students,check-in books,check out books,ValidStudent

// Importing required classes
import java.util.Scanner;
 import java.lang.String;

// Class
class students {

    // Creating objects of Scanner and students class
    Scanner input = new Scanner(System.in);
    public students[] theStudents = new students[50];

    public static int count = 0;
    private String regNum;
    private String studentName;

    private int sNo;
    private int authorName;
    private int bookName;
    private int studentIndex;


    int booksCount;
    private String[] borrowedBooks;

    // Method 1
    // To add books
    public void addStudent(students s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {

                // Print statement
                System.out.println(
                        "Student of Reg Num " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }

    // Method 2
    // Displaying all students
    public void showAllStudents()
    {
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName
                    + "\t\t"
                    + theStudents[i].regNum);
        }
    }

    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }

        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    // Method 4
    // To remove the book
    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();

        //studentIndex
       // int studentIndex = studentIndex;
       // if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

               //final var studentIndex = studentIndex;
               if ( 3<=theStudents[ studentIndex ].booksCount)
                         {

                             System.out.println("adding book");
                             theStudents[studentIndex].borrowedBooks
                                     [theStudents[studentIndex]
                                     .booksCount]
                                     = b.toString();
                             theStudents[studentIndex].booksCount++;

                             return;
                         }
               else {

                   System.out.println(
                           "Student Can not Borrow more than 3 Books.");
                   return;
               }
            }
        System.out.println("Book is not Available.");
    }



    // Method 5
    // To add the book
    public void  checkInBook(books book)
    {

        int studentIndex = this.isStudent();
        if (studentIndex != -1) {

            // Printing credentials corresponding to student
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            students s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(s.borrowedBooks[i].serialN0 + "\t\t\t"
                                + s.borrowedBooks[i],
                        bookName + "\t\t\t"
                                + s.borrowedBooks[i],
                        authorName);
            }


            // Display message only
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                int serialNo = 0;
                final var b = serialNo == sNo;
                if (sNo == s.borrowedBooks[ i ].serialNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo
                    + "not Found");
        }
    }
}