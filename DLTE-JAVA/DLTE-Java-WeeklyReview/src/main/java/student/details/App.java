package student.details;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App 
{
    private static File file = new File("student.doc");
    private static FileInputStream fileInputStream = null;
    private static FileOutputStream fileOutputStream = null;
    private static ObjectInputStream objectInputStream = null;
    private static ObjectOutputStream objectOutputStream = null;

    public static Map<Long,Student> readrecords() throws IOException, ClassNotFoundException, NullPointerException{
        try{
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            Map<Long,Student> buffer = (Map<Long, Student>)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return buffer;
        }
        catch (IOException | ClassNotFoundException e){}
        return null;
    }

    public static void writerecords(Map<Long,Student> studentMap){
        try{
            fileOutputStream= new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(studentMap);

            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch(IOException io){}
    }


    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        StudentDetails studentDetails = new StudentDetails();
        do{
            System.out.println("Welcome User!");
            System.out.println("Please select the operation you want to perform:");
            System.out.println("1.Insert Record\n2.Display All Records\n3.Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(file.exists())
                        studentDetails.setStudentDb(readrecords());
                    studentDetails.addDetails();
                    writerecords(studentDetails.getStudentDb());
                    break;
                case 2:
                    studentDetails.setStudentDb(readrecords());
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
