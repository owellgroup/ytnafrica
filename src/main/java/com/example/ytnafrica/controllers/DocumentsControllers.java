package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Documents;
import com.example.ytnafrica.services.DocumentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class DocumentsControllers {
    @Autowired
    private DocumentService documentService;

    //posting
    @PostMapping("/upload")
    public Documents upload(@RequestParam("file") MultipartFile file, @RequestParam("tittle")  String tittle, @RequestParam("categoryId") Long categoryId) throws Exception{
        return documentService.uploadDocument(file, tittle, categoryId);

    }

    //get doc by category
    @GetMapping("/getdocbycategory/{categoryId}")
    public List<Documents> getdocbycategory(@PathVariable("categoryId") Long categoryId) throws Exception{
        return documentService.getDocsByCategory(categoryId);
    }

    //get by Id
    @GetMapping("/getbyid/{id}")
    public Optional<Documents> getdocbyid(@PathVariable("id") Long id) throws Exception {
        return documentService.getDocById(id);
    }


    //Download
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) throws IOException {
        Documents document = documentService.getDocById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        // Extract filename from URL
        String fileName = document.getFileUrl().substring(document.getFileUrl().lastIndexOf("/") + 1);
        Resource resource = documentService.loadFileAsResource(fileName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }


    //to view the document
    // View document in the browser
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewDocument(@PathVariable String fileName) throws MalformedURLException {
        try {
            Resource resource = documentService.loadFileAsResource(fileName);
            String contentType = Files.probeContentType(resource.getFile().toPath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");


            // For Excel files, force download
            if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ||
                    contentType.equals("application/vnd.ms-excel")) {
                return responseBuilder
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }

            // For PDF files, display inline
            if (contentType.equals("application/pdf")) {
                return responseBuilder
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }

            // Default to download for unknown types
            return responseBuilder
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

   //Updating
   @PutMapping("/update/{id}")
   public Documents updateDocuments(
           @PathVariable("id") Long id,
           @RequestParam("tittle") String tittle,
           @RequestParam("categoryId") Long categoryId,
           @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
       return documentService.updateDocument(id, tittle, categoryId, file);
   }


    //deleting
    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable("id") Long id) throws Exception{
        documentService.deleteDocument(id);
    }


}
