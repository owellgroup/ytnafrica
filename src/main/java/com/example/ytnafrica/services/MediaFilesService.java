package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Documents;
import com.example.ytnafrica.models.MediaFiles;
import com.example.ytnafrica.repositories.MediaFilesRepository;
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
public class MediaFilesService {
    @Autowired
    private MediaFilesRepository mediaFilesRepository;
    //file directory
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    //post ]ing
    public MediaFiles uploadMediaFile(MultipartFile file, String MediafileName, String lyrics) throws Exception {
        // Validate file type
        String contentType = file.getContentType();

        // Allow all audio/* and video/* MIME types
        if (contentType == null ||
                (!contentType.startsWith("audio/") && !contentType.startsWith("video/"))) {
            throw new IllegalArgumentException("Only audio and video files are allowed");
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
        String fileUrl = "http://localhost:8080/api/mediafiles/view/" + fileName;
        MediaFiles mediaFiles = new MediaFiles();
        mediaFiles.setLyrics(lyrics);
        mediaFiles.setMediafileName(MediafileName);
        mediaFiles.setFileUrl(fileUrl);
        mediaFiles.setFileDatePosted(LocalDate.now());
        mediaFiles.setFileType(contentType);
        return mediaFilesRepository.save(mediaFiles);

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

    //get Media Files
    public List<MediaFiles> getMediaFiles() {
        return mediaFilesRepository.findAll();
    }

    //get media files by Id
    public Optional<MediaFiles> getMediaFileById(Long id) {
        return mediaFilesRepository.findById(id);
    }

    //update method
    public MediaFiles updateMediaFiles (Long id, MultipartFile file, String MediafileName, String lyrics) throws IOException {
        MediaFiles existingDocument = mediaFilesRepository.findById(id).orElseThrow(() -> new RuntimeException("media not found"));

        // Update fields
        if (file != null && !file.isEmpty()) {
            // Save the file with timestamp to handle duplicates
            String originalFileName = file.getOriginalFilename();
            String fileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + System.currentTimeMillis()
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            String fileUrl = "http://localhost:8080/api/mediafiles/view/" + fileName;
            existingDocument.setFileUrl(fileUrl);
            existingDocument.setFileType(file.getContentType());

        }

        existingDocument.setLyrics(lyrics);
        existingDocument.setFileDatePosted(LocalDate.now());
        existingDocument.setMediafileName(MediafileName);
        return mediaFilesRepository.save(existingDocument);
    }

    //deleting method
    public void deleteMediaFileById(Long id) throws Exception {
        mediaFilesRepository.deleteById(id);
    }




}
