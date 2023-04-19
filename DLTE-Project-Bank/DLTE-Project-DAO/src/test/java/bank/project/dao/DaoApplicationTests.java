package bank.project.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {

//    @Mock
//    JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    BankService bankService;
//
//    @Test
//    public void testListAll() {
//        Customer customer1 = new Customer(154362L,234567L,"Abhi","XYZ Road,ABC Street,122","Active","abhi","abhipass",2);
//        Customer customer2 = new Customer(654578L,12345678L,"Anu","GHI Road,KHF Street,988","Active","anu","anupass",0);
//        Customer customer3 = new Customer(987654L,9876543L,"Aashu","WER Street,ASD Road,654","Active","aashu","aashupass",0);
//        List<Customer> tempList = Stream.of(customer1,customer2,customer3).collect(Collectors.toList());
//
//        when(jdbcTemplate.query(eq("select * from customer"),any(RowMapper.class))).thenReturn(tempList);
//
//        assertEquals(customer1,bankService.listAll().get(0));
//    }
//
//    @Test
//    public void testGetUsername() {
//        Customer customer = new Customer(100L,9876543223L,"Kiran","XYZ Road,ABC Street,122","Active","kiran","kiranpass",0);
//        String uname = "kiran";
//
//        when(jdbcTemplate.queryForObject(eq("select * from customer where username=?"),any(RowMapper.class),eq(uname)))
//                .thenReturn(customer);
//
//        Customer customer1 = bankService.getByUsername("kiran");
//        assertEquals(customer.getUsername(),customer1.getUsername());
//    }
//
//    @Test
//    public void testListLoanSchemes() {
//
//    }
}
