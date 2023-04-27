package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvcController {

//    Login Page
    @GetMapping("/login")
    public String landing(){
        return "index";
    }

//    Dashboard Page
    @GetMapping("/dashboard")
    public String dash(){
        return "dashboard";
    }

//    Loan Application Page
    @GetMapping("/apply")
    public String applyLoan(){
        return "applyLoan";
    }
}
