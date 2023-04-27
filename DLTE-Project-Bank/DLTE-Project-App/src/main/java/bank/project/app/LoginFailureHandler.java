package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("bank");
    Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        Customer customer = bankService.getByUsername(username);
        //Check if the customer exists
        if(customer!=null){
//          if the customer exists
            if(customer.getCustomerStatus().equalsIgnoreCase("inactive")) {
                exception = new LockedException(resourceBundle.getString("accDeactivated"));
                logger.info(resourceBundle.getString("accDeactivated"));
                super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("accDeactivated"));
            }
            else {
                if (customer.getFailedAttempts()==0){
                    bankService.updateAttempts(customer.getUsername());
                    logger.info(resourceBundle.getString("passIncorrect")+resourceBundle.getString("twoAttempts"));
                    exception = new LockedException(resourceBundle.getString("passIncorrect")+resourceBundle.getString("twoAttempts"));
                    super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("passIncorrect")+resourceBundle.getString("twoAttempts"));
                }
                else if (customer.getFailedAttempts()==1){
                    bankService.updateAttempts(customer.getUsername());
                    logger.info(resourceBundle.getString("passIncorrect")+resourceBundle.getString("oneAttempt"));
                    exception = new LockedException(resourceBundle.getString("passIncorrect")+resourceBundle.getString("oneAttempt"));
                    super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("passIncorrect")+resourceBundle.getString("oneAttempt"));
                }
                else if(customer.getFailedAttempts()==2) {
                    bankService.updateStatus(customer.getUsername());
                    bankService.updateAttempts(customer.getUsername());
                    logger.info(resourceBundle.getString("passIncorrect")+resourceBundle.getString("accDeactivated"));
                    exception = new LockedException(resourceBundle.getString("passIncorrect")+resourceBundle.getString("accDeactivated"));
                    super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("passIncorrect")+resourceBundle.getString("accDeactivated"));
                }
            }
        }
        else {
            exception = new LockedException(resourceBundle.getString("userNotExist"));
            logger.info(resourceBundle.getString("userNotExist"));
            super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("userNotExist"));
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
