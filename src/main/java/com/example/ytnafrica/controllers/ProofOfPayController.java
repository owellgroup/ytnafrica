package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.ProofOfPayments;
import com.example.ytnafrica.repositories.ProofOfPaymentsRepository;
import com.example.ytnafrica.services.ProofOfpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proofofpayments")
public class ProofOfPayController {
    @Autowired
    private ProofOfpayService proof;

    //posting
    @PostMapping("/post")
    public ProofOfPayments post(@RequestParam("file") MultipartFile file, @RequestParam("Amount") String Amount) throws Exception {
        return proof.postProof(file, Amount);

    }

    //update method
    @PutMapping("/update/{id}")
    public ProofOfPayments updateit(@PathVariable Long id, @RequestParam("Amount") String Amount, @RequestParam("file") MultipartFile file) throws Exception {
        return proof.updateProof(id, Amount, file);
    }

    //get All
    @GetMapping("/all")
    public List<ProofOfPayments> getAll(){
        return proof.getAllProofOfPayments();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<ProofOfPayments> getProof(@PathVariable Long id) throws Exception {
        return proof.getProofOfPayments(id);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteProof(@PathVariable Long id) throws Exception {
        proof.deleteProof(id);
    }

    //viewing
    @GetMapping("/view/{filename:.+}")
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        try {
            Resource resource = proof.loadFileAsResource(filename);
            String contentType = "application/octet-stream"; // default fallback
            try {
                contentType = java.nio.file.Files.probeContentType(
                        java.nio.file.Paths.get(resource.getURI())
                );
            } catch (Exception e) {
                // log warning if needed
            }
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
                    .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
