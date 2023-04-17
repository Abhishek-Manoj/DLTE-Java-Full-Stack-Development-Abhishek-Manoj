package bank.project.dao;

import java.util.List;
import java.util.Optional;

public interface BankOperations {
    List<Customer> listAll();
    public Customer getByUsername(String uname);
    public String getStatus(Optional<Customer> customer);
    public void updateAttempts(String username);
    public void updateStatus(String username);
    public void loginSuccess(String username);
//    String authenticate(String username,String password);
    public String addLoan(float amount, int tenure, long loanSchemeId, long customerId) ;
    List<LoanScheme> listLoanSchemes();
    long getIdByScheme(String type);
    long getIdByUsername(String customer);
    float getRateOfInterest(long id);
}
