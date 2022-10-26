package com.minhalshanjer;

import com.minhalshanjer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

//    @Autowired // Another way to use @Autowired as field injection
    private final UserService userService;
    private final String cdnUrl;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();


    @Autowired // tell spring which constructor to use, but this is not the only way to use @Autowired
    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice newInvoice = new Invoice(userId, 50, cdnUrl + "/images/default/sample.pdf");
        invoices.add(newInvoice);
        return newInvoice;
    }

//    @Autowired // third way of using @Autowired using setter field injection
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}

