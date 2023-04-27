package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Loan;
import bank.project.dao.LoanScheme;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppApplicationTests {

    @Mock
    BankService bankService;

    @InjectMocks
    BankController bankController;

    //Test case for applying new loan
    @Test
    public void testApplyLoan(){
        Mockito.when(bankService.addLoan(454545F,1,12344L,"abhi")).thenReturn("loanApplied");
        String applyLoanResponse = bankController.applyLoan(454545F,1,12344L,"abhi");
        assertEquals(applyLoanResponse,"Your loan application has been forwarded");
    }
}
