package studetnt.jdbc;

import lombok.Data;
import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.*;

@Data
public class StudentDetails implements StudentOperations{
    private Scanner sc = new Scanner(System.in);

//    Connection connection;
//    PreparedStatement preparedStatement;
//    class connectionDB {
//        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","J@nuary200!");
//        preparedStatement = connection.prepareStatement("alter session set current_schema=ABHISHEK MANOJ");
//        preparedStatement.executeQuery();
//        System.out.println("Connected");
//    }



    @Override
    public String addDetails() {
//        do{
//            System.out.println("Enter the Registration Number: ");
//            Long regno= sc.nextLong();
////            System.out.println(studentDb.containsKey(regno));
//
//            if (studentDb.containsKey(regno)){
//                System.out.println("Entered registration number already exists. Please enter another number:");
//                regno= sc.nextLong();
//            }
//
//            System.out.println("Enter the name of the student:");
//            String name = sc.next();
//
//            System.out.println("Enter the age of the student:");
//            int age = sc.nextInt();
//
//            System.out.println("Enter the email id:");
//            String email = sc.next();
//
//            System.out.println("Enter the address (Street,City,State,Zip Code):");
//            Map<String,String> address = new TreeMap<>();
//            String street = sc.next();
//            String city = sc.next();
//            String state = sc.next();
//            String zip = sc.next();
//            address.put("Street",street);
//            address.put("City",city);
//            address.put("State",state);
//            address.put("Zip",zip);
//            Student student = new Student(regno,name,email,age,address);
//
//            studentDb.put(regno,student);
//            System.out.println("Do you want to add another record (1 -> Yes, 2-> No):");
//            int ans = sc.nextInt();
//            if (ans == 2){
//                return "A new record has been created";
//            }
//        }while(true);
        return null;
    }

    @Override
    public void display() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","J@nuary200!");
//            System.out.println("Connection Established");
            String query="select regno,name,age,contact,email from student";
//            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=GOURAV");
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            Student student = null;
            List<Student> profiles = new ArrayList<>();
            while (resultSet.next()){
                student = new Student();
                student.setRegNo(resultSet.getLong("regno"));
                student.setAge(resultSet.getInt("age"));
                student.setContact(resultSet.getLong("contact"));
                student.setEmail(resultSet.getString("email"));
                profiles.add(student);
            }
            for (int i=0;i<profiles.size();i++){
                System.out.println(profiles.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeConnection() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        connection = DriverManager.getConnection(oracleUrl,"SYSTEM","J@nuary200!");
        preparedStatement = connection.prepareStatement("alter session set current_schema=ABHISHEK MANOJ");
        preparedStatement.executeQuery();
        System.out.println("Connected");
    }
}
