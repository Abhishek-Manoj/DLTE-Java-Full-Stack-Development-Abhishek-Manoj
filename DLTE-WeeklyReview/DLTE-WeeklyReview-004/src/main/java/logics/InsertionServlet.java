package logics;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertionServlet", value = "/insert")
public class InsertionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regNo = request.getParameter("regno");
        String name = request.getParameter("studentName");
        String age = request.getParameter("age");
        String contact = request.getParameter("mobNumber");
        String email = request.getParameter("email");
        String currentDoor = request.getParameter("cDoorNo");
        String currentStreet = request.getParameter("cStreet");
        String currentCity = request.getParameter("cCity");
        String currentState = request.getParameter("cState");
        String currentPin = request.getParameter("cPin");
        String permanentDoor = request.getParameter("pDoorNo");
        String permanentStreet = request.getParameter("pStreet");
        String permanentCity = request.getParameter("pCity");
        String permanentState = request.getParameter("pState");
        String permanentPin = request.getParameter("pPin");
        int reg_no = Integer.parseInt(regNo);
        int age_student = Integer.parseInt(age);
        long contact_no = Long.parseLong(contact);
        int current_pin_code = Integer.parseInt(currentPin);
        int permanent_pin_code = Integer.parseInt(permanentPin);
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//        logger.log(Level.INFO,reg_no+", "+name+", "+age_student+", "+contact_no+", "+currentDoor+", "+currentCity+", "+currentStreet+", "+currentState+", "+current_pin_code+", "+permanentDoor+", "+permanentStreet+", "+permanentCity+", "+permanentState+", "+permanent_pin_code);
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK MANOJ","J@nuary200!");
            logger.log(Level.INFO,"Connection Established!");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_e values(?,?,?,?,?)");
            preparedStatement.setInt(1,reg_no);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age_student);
            preparedStatement.setLong(4,contact_no);
            preparedStatement.setString(5,email);
            int studInsert = preparedStatement.executeUpdate();
            if(studInsert>0){
                logger.log(Level.INFO,"Insertion into Student Table Successful");
            }
            preparedStatement = connection.prepareStatement("Insert into address_e values(add_seq.NEXTVAL,?,?,?,?,?,?)");
            preparedStatement.setString(1,currentDoor);
            preparedStatement.setString(2,currentStreet);
            preparedStatement.setString(3,currentCity);
            preparedStatement.setString(4,currentState);
            preparedStatement.setInt(5,current_pin_code);
            preparedStatement.setString(6, "Current");
            int addCurr = preparedStatement.executeUpdate();
            if (addCurr>0){
                logger.log(Level.INFO,"Current Address insertion successful");
            }
            preparedStatement = connection.prepareStatement("insert into map_address values(?,add_seq.CURRVAL)");
            preparedStatement.setInt(1,reg_no);
            int mapCurr = preparedStatement.executeUpdate();
            if (mapCurr>0)
                logger.log(Level.INFO,"Address Mapper-Current Insertion Complete");
            preparedStatement = connection.prepareStatement("Insert into address_e values(add_seq.NEXTVAL,?,?,?,?,?,?)");
            preparedStatement.setString(1,permanentDoor);
            preparedStatement.setString(2,permanentStreet);
            preparedStatement.setString(3,permanentCity);
            preparedStatement.setString(4,permanentState);
            preparedStatement.setInt(5,permanent_pin_code);
            preparedStatement.setString(6, "Permanent");
            int addPerm = preparedStatement.executeUpdate();
            if (addPerm>0){
                logger.log(Level.INFO,"Permanent Address Insertion Successful");
            }
            preparedStatement = connection.prepareStatement("insert into map_address values(?,add_seq.CURRVAL)");
            preparedStatement.setInt(1,reg_no);
            int mapPerm = preparedStatement.executeUpdate();
            if (mapPerm>0)
                logger.log(Level.INFO,"Address Mapper-Permanent Insertion Complete");
            RequestDispatcher dispatcher=request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
