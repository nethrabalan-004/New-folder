import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
class library
{
    HashMap<String,Integer> stuid=new HashMap<String,Integer>();
    HashMap<String,String> bdate=new HashMap<String,String>();
    HashMap<String,Integer> noOfDays=new HashMap<String,Integer>();
    HashMap<String,String> returndate=new HashMap<String,String>();
    void getDetails()
    {
        // sc.nextLine();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter bookId: ");
        String bookid=sc.nextLine();
        System.out.println("Enter student id");
        int id=sc.nextInt();
        stuid.put(bookid,id);
        System.out.println("Enter number of days");
        int days=sc.nextInt();
        noOfDays.put(bookid,days);
        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();
        bdate.put(bookid, dateString);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        LocalDate newDate = date.plusDays(days);
        String newDateString = newDate.format(formatter);
        returndate.put(bookid, newDateString);
        System.out.println("******Details added successfully******");
    }
     void returnBook()
         {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter bookId: ");
            String bookid=sc.nextLine();
            if(stuid.containsKey(bookid))
            {
            System.out.println("Book Id: "+bookid);
            System.out.println("Student Id: "+stuid.get(bookid));
            System.out.println("Borrowed Date: "+bdate.get(bookid));
            System.out.println("Return Date: "+returndate.get(bookid));
            System.out.println("No of days: "+noOfDays.get(bookid));
            System.out.println("**********");
            }
            else{
                System.out.println("*****Book not found*****");
            }

         }
    void editNoOfDays()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter BookId:");
        String bookid=sc.nextLine();
        if(stuid.containsKey(bookid))
        {
            System.out.println("No of days to extend");
            int no=sc.nextInt();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(returndate.get(bookid), formatter);
        LocalDate newDate = date.plusDays(no);
        String newDateString = newDate.format(formatter);
        returndate.put(bookid, newDateString);
        System.out.println("New return date: " + newDateString);
        System.out.println("**********");

    }
    else{
        System.out.println("*****Book not found*****");
    }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        library l=new library();
        System.out.println("Welcome to Library Management System");
        while(true)
        {
            System.out.println("1. Add Book Details");
            System.out.println("2. Check Book");
            System.out.println("3. Extend Days");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    l.getDetails();
                    break;
                case 2:
                    l.returnBook();
                    break;
                case 3:
                    l.editNoOfDays();
                    break;
                case 4:
                System.out.println("****work done****");
                System.exit(0);
                    break;
                default:
                    System.out.println("****Invalid choice****");
            }
        }
    }
}
