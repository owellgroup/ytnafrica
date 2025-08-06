package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.BankName;
import com.example.ytnafrica.services.BankNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bankname")
public class BankNameController {
    @Autowired
    private BankNameService bankNameService;

    //post maping
    @PostMapping("/post")
    public BankName saveBankName(@RequestBody BankName bankName) {
        return bankNameService.savBank(bankName);
    }

    //get all banks
    @GetMapping("/all")
    public List<BankName> getAllBankName() {
        return bankNameService.getAllBanks();
    }
    //get bank y Id
    @GetMapping("/{id}")
    public Optional<BankName> getBankNameById(Long id) {
        return bankNameService.getBankById(id);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteBankNameById(Long id) {
        bankNameService.deleteBankById(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public BankName updateBankName(@PathVariable Long id, @RequestBody BankName bankName) {
        bankName.setId(id);
        return bankNameService.updateBank(bankName);
    }
}
