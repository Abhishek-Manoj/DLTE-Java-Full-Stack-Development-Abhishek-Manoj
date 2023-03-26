package logics;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet",value = "/authenticate")
public class AuthorizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String recieveID = request.getParameter("studentId");
        String recievePass = request.getParameter("studentPass");
        logger.log(Level.INFO,""+recieveID+" "+recievePass);
        int studentId = Integer.parseInt(recieveID);
        try{
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ABHISHEK MANOJ","J@nuary200!");
            String query = "Select * from authorize_student where regno=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,studentId);
            preparedStatement.setString(2,recievePass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
                logger.log(Level.INFO,"Authenticated");
                HttpSession session = request.getSession();
                session.setAttribute("admin",studentId);
                requestDispatcher.forward(request,response);
            }
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("authorize.jsp");
                logger.log(Level.INFO,"Incorrect Credentials. Try Again");
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
