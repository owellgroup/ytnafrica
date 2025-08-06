package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.admin.InvoiceDeclarationNotes;
import com.example.ytnafrica.services.InvoiceDeclaNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoicedeclearion")
public class InvoiceDeController {
    @Autowired
    private InvoiceDeclaNotesService  invoiceDs;

    //posting
    @PostMapping("/post")
    public InvoiceDeclarationNotes postInvoice(@RequestBody InvoiceDeclarationNotes invoiceDn){
        return invoiceDs.saveInvoiceDeclarationNotes(invoiceDn);
    }

    //get invoice
    @GetMapping("/all")
    public List<InvoiceDeclarationNotes> findAll(){
        return invoiceDs.findAllInvoiceDeclarationNotes();
    }
    //get by Id
    @GetMapping("/{id}")
    public Optional<InvoiceDeclarationNotes> findInvoiceDeclarationNotes(@PathVariable int id){
        return invoiceDs.findInvoiceDeclarationNotes(id);
    }

    //update
    @PutMapping("/update/{id}")
    public InvoiceDeclarationNotes updateInvoiceDeclarationNotes(@PathVariable int id, @RequestBody InvoiceDeclarationNotes invoiceDn){
        invoiceDn.setId(id);
        return invoiceDs.saveInvoiceDeclarationNotes(invoiceDn);
    }

    //Deleting
    @DeleteMapping("/delete/{id}")
    public void deleteInvoiceDeclarationNotes(@PathVariable int id){
        invoiceDs.deleteInvoiceDeclarationNotes(id);
    }
}
