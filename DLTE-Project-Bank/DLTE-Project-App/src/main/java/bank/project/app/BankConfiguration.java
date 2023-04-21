package bank.project.app;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Configs for SOAP API
@EnableWs
@Configuration
public class BankConfiguration extends WsConfigurerAdapter {
    @Bean(name = "loanScheme")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema loanSchema){
        DefaultWsdl11Definition schemaObject = new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("LoanPort");
        schemaObject.setTargetNamespace("http://bank.project.soap");
        schemaObject.setLocationUri("/loanPoint");
        schemaObject.setSchema(loanSchema);
        return schemaObject;
    }

    @Bean
    public XsdSchema loanSchema(){
        return new SimpleXsdSchema(new ClassPathResource("bank.xsd"));
    }

    @Bean
    public ServletRegistrationBean servletRegistration(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/loanPoint/*");    }
}
