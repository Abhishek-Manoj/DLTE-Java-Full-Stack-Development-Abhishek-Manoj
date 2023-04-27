package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class BankService implements BankOperations, UserDetailsService {
    ResourceBundle bundle = ResourceBundle.getBundle("bank");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger= LoggerFactory.getLogger(BankService.class);

//    Retrieves the Customer details when username is provided
    @Override
    public Customer getByUsername(String uname) {
        try{
            logger.info("Entered getByUsername() method");
            logger.info("Username :"+uname);
            Customer customer = jdbcTemplate.queryForObject("select * from customer where username=?",new CustomerMapper(),uname);
            logger.info(customer.toString()+" has been returned to controller");
            return customer;
        }
        catch (Exception e){
            logger.error("Exception occured in getByUsername method: "+e);
            return null;
        }
    }

//    Updates the attempts value by 1 for each incorrect password entry
    @Override
    public void updateAttempts(String username) {
        jdbcTemplate.update("update customer set failed_attempts = failed_attempts+1 where username=?",username);
        logger.info("failed attempts incremented for "+username);
    }

//    Updates the status of the customer when the customer enters incorrect password thrice
    @Override
    public void updateStatus(String username) {
        jdbcTemplate.update("update customer set customer_status = 'inactive' where username = ?",username);
        logger.info("Status of customer changed to inactive for "+username);
    }

//    Resets the failed attempts value to 0 when the login is successful
    @Override
    public void loginSuccess(String username) {
        jdbcTemplate.update("update customer set failed_attempts = 0 where username = ?",username);
        logger.info("failed attempts value is reset for "+username);
    }

//    Adds the loan details to the loan table
    @Override
    public String addLoan(float amount, int tenure, long loanSchemeId, String customer) {
        Long customerId = getIdByUsername(customer);
        float roi = getRateOfInterest(loanSchemeId);
        float monthlyInterest = roi / 1200;
        double loanEmi = (amount * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -tenure));
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("")
        jdbcTemplate.update("insert into loan values(loan_app_id_seq.NEXTVAL,?,?,?,?,?)",amount,loanEmi,loanSchemeId,customerId,tenure);
        logger.info(bundle.getString("loanApplied"));
        return "loanApplied";
    }

//    Lists the available loan schemes
    @Override
    public List<LoanScheme> listLoanSchemes() {
        logger.info("list of loan schemes retrieval");
        return jdbcTemplate.query("select * from loan_scheme",new LoanSchemeMapper());
    }

//    Retrieves the ID of the customer based on username
    @Override
    public long getIdByUsername(String customer) {
        Long customerID = jdbcTemplate.queryForObject("select customer_id from customer where username=?",Long.class,customer);
        logger.info(customerID.toString());
        return customerID;
    }

//    Retrieves the Rate of Interest of the Loan based on Loan Scheme ID
    @Override
    public float getRateOfInterest(long id) {
        float interest = jdbcTemplate.queryForObject("select loan_scheme_roi from loan_scheme where loan_scheme_id=?",Float.class,id);
        logger.info(interest+"");
        return interest;
    }


//    Performs the Login Authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Entered loadByUsername() method for"+username);
        Customer customer = getByUsername(username);

        if (customer == null){
            logger.info(bundle.getString("userNotExist"));
            throw new UsernameNotFoundException(bundle.getString("userNotExist"));
        }
        if (customer.getCustomerStatus().equalsIgnoreCase("inactive")){
            logger.info(bundle.getString("accDeactivated"));
            throw new UsernameNotFoundException(bundle.getString("accDeactivated"));
        }
        return customer;
    }

//    Mapper class for Customer POJO
    class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerID(rs.getLong("customer_id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerAddress(rs.getString("customer_address"));
            customer.setCustomerStatus(rs.getString("customer_status"));
            customer.setCustomerContact(rs.getLong("customer_contact"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setFailedAttempts(rs.getInt("failed_attempts"));
            return customer;
        }
    }

//    Mapper class for Loan Scheme POJO
    class LoanSchemeMapper implements RowMapper<LoanScheme> {

        @Override
        public LoanScheme mapRow(ResultSet rs, int rowNum) throws SQLException {
            LoanScheme loanScheme = new LoanScheme();
            loanScheme.setLoanSchemeId(rs.getLong("loan_scheme_id"));
            loanScheme.setLoanSchemeType(rs.getString("loan_scheme_type"));
            loanScheme.setLoanSchemeName(rs.getString("loan_scheme_name"));
            loanScheme.setLoanSchemeDesc(rs.getString("loan_scheme_desc"));
            loanScheme.setLoanSchemeRoi(rs.getFloat("loan_scheme_roi"));
            return loanScheme;
        }
    }
}