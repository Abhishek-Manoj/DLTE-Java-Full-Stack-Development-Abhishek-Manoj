package studetnt.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        StudentDetails studentDetails = new StudentDetails();
        do{
            System.out.println("Welcome User!");
            System.out.println("Please select the operation you want to perform:");
            System.out.println("1.Insert Record\n2.Display All Records\n3.Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:

                    break;
                case 2:
                    studentDetails.makeConnection();
                    studentDetails.display();
                    break;
                case 3:
                    exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }while (true);
    }
}
