package bank.project.dao;

import java.util.List;

public interface BankOperations {
    Customer getByUsername(String uname);
    void updateAttempts(String username);
    void updateStatus(String username);
    void loginSuccess(String username);
    String addLoan(float amount, int tenure, long loanSchemeId, String customer) ;
    List<LoanScheme> listLoanSchemes();
    long getIdByUsername(String customer);
    float getRateOfInterest(long id);
}
