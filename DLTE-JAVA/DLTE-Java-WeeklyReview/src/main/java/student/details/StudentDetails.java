package student.details;

import lombok.Data;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class StudentDetails implements StudentOperations {
    private Scanner sc = new Scanner(System.in);
    private Map<Long,Student> studentDb = new TreeMap<>();



    @Override
    public String addDetails() {
//        studentDb.put(1234,new Student(1234,"abhi","ahak",12,))
        do{
            System.out.println("Enter the Registration Number: ");
            Long regno= sc.nextLong();
//            System.out.println(studentDb.containsKey(regno));

            if (studentDb.containsKey(regno)){
                System.out.println("Entered registration number already exists. Please enter another number:");
                regno= sc.nextLong();
            }

            System.out.println("Enter the name of the student:");
            String name = sc.next();

            System.out.println("Enter the age of the student:");
            int age = sc.nextInt();

            System.out.println("Enter the email id:");
            String email = sc.next();

            System.out.println("Enter the address (Street,City,State,Zip Code):");
            Map<String,String> address = new TreeMap<>();
            String street = sc.next();
            String city = sc.next();
            String state = sc.next();
            String zip = sc.next();
            address.put("Street",street);
            address.put("City",city);
            address.put("State",state);
            address.put("Zip",zip);
            Student student = new Student(regno,name,email,age,address);

            studentDb.put(regno,student);
            System.out.println("Do you want to add another record (1 -> Yes, 2-> No):");
            int ans = sc.nextInt();
            if (ans == 2){
                return "A new record has been created";
            }
        }while(true);
    }

    @Override
    public void display() {
        System.out.println(studentDb);
//        System.out.println("The Records are as follows");
//        while (!studentDb.isEmpty()){
//            System.out.println(studentDb<);
//        }
    }
}
