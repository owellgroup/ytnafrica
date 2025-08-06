package com.example.ytnafrica.services;

import com.example.ytnafrica.models.admin.OrginCompanybankDetaills;
import com.example.ytnafrica.repositories.OrginCompanybankDetaillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrginComBankDService {
    @Autowired
    private OrginCompanybankDetaillsRepository repository;

    //posting
    public OrginCompanybankDetaills saveCompanybankDetaills(OrginCompanybankDetaills companybankDetaills){
        return repository.save(companybankDetaills);
    }

    //get all
    public List<OrginCompanybankDetaills> findAllCompanybankDetaills(){
        return repository.findAll();
    }

    //get by Id
    public Optional<OrginCompanybankDetaills> findCompanybankDetaills(long id){
        return repository.findById(id);
    }

    //updating
    public OrginCompanybankDetaills updateCompanybankDetaills(OrginCompanybankDetaills companybankDetaills){
        OrginCompanybankDetaills newdated = repository.findById(companybankDetaills.getId()).get();
        newdated.setBankName(companybankDetaills.getBankName());
        newdated.setBankAccountNumber(companybankDetaills.getBankAccountNumber());
        newdated.setBankAccountName(companybankDetaills.getBankAccountName());
        newdated.setBranchCode(companybankDetaills.getBranchCode());
        newdated.setBranchName(companybankDetaills.getBranchName());
        newdated.setPaymentMethod(companybankDetaills.getPaymentMethod());
        return repository.save(newdated);

    }

    //deleteting
    public void deleteCompanybankDetaills(long id){
        repository.deleteById(id);
    }
}
