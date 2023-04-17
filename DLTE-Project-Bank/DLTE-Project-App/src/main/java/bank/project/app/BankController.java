package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/template")
public class BankController {

    private ResourceBundle bundle = ResourceBundle.getBundle("bank");
    private Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BankService bankService;

    @GetMapping("/get")
    public List<Customer> callList(){
        return bankService.listAll();
    }

//    @GetMapping("/get/{uname}")
//    public Optional<Customer> callOneCustomer(@PathVariable("uname") String uname){
//        logger.debug("Fetching user that matches with"+uname);
//        return bankService.getByUsername(uname);
//    }

//    @GetMapping("/{uname}")
//    public String callLogin(@PathVariable("uname") String uname){
//        logger.info("callLogin Method started running");
//        return bankService.userLogin(uname);
//    }

    @PostMapping("/createLoan")
    public String applyLoan(@RequestParam("amount") float amount, @RequestParam("tenure") int tenure,@RequestParam("type") String type,@RequestParam("customer") String customer){
        Long schemeId = bankService.getIdByScheme(type);
        Long customerId = bankService.getIdByUsername(customer);
        return bankService.addLoan(amount,tenure,schemeId,customerId);
    }

    @PostMapping("/login")
    public String loginMethod(@RequestParam("username") String username,@RequestParam("password") String password){
        Customer customer = bankService.getByUsername(username);

        if (customer == null){
            return bundle.getString("userNotExist");
        }
        else {
            String status = customer.getCustomerStatus();
            if (status.equalsIgnoreCase("inactive")){
                return bundle.getString("accDeactivated");
            }
            else {
                int attempts = customer.getFailedAttempts();
                String pass = customer.getPassword();
                if (!pass.equals(password)){
                    bankService.updateAttempts(username);
                    if((attempts+1)==3){
                        bankService.updateStatus(username);
                    }
                    return bundle.getString("passIncorect")+". "+(2-attempts)+" attempt(s) remaining";
                }
                else {
                    bankService.loginSuccess(username);
                    return bundle.getString("loginSuccess");
                }
            }
        }
    }
}
