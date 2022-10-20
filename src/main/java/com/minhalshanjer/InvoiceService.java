package com.minhalshanjer;

import com.minhalshanjer.context.Application;
import com.minhalshanjer.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<Invoice>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = Application.userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice newInvoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(newInvoice);
        return newInvoice;
    }

}

