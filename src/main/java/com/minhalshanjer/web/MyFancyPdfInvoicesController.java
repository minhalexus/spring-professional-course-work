package com.minhalshanjer.web;

import com.minhalshanjer.Invoice;
import com.minhalshanjer.InvoiceDto;
import com.minhalshanjer.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Controller
//@Validated
//public class MyFancyPdfInvoicesController {
//
//    private final InvoiceService invoiceService;
//
//    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
//        this.invoiceService = invoiceService;
//    }
//
//    @GetMapping("/invoices")
//    public String homepage() {
//        return "index.html";
//    }
//
//}

@RestController
@Validated // @Validated annotation goes hand in hand with MethodValidationPostProcessor bean configured in the context configuration file
public class MyFancyPdfInvoicesController {

    private final InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice makeInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }


//    @PostMapping("/invoices")
//    public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId, @RequestParam @Min(10) @Max(50) Integer amount) {
//        return invoiceService.create(userId, amount);
//    }
}