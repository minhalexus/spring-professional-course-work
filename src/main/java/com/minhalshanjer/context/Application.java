package com.minhalshanjer.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhalshanjer.InvoiceService;
import com.minhalshanjer.UserService;

public class Application {

    public static final InvoiceService invoiceService = new InvoiceService();
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final UserService userService = new UserService();

}