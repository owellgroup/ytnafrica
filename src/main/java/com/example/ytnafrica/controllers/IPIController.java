package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.IPI;
import com.example.ytnafrica.services.IPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ipi")
public class IPIController {

    @Autowired
    private IPIService ipiService;

    //post Maping
    @PostMapping("/post")
    public IPI postIPI(@RequestBody IPI ipi) {
        return ipiService.saveIPI(ipi);
    }
    //get all
    @GetMapping("/all")
    public List<IPI> getAllIPI() {
        return ipiService.getIPI();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<IPI> getIPIById(@PathVariable long id) {
        return ipiService.getIPI(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public IPI updateIPI(@PathVariable long id, @RequestBody IPI ipi) {
        ipi.setId(id);
        return ipiService.saveIPI(ipi);
    }

    //delete map
    @DeleteMapping("/delete/{id}")
    public void deleteIPI(@PathVariable long id) {
        ipiService.deleteIPI(id);
    }

}
