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
    int counter = 3;
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        Customer customer = bankService.getByUsername(username);
        if(customer!=null){
            if(customer.getCustomerStatus().equalsIgnoreCase("inactive")) {
                exception = new LockedException(resourceBundle.getString("accDeactivated"));
                logger.info(resourceBundle.getString("accDeactivated"));
                super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("accDeactivated"));
            }
            else {
                bankService.updateAttempts(customer.getUsername());
                logger.info(resourceBundle.getString("passIncorrect"));
                exception = new LockedException(resourceBundle.getString("passIncorrect"));
                super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("passIncorrect"));
                if(customer.getFailedAttempts()+1==3) {
                    bankService.updateStatus(customer.getUsername());
                    logger.info("Account getting deactivated");
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
