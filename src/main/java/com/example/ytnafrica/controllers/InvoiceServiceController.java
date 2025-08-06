package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.admin.InvoiceServiceType;
import com.example.ytnafrica.services.InvoiceServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoiceservice")
public class InvoiceServiceController {
    @Autowired
    private InvoiceServiceTypeService  invoiceS;

    //post
    @PostMapping("/post")
    public InvoiceServiceType createInvoiceServiceType(@RequestBody InvoiceServiceType invoiceServiceType){
        return invoiceS.saveInvoiceServiceType(invoiceServiceType);
    }

    //get all
    @GetMapping("/all")
    public List<InvoiceServiceType> getAllInvoiceServiceTypes(){
        return invoiceS.getAllInvoiceServiceTypes();
    }
    //get by Id
    @GetMapping("/{id}")
    public Optional<InvoiceServiceType> getInvoiceServiceType(@PathVariable Long id){
        return invoiceS.getInvoiceServiceTypeById(id);
    }

    //update
    @PutMapping("/update/{id}")
    public InvoiceServiceType updateInvoiceServiceType(@PathVariable Long id, @RequestBody InvoiceServiceType invoiceServiceType){
        invoiceServiceType.setId(id);
        return invoiceS.saveInvoiceServiceType(invoiceServiceType);
    }

    //deleting
    @DeleteMapping("/delete/{id}")
    public void deleteInvoiceServiceType(@PathVariable Long id){
           invoiceS.deleteInvoiceServiceType(id);
    }
}
