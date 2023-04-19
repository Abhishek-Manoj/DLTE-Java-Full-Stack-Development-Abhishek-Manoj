package bank.project.dao;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface BankOperations {
    List<Customer> listAll();
    public Customer getByUsername(String uname);
    public void updateAttempts(String username);
    public void updateStatus(String username);
    public void loginSuccess(String username);
    public String addLoan(float amount, int tenure, long loanSchemeId, String customer) ;
    List<LoanScheme> listLoanSchemes();
//    long getIdByScheme(String type);
    long getIdByUsername(String customer);
    float getRateOfInterest(long id);
//    public UserDetails loadUserByUsername(String username);
}
