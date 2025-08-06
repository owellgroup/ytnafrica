package com.example.ytnafrica.services;

import com.example.ytnafrica.models.admin.InvoiceServiceType;
import com.example.ytnafrica.repositories.InvoiceServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceTypeService {
    @Autowired
    private InvoiceServiceTypeRepository invoiceTpr;

    //post
    public InvoiceServiceType saveInvoiceServiceType(InvoiceServiceType invoiceServiceType) {
        return invoiceTpr.save(invoiceServiceType);
    }
    //get all
    public List<InvoiceServiceType> getAllInvoiceServiceTypes() {
        return invoiceTpr.findAll();
    }

    //get by id
    public Optional<InvoiceServiceType> getInvoiceServiceTypeById(long id) {
        return invoiceTpr.findById(id);
    }
    //update
    public InvoiceServiceType updateInvoiceServiceType(InvoiceServiceType invoiceServiceType) {
        InvoiceServiceType updated = invoiceTpr.findById(invoiceServiceType.getId()).orElse(null);
        updated.setInvoiceServiceName(invoiceServiceType.getInvoiceServiceName());
        return invoiceTpr.save(updated);
    }

    //delete
    public void deleteInvoiceServiceType(long id) {
        invoiceTpr.deleteById(id);
    }
}
