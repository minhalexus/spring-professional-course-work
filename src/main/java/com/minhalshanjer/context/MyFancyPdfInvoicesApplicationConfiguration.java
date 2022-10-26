package com.minhalshanjer.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhalshanjer.ApplicationLauncher;
import com.minhalshanjer.InvoiceService;
import com.minhalshanjer.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
//@PropertySource("classpath:/someOtherFile.properties")
public class MyFancyPdfInvoicesApplicationConfiguration {

//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    // @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // this will give a new UserService each time ctx.getBean() is called
//    // Default behavior is SCOPE_SINGLETON meaning only single instance
//    public UserService userService() {
//        return new UserService();
//    }
//
//    This is a dependency injection
//    @Bean
//    public InvoiceService invoiceService(UserService userService) {
//        return new InvoiceService(userService);
//    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

