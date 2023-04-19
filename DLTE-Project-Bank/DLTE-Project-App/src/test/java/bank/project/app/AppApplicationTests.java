package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import bank.project.dao.Loan;
import bank.project.dao.LoanScheme;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    BankService bankService;

    @Test
    public void testListAll() {
        Customer customer1 = new Customer(154362L,234567L,"Abhi","XYZ Road,ABC Street,122","Active","abhi","abhipass",2);
        Customer customer2 = new Customer(654578L,12345678L,"Anu","GHI Road,KHF Street,988","Active","anu","anupass",0);
        Customer customer3 = new Customer(987654L,9876543L,"Aashu","WER Street,ASD Road,654","Active","aashu","aashupass",0);
        List<Customer> tempList = Stream.of(customer1,customer2,customer3).collect(Collectors.toList());

        when(jdbcTemplate.query(eq("select * from customer"),any(RowMapper.class))).thenReturn(tempList);

        assertEquals(customer1,bankService.listAll().get(0));
    }

    @Test
    public void testGetUsername() {
        Customer customer = new Customer(100L,9876543223L,"Kiran","XYZ Road,ABC Street,122","Active","kiran","kiranpass",0);
        String uname = "kiran";

        when(jdbcTemplate.queryForObject(eq("select * from customer where username=?"),any(RowMapper.class),eq(uname)))
                .thenReturn(customer);

        Customer customer1 = bankService.getByUsername("kiran");
        assertEquals(customer.getUsername(),customer1.getUsername());
    }

    @Test
    public void testListLoanSchemes() {
        LoanScheme loanScheme1 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        LoanScheme loanScheme2 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        LoanScheme loanScheme3 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        List<LoanScheme> tempList = Stream.of(loanScheme1, loanScheme2, loanScheme3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"), any(RowMapper.class))).thenReturn(tempList);
        assertEquals(loanScheme3, bankService.listLoanSchemes().get(2));
    }

//    @Test
//    public void testAddLoan(){
//        Loan loan1 = new Loan(12345L,76376L,234567L,20000.0F,9.0F,8);
//        when(jdbcTemplate.update(eq("insert into loan_scheme values(?,?,?,?,?)"), eq(new Object[]{loan1.getLoanAppId(),loan1.getLoanAmount(),loan1.getLoanEmi(),loan1.getLoanSchemeId(),loan1.getCustomerId(),loan1.getLoanTenure()})))
//                .thenReturn(1);
//        String customer = "Abhi";
//        String response=bankService.addLoan(loan1.getLoanAmount(),loan1.getLoanTenure(),loan1.getLoanSchemeId(),customer);
//        assertEquals("loanApplied",response);
//    }
}
