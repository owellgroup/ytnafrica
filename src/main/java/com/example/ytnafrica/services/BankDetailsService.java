package com.example.ytnafrica.services;

import com.example.ytnafrica.models.BankDetails;
import com.example.ytnafrica.models.BankName;
import com.example.ytnafrica.repositories.BankDetailsRepository;
import com.example.ytnafrica.repositories.BankNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService {
    @Autowired

    private BankDetailsRepository bankDrepo;

    @Autowired
    private BankNameRepository bankr;


    //posting
    public BankDetails saveBankDetails (BankDetails bankDetails, BankName bankName) {
        BankName bank = bankr.findById(bankName.getId()).orElse(null);
        bankDetails.setBankName(bank);
        return bankDrepo.save(bankDetails);

    }

    //get bank details
   public List<BankDetails> getAllBankDetails(){
        return bankDrepo.findAll();
   }

   //get by ID
    public Optional<BankDetails> getBankDetailsById(long id){
        return bankDrepo.findById(id);
    }

    //detele\
    public void deleteBankDetailsById(long id){
        bankDrepo.deleteById(id);
    }

    //update
    public BankDetails updateBankDetailsById(BankDetails bankDetails, BankName bankName) {
        //geting the bankname with find by Id
        BankName bank = bankr.findById(bankName.getId()).orElse(null);
        BankDetails updatedBankdetails = bankDrepo.findById(bankDetails.getId()).orElse(null);
        //geting the bank name details here
        updatedBankdetails.setBankName(bank);
        updatedBankdetails.setBankBranchName(bankDetails.getBankBranchName());
        updatedBankdetails.setBankBranchNumber(bankDetails.getBankBranchNumber());
        updatedBankdetails.setBankAccountType(bankDetails.getBankAccountType());
        updatedBankdetails.setBankAccountNumber(bankDetails.getBankAccountNumber());
        updatedBankdetails.setAccountHolderName(bankDetails.getAccountHolderName());

         return bankDrepo.save(updatedBankdetails);
    }
}
