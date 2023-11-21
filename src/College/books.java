package College;

// To Do all the Operations related to Books such as
// add, check-in, check-out,Valid books,Update books

// Importing required classes
import java.util.Scanner;

import static java.lang.System.*;

// CLass
    public class books {

        // Class data members
       public  book[] theBooks = new book[50];
        public static int count;

        Scanner input = new Scanner(in);

        // Method 1
        //  To compare books
        public int compareBookObjects(book b1, book b2)
        {

            // If book name matches
            if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
                out.println(
                        "Book of this Name Already Exists.");
                return 0;
            }

            // if book serial matches
            if (b1.sNo == b2.sNo) {

                // Print book exists
                out.println(
                        "Book of this Serial No Already Exists.");

                return 0;
            }
            return 1;
        }

        // Method 2
        // To add book
        public void addBook(book b)
        {

            for (int i = 0; i < count; i++) {


                if (this.compareBookObjects(b, this.theBooks[i])
                        == 0)
                    return;
            }

            if (count < 50) {

                theBooks[count] = b;
                count++;
            }
            else {

                out.println(
                        "No Space to Add More Books.");
            }
        }

        // Method 3
        // To search book by serial number
        public void searchBySno()
        {

            // Display message
            out.println(
                    "\t\t\t\tSEARCH BY SERIAL NUMBER\n");

            // Class data members
            int sNo;
            out.println("Enter Serial No of Book:");
            sNo = input.nextInt();
            int flag = 0;
            out.println(
                    "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

            for (int i = 0; i < count; i++) {
                if (sNo == theBooks[i].sNo) {
                    out.println(
                            theBooks[i].sNo + "\t\t"
                                    + theBooks[i].bookName + "\t\t"
                                    + theBooks[i].authorName + "\t\t"
                                    + theBooks[i].bookQtyCopy + "\t\t"
                                    + theBooks[i].bookQty);
                    flag++;
                    return;
                }
            }

               System.out.println("No Book for Serial No "+ sNo + " Found.");
        }

        // Method 4
        // To search author by name
        public void searchByAuthorName()
        {

            // Display message
            out.println(
                    "\t\t\t\tSEARCH BY AUTHOR'S NAME");

            input.nextLine();

            out.println("Enter Author Name:");
            String authorName = input.nextLine();

            int flag = 0;

            out.println(
                    "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

            for (int i = 0; i < count; i++) {

                // if author matches any of its book
                if (authorName.equalsIgnoreCase(
                        theBooks[i].authorName)) {

                    // Print below corresponding credentials
                    out.println(
                            theBooks[i].sNo + "\t\t"
                                    + theBooks[i].bookName + "\t\t"
                                    + theBooks[i].authorName + "\t\t"
                                    + theBooks[i].bookQtyCopy + "\t\t"
                                    + theBooks[i].bookQty);
                    flag++;
                }
            }

            // Else no book matches for author
            if (flag == 0)
                out.println("No Books of " + authorName
                        + " Found.");
        }

        // Method 5
        // To display all books
        public void showAllBooks()
        {

            out.println("\t\t\t\tSHOWING ALL BOOKS\n");
            out.println(
                    "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

            for (int i = 0; i < count; i++) {

                out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].bookQtyCopy + "\t\t"
                                + theBooks[i].bookQty);
            }
        }

        // Method 6
        // To edit the book
        public void upgradeBookQty()
        {

            out.println(
                    "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
            out.println("Enter Serial No of Book");

            int sNo = input.nextInt();

            for (int i = 0; i < count; i++) {

                if (sNo == theBooks[i].sNo) {

                    // Display message
                    out.println(
                            "Enter No of Books to be Added:");

                    int addingQty = input.nextInt();
                    theBooks[i].bookQty += addingQty;
                    theBooks[i].bookQtyCopy += addingQty;

                    return;
                }
            }
        }

        // Method 7
        // To create menu
        public void dispMenu()
        {

            // Displaying menu
            out.println(
                    "----------------------------------------------------------------------------------------------------------");
            out.println("Press 1 to Add new Book.");
            out.println("Press 0 to Exit Application.");
            out.println(
                    "Press 2 to Upgrade Quantity of a Book.");
            out.println("Press 3 to Search a Book.");
            out.println("Press 4 to Show All Books.");
            out.println("Press 5 to Register Student.");
            out.println(
                    "Press 6 to Show All Registered Students.");
            out.println("Press 7 to Check Out Book. ");
            out.println("Press 8 to Check In Book");
            out.println(
                    "-------------------------------------------------------------------------------------------------------");
        }

        // Method 8
        // To search the library
        public int isAvailable(int sNo)
        {

            for (int i = 0; i < count; i++) {
                if (sNo == theBooks[i].sNo) {
                    if (theBooks[i].bookQtyCopy > 0) {

                        out.println(
                                "Book is Available.");
                        return i;
                    }
                    out.println("Book is Unavailable");
                    return -1;
                }
            }

            out.println("No Book of Serial Number "
                    + " Available in Library.");
            return -1;
        }

        // Method 9
        // To remove the book from the library
        public book checkOutBook()
        {

            out.println(
                    "Enter Serial No of Book to be Checked Out.");
            int sNo = input.nextInt();

            int bookIndex = isAvailable(sNo);

            if (bookIndex != -1) {
                theBooks[bookIndex].bookQtyCopy--;
                return theBooks[bookIndex];
            }
            return null;
        }

        // Method 10
        // To add the Book to the Library
        public void checkInBook(String b)
        {
            for (int i = 0; i < count; i++) {
                if (b.equals(theBooks[i])) {
                    theBooks[i].bookQtyCopy++;
                    return;
                }
            }
        }
    }



