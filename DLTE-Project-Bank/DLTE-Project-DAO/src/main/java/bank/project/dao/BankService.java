package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


@Service
public class BankService implements BankOperations{
    ResourceBundle bundle = ResourceBundle.getBundle("bank");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger= LoggerFactory.getLogger(BankService.class);
    @Override
    public List<Customer> listAll() {
        return jdbcTemplate.query("select * from customer", new CustomerMapper());
    }

    @Override
    public Customer getByUsername(String uname) {
        try{
            Customer customer = jdbcTemplate.queryForObject("select * from customer where username=?",new CustomerMapper(),uname);
            logger.info(customer.toString()+" has been returned to controller");
            return customer;
        }
        catch (DataAccessException e){
            logger.error("Exception occured in getByUsername method");
            return null;
        }
    }

    @Override
    public String getStatus(Optional<Customer> customer) {
        return null;
//        return jdbcTemplate.queryForObject("select status from customer where username = ?",new Object[]{username},new BeanPropertyRowMapper<>(Customer.class)));
    }

    @Override
    public void updateAttempts(String username) {
        jdbcTemplate.update("update customer set failed_attempts = failed_attempts+1 where username=?",username);
    }

    @Override
    public void updateStatus(String username) {
        jdbcTemplate.update("update customer set customer_status = 'inactive' where username = ?",username);
    }

    @Override
    public void loginSuccess(String username) {
        jdbcTemplate.update("update customer set failed_attempts = 0 where username = ?",username);
    }

    @Override
    public String addLoan(float amount, int tenure, long loanSchemeId, long customerId) {
        float roi = getRateOfInterest(loanSchemeId);
        float monthlyInterest = roi / 1200;
        double loanEmi = (amount * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -tenure));
        jdbcTemplate.update("insert into loan values(loan_app_id_seq.NEXTVAL,?,?,?,?,?)",amount,loanEmi,loanSchemeId,customerId,tenure);
        return "loanApplied";
    }

    @Override
    public List<LoanScheme> listLoanSchemes() {
        return jdbcTemplate.query("select * from loan_scheme",new LoanSchemeMapper());
    }

    @Override
    public long getIdByScheme(String type) {
        return jdbcTemplate.queryForObject("select loan_scheme_id from loan_scheme where loan_scheme_type=?",Long.class,type);
    }

    @Override
    public long getIdByUsername(String customer) {
        return jdbcTemplate.queryForObject("select customer_id from customer where username=?",Long.class,customer);
    }

    @Override
    public float getRateOfInterest(long id) {
        return jdbcTemplate.queryForObject("select loan_scheme_roi from loan_scheme where loan_scheme_id=?",Float.class,id);
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = getByUsername(username);
//        if (customer == null){
//            throw new UsernameNotFoundException(bundle.getString("userNotExist"));
//        }
//        return customer;
//    }

    class LoanMapper implements RowMapper<Loan>{

        @Override
        public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loan loan = new Loan();
            loan.setLoanAppId(rs.getLong("loan_app_id"));
            loan.setLoanAmount(rs.getFloat("loan_amount"));
            loan.setLoanEmi(rs.getFloat("loan_emi"));
            loan.setLoanSchemeId(rs.getLong("loan_scheme_id"));
            loan.setCustomerId(rs.getLong("customer_id"));
            loan.setLoanTenure(rs.getInt("loan_tenure"));
            return loan;
        }
    }

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
