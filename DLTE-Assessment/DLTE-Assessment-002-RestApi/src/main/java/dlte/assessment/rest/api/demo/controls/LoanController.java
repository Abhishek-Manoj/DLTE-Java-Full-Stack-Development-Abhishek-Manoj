package dlte.assessment.rest.api.demo.controls;

import dlte.assessment.rest.api.demo.models.PersonalLoan;
import dlte.assessment.rest.api.demo.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {
    @Autowired
    private LoanServices loanServices;

    @PutMapping("/status")
    public void callStatus(){
        loanServices.implementUpdate();
    }

    @GetMapping("/rejected")
    public List<Object[]> callRejected(){
        return loanServices.implementRejectedLoans();
    }
}
