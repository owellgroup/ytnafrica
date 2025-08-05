package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.BankDetails;
import com.example.ytnafrica.models.BankName;
import com.example.ytnafrica.services.BankDetailsService;
import com.example.ytnafrica.services.BankNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bankdetails")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;
    @Autowired
    private BankNameService bankNameService;

    //Post Mapping
    @PostMapping("/save")
    public BankDetails saveBankDetails(@RequestBody BankDetails bankDetails) {
        // Extract BankName from BankDetails
        BankName bankName = bankDetails.getBankName();
        return bankDetailsService.saveBankDetails(bankDetails, bankName);
    }
    //get Maping
    @GetMapping("/all")
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsService.getAllBankDetails();
    }
    //get by Id
    @GetMapping("/{id}")
    public Optional<BankDetails> getBankDetails(@PathVariable Long id){
        return bankDetailsService.getBankDetailsById(id);
    }

    //delete maping
    @DeleteMapping("/delete/{id}")
    public void deleteBankDetails(@RequestBody BankDetails bankDetails, @PathVariable Long id){
        bankDetailsService.deleteBankDetailsById(id);
    }
    //updating
    @PutMapping("/update/{id}")
    public BankDetails updateBankDetails(@PathVariable long id, @RequestBody BankDetails bankDetails) {
        // Set the ID of the bank details from the path
        bankDetails.setId(id);

        // Extract the bank name from the request body
        BankName bankName = bankDetails.getBankName();

        return bankDetailsService.updateBankDetailsById(bankDetails, bankName);
    }
}
