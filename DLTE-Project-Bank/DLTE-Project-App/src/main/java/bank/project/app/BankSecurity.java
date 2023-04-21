package bank.project.app;

import bank.project.dao.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//Spring Security Configuration
@Configuration
public class BankSecurity {

    @Autowired
    BankService bankService;

    AuthenticationManager authenticationManager;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/files/**","/web/login/**").permitAll(); //Permitting all files and login errors
        httpSecurity.authorizeRequests().anyRequest().authenticated(); //All pages must be authenticated
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(loginFailureHandler).successHandler(loginSuccessHandler).permitAll();
        httpSecurity.logout().permitAll();
        httpSecurity.csrf().disable();

        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}