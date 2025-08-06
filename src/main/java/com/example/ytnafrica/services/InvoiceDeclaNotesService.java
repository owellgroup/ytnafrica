package com.example.ytnafrica.services;

import com.example.ytnafrica.models.admin.InvoiceDeclarationNotes;
import com.example.ytnafrica.repositories.InvoiceDeclarationNotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDeclaNotesService {
    @Autowired
    private InvoiceDeclarationNotesRepository invoiceDn;

    //posting
    public InvoiceDeclarationNotes saveInvoiceDeclarationNotes(InvoiceDeclarationNotes invoiceDeclarationNotes) {
        return invoiceDn.save(invoiceDeclarationNotes);
    }

    //get invoices
    public List<InvoiceDeclarationNotes> findAllInvoiceDeclarationNotes() {
        return invoiceDn.findAll();
    }

    //get by Id
    public Optional<InvoiceDeclarationNotes> findInvoiceDeclarationNotes(int id) {
        return invoiceDn.findById(id);
    }

    //updating
    public InvoiceDeclarationNotes updateInvoiceDeclarationNotes(InvoiceDeclarationNotes inv) {
        InvoiceDeclarationNotes invoiceDeclarationNote = invoiceDn.findById(inv.getId()).orElse(null);
        invoiceDeclarationNote.setDeclarionNotes(inv.getDeclarionNotes());
        return invoiceDn.save(invoiceDeclarationNote);

    }

    //deleting
    public void deleteInvoiceDeclarationNotes(int id) {
        invoiceDn.deleteById(id);
    }
}
