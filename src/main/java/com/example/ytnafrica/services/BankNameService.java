package com.example.ytnafrica.services;

import com.example.ytnafrica.models.BankName;
import com.example.ytnafrica.repositories.BankNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankNameService {
    @Autowired
    private BankNameRepository bankNameRepo;

    //post
    public BankName savBank(BankName bankN){
        return bankNameRepo.save(bankN);
    }
    //get all banks
    public List<BankName> getAllBanks(){
        return bankNameRepo.findAll();
    }

    //get by Ip
    public Optional<BankName> getBankById(long id){
        return bankNameRepo.findById(id);
    }

    //delete
    public void deleteBankById(long id){
        bankNameRepo.deleteById(id);
    }

    //update bank
    public BankName updateBank(BankName bankName){
        BankName updatedBank = bankNameRepo.findById(bankName.getId()).orElse(null);
        updatedBank.setBankName(bankName.getBankName());
        return bankNameRepo.save(updatedBank);
    }
}
