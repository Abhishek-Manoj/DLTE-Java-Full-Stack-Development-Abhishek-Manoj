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
        httpSecurity.authorizeRequests((requests)->{
//            requests.antMatchers("/resources/static/files/**").permitAll();
//            requests.antMatchers("/web/**","/template/**","/web/login/?error=**").authenticated();
            requests.anyRequest().permitAll();
        });
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(loginFailureHandler).successHandler(loginSuccessHandler).permitAll();
        httpSecurity.logout().logoutSuccessUrl("/web/login")
                .permitAll();
        httpSecurity.csrf().disable();

        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}