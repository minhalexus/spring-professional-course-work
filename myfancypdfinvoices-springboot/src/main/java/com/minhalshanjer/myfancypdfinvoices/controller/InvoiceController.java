package com.minhalshanjer.myfancypdfinvoices.controller;

import com.minhalshanjer.myfancypdfinvoices.dto.InvoiceDto;
import com.minhalshanjer.myfancypdfinvoices.model.Invoice;
import com.minhalshanjer.myfancypdfinvoices.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<Invoice> invoices() {
        return this.invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
