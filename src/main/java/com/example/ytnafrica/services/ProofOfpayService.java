package com.example.ytnafrica.services;

import com.example.ytnafrica.models.PassportPhoto;
import com.example.ytnafrica.models.ProofOfPayments;
import com.example.ytnafrica.repositories.ProofOfPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProofOfpayService {
    @Autowired
    private ProofOfPaymentsRepository proofOf;

    private static final String UPLOAD_DIR =  System.getProperty("user.dir") + "/uploads/";

    //post method
    public ProofOfPayments postProof(MultipartFile file, String Amount) throws Exception {
        String contentType = file.getContentType();

        if (contentType == null ||
                (!contentType.startsWith("image/") && !contentType.equals("application/pdf"))) {
            throw new IllegalArgumentException("Only image and PDF files are allowed");
        }

        // Ensure upload directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // Save the file with timestamp to handle duplicates
        String originalFileName = file.getOriginalFilename();
        String fileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                + "_" + System.currentTimeMillis()
                + originalFileName.substring(originalFileName.lastIndexOf('.'));
        Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        // Generate a public URL for the file
        String fileUrl = "http://localhost:8080/api/proofofpayments/view/" + fileName;
        ProofOfPayments pro = new ProofOfPayments();
        pro.setAmount(Amount);
        pro.setFileUrl(fileUrl);
        pro.setFiletype(contentType);
        pro.setUploadedDate(LocalDate.now());
        return proofOf.save(pro);


    }

    //update method
    public ProofOfPayments updateProof(Long id, String Amount, MultipartFile file) throws Exception {
        ProofOfPayments pro = proofOf.findById(id).orElseThrow(() -> new RuntimeException("media not found"));
        if (file != null && !file.isEmpty()) {
            // Save the file with timestamp to handle duplicates
            String originalFileName = file.getOriginalFilename();
            String fileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + System.currentTimeMillis()
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            String fileUrl = "http://localhost:8080/api/proofofpayments/view/" + fileName;
            pro.setFiletype(file.getContentType());
            pro.setFileUrl(fileUrl);
        }
        pro.setAmount(Amount);
        pro.setUploadedDate(LocalDate.now());
        return proofOf.save(pro);
    }

    //delete method
    public void deleteProof(Long id) throws Exception {
        proofOf.findById(id).orElseThrow(() -> new RuntimeException("media not found"));
    }

    //get methods
    public List<ProofOfPayments> getAllProofOfPayments() {
        return proofOf.findAll();
    }

    //get by ID
    public Optional<ProofOfPayments> getProofOfPayments(Long id) throws Exception {
        return proofOf.findById(id);
    }

    //load file hhhh
    // Method to load a file as a resource
    public Resource loadFileAsResource(String fileName) throws MalformedURLException {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
            Path filePath = uploadPath.resolve(fileName).normalize();

            // Ensure parent directory exists
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Security check
            if (!filePath.startsWith(uploadPath)) {
                throw new RuntimeException("Invalid file path - attempted directory traversal");
            }

            if (!Files.exists(filePath)) {
                throw new RuntimeException("File not found: " + fileName);
            }

            if (!Files.isReadable(filePath)) {
                throw new RuntimeException("File is not readable: " + fileName);
            }

            Resource resource = new UrlResource(filePath.toUri());
            return resource;

        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed file URL for: " + fileName + ". Error: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Failed to load file: " + fileName + ". Error: " + e.getMessage());
        }
    }


}




