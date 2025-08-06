package com.example.ytnafrica.services;

import com.example.ytnafrica.models.PassportPhoto;
import com.example.ytnafrica.repositories.PassportPhotoRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PassportService {
    @Autowired
    private PassportPhotoRepository1 passService;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    //post
    public PassportPhoto postphoto(MultipartFile file, String imagetitle) throws IOException {
        String contentType = file.getContentType();

        // Allow only image/* MIME types
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Only image files are allowed");
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
        String fileUrl = "http://localhost:8080/api/passportphoto/view/" + fileName;
        PassportPhoto newpass = new PassportPhoto();
        newpass.setFileType(contentType);
        newpass.setImageurl(fileUrl);
        newpass.setImagetitle(imagetitle);
        newpass.setDatePosted(LocalDate.now());
        return passService.save(newpass);

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


    //get all
    public List<PassportPhoto> getall() {
        return passService.findAll();
    }

    //get by Id

    public Optional<PassportPhoto> getById(Long id) {
        return passService.findById(id);
    }

    //delete
    public void delete(Long id) {
        passService.deleteById(id);
    }

    //upadting
    public PassportPhoto updatepho(Long id, MultipartFile file, String imagetitle) throws IOException {
        PassportPhoto newpass = passService.findById(id).orElseThrow(() -> new RuntimeException("media not found"));
        // Update fields
        if (file != null && !file.isEmpty()) {
            // Save the file with timestamp to handle duplicates
            String originalFileName = file.getOriginalFilename();
            String fileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + System.currentTimeMillis()
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            String fileUrl = "http://localhost:8080/api/passportphoto/view/" + fileName;
            newpass.setFileType(file.getContentType());
            newpass.setImageurl(fileUrl);
        }
        newpass.setImagetitle(imagetitle);
        newpass.setDatePosted(LocalDate.now());
        return passService.save(newpass);
    }

    //lead

}
