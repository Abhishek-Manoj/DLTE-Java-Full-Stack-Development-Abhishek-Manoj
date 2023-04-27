package bank.project.app;

import bank.project.dao.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ResourceBundle;

//REST API Controller
@ComponentScan("bank.project.dao")
@RestController
@RequestMapping("/template")
public class BankController {

    private ResourceBundle bundle = ResourceBundle.getBundle("bank");
    private Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BankService bankService;

    //Getting logged username in Spring Security
    @GetMapping("/username")
    public String getUsername(Principal principal){
        return principal.getName();
    }

    //Adding New Loan to Loan Table
    @PostMapping("/createLoan")
    public String applyLoan(@RequestParam("amount") float amount, @RequestParam("tenure") int tenure,@RequestParam("type") Long schemeId,@RequestParam("customer") String customer){
        logger.info("Entered applyLoan() method");
        return bundle.getString(bankService.addLoan(amount,tenure,schemeId,customer));
    }
}