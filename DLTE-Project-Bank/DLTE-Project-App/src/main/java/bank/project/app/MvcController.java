package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvcController {
    @GetMapping("/")
    public String landing(){
        return "index";
    }
    @GetMapping("/dashboard")
    public String dash(){
        return "dashboard";
    }
    @GetMapping("/apply")
    public String applyLoan(){
        return "applyLoan";
    }
}
