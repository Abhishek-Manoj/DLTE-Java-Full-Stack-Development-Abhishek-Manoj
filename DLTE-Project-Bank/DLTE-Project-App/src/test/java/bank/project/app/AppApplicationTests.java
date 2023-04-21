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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

    //Test for Retrieving Customer details with username
    @Test
    public void testGetUsername() {
        Customer customer = new Customer(100L,9876543223L,"Kiran","XYZ Road,ABC Street,122","Active","kiran","kiranpass",0);
        String uname = "kiran";

        when(jdbcTemplate.queryForObject(eq("select * from customer where username=?"),any(RowMapper.class),eq(uname)))
                .thenReturn(customer);

        Customer customer1 = bankService.getByUsername("kiran");
        assertEquals(customer.getUsername(),customer1.getUsername());
    }

    //Test for Listing All Loan Schemes feature
    @Test
    public void testListLoanSchemes() {
        LoanScheme loanScheme1 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        LoanScheme loanScheme2 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        LoanScheme loanScheme3 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        List<LoanScheme> tempList = Stream.of(loanScheme1, loanScheme2, loanScheme3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"), any(RowMapper.class))).thenReturn(tempList);
        assertEquals(loanScheme3, bankService.listLoanSchemes().get(2));
    }

    //Test for Adding New Loan feature
    @Test
    public void testAddLoan(){
        Loan loan1 = new Loan(12345L,123456L,154362L,20000.0F,9.0F,8);
        LoanScheme loanScheme1 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        Customer customer1 = new Customer(154362L,234567L,"Abhi","XYZ Road,ABC Street,122","Active","abhi","abhipass",2);
//        when(bankService.getIdByUsername(customer1.getUsername())).thenReturn(customer1.getCustomerID());
//        when(bankService.getRateOfInterest(loanScheme1.getLoanSchemeId())).thenReturn((loanScheme1.getLoanSchemeRoi()));
        when(jdbcTemplate.queryForObject(eq("select customer_id from customer where username=?"),eq(Long.class),eq(customer1.getUsername()))).thenReturn(customer1.getCustomerID());
        when(jdbcTemplate.queryForObject(eq("select loan_scheme_roi from loan_scheme where loan_scheme_id=?"),eq(Float.class),eq(loanScheme1.getLoanSchemeId()))).thenReturn(loanScheme1.getLoanSchemeRoi());
        when(jdbcTemplate.update(eq("insert into loan values(loan_app_id_seq.NEXTVAL,?,?,?,?,?)"), eq(loan1.getLoanAmount()),eq(loan1.getLoanEmi()),eq(loanScheme1.getLoanSchemeId()),eq(customer1.getCustomerID()),eq(loan1.getLoanTenure())))
                .thenReturn(1);
        String response=bankService.addLoan(loan1.getLoanAmount(),loan1.getLoanTenure(),loanScheme1.getLoanSchemeId(),customer1.getUsername());
        assertEquals("loanApplied",response);
    }

    //Test for Listing All Loan Schemes feature Negation
    @Test
    public void testListLoanSchemesNegation() {
        LoanScheme loanScheme1 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        LoanScheme loanScheme2 = new LoanScheme(23456L,"Car","TYU","This is a description for a Car loan",6.0f);
        LoanScheme loanScheme3 = new LoanScheme(8544567L,"Education","IUY","This is a description for a Education loan",3.0f);
        List<LoanScheme> tempList = Stream.of(loanScheme1, loanScheme2, loanScheme3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"), any(RowMapper.class))).thenReturn(tempList);
        assertNotEquals(loanScheme1, bankService.listLoanSchemes().get(1));
    }

    //Test for Adding New Loan feature
    @Test
    public void testAddLoanNegation(){
        Loan loan1 = new Loan(12345L,123456L,154362L,20000.0F,9.0F,8);
        LoanScheme loanScheme1 = new LoanScheme(123456L,"Housing","ABC","This is a description for a housing loan",8.0f);
        Customer customer1 = new Customer(154362L,234567L,"Abhi","XYZ Road,ABC Street,122","Active","abhi","abhipass",2);
//        when(bankService.getIdByUsername(customer1.getUsername())).thenReturn(customer1.getCustomerID());
//        when(bankService.getRateOfInterest(loanScheme1.getLoanSchemeId())).thenReturn((loanScheme1.getLoanSchemeRoi()));
        when(jdbcTemplate.queryForObject(eq("select customer_id from customer where username=?"),eq(Long.class),eq(customer1.getUsername()))).thenReturn(customer1.getCustomerID());
        when(jdbcTemplate.queryForObject(eq("select loan_scheme_roi from loan_scheme where loan_scheme_id=?"),eq(Float.class),eq(loanScheme1.getLoanSchemeId()))).thenReturn(loanScheme1.getLoanSchemeRoi());
        when(jdbcTemplate.update(eq("insert into loan values(loan_app_id_seq.NEXTVAL,?,?,?,?,?)"), eq(loan1.getLoanAmount()),eq(loan1.getLoanEmi()),eq(loanScheme1.getLoanSchemeId()),eq(customer1.getCustomerID()),eq(loan1.getLoanTenure())))
                .thenReturn(1);
        String response=bankService.addLoan(loan1.getLoanAmount(),loan1.getLoanTenure(),loanScheme1.getLoanSchemeId(),customer1.getUsername());
        assertNotEquals("loanNotApplied",response);
    }
}
