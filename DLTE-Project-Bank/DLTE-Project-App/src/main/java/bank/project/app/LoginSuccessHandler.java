package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("bank");
    Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
        Customer customer = (Customer) authentication.getPrincipal();
//        If the status of the customer is active
        if (customer.getCustomerStatus().equalsIgnoreCase("active")){
            if(customer.getFailedAttempts()>0){
                customer.setFailedAttempts(0);
                bankService.loginSuccess(customer.getUsername());
                logger.info(resourceBundle.getString("loginSuccess"));
            }
            super.setDefaultTargetUrl("/web/dashboard");
            super.onAuthenticationSuccess(request, response, authentication);
        }
        //if the status is inactive
        else{
            super.setTargetUrlParameter("/web/login/?error="+resourceBundle.getString("accDeactivated"));
        }
    }
}
