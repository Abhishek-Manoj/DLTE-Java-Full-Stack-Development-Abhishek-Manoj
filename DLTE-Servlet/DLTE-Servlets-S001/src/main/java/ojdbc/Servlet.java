package ojdbc;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value="/iterate")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","J@nuary200!");
            String query="select * from card";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            //connection.close();
            Card card=null;
            List<Card> profiles=new ArrayList<Card>();
            while(resultSet.next()){
                card=new Card();
                card.setC
//                card.set(resultSet.getString("passcode"));
//                kyc.setAcc_number(resultSet.getInt("acc_number"));
//                kyc.setPasscode(resultSet.getString("passcode"));
//                kyc.setAcc_holder(resultSet.getString("acc_holder"));
//                kyc.setAadhaar(resultSet.getLong("aadhaar"));
//                kyc.setPan(resultSet.getString("pan"));
//                kyc.setEmail(resultSet.getString("email"));
//                kyc.setContact(resultSet.getLong("contact"));
//                kyc.setAcc_bal(resultSet.getDouble("acc_bal"));
//                InputStream inputStream=resultSet.getBinaryStream("address");
//                byte[] tempBinary=new byte[inputStream.available()];
//                inputStream.read(tempBinary);
//                String address=new String(tempBinary);
//                kyc.setAddress(address);
//                profiles.add(kyc);
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("available.jsp");
            request.setAttribute("dbData",profiles);
            dispatcher.forward(request,response);
        } catch (SQLException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
