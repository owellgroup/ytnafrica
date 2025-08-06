package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Documents;
import com.example.ytnafrica.models.DocumentsCategory;
import com.example.ytnafrica.repositories.DocumentsCategoryRepository;
import com.example.ytnafrica.repositories.DocumentsRepository;
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
public class DocumentService {
    @Autowired
    private DocumentCatService docurep;
    @Autowired
    private DocumentsRepository documentsrepo;

    //directory
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    //post
    public Documents uploadDocument(MultipartFile file, String tittle, Long categoryId) throws Exception {
        // Validate file type
        String contentType = file.getContentType();
        if (contentType == null || (!contentType.equals("application/pdf")
                )) {
            throw new IllegalArgumentException("Only PDF and Excel files are allowed");
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
        String fileUrl = "http://localhost:8080/api/documents/view/" + fileName;
        //create document entity
        Documents documents = new Documents();
        documents.setTitle(tittle);
        documents.setDateposted(LocalDate.now());
        documents.setFileUrl(fileUrl);
        documents.setFileType(contentType);
        //fetching document category type
        //DocumentsCategory documentsCategory = docurep.findById(documents.getId()).orElse(null);
        DocumentsCategory documentsCategory = docurep.getDocCatById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));;
        documents.setDocumentsCategory(documentsCategory);
        return documentsrepo.save(documents);

    }

    //load file
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

    //fetch document by Category
    public List<Documents> getDocsByCategory(Long categoryId) {
        return documentsrepo.findDocumentByDocumentsCategoryId(categoryId);
    }

    //Get documents by Id

    public Optional<Documents> getDocById(Long id) {
        return documentsrepo.findById(id);
    }

    //updating document
    public Documents updateDocument(long id, MultipartFile file, String tittle, Long categoryId) throws Exception {
        Documents existingDocument = documentsrepo.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        // Update fields
        if (file != null && !file.isEmpty()) {
            // Save the file with timestamp to handle duplicates
            String originalFileName = file.getOriginalFilename();
            String fileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + System.currentTimeMillis()
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            String fileUrl = "http://localhost:8080/api/documents/view/" + fileName;
            existingDocument.setFileUrl(fileUrl);
            existingDocument.setFileType(file.getContentType());

        }

        existingDocument.setTitle(tittle);
        existingDocument.setDateposted(LocalDate.now());
        //fetching Document Category
        if (categoryId != null) {
            DocumentsCategory documentsCategory = docurep.getDocCatById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));;
            existingDocument.setDocumentsCategory(documentsCategory);
        }
        return documentsrepo.save(existingDocument);

    }

    //deteting
    public void deleteDocument(Long id) throws Exception {
        Documents documents = documentsrepo.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        documentsrepo.deleteById(id);
    }







}
