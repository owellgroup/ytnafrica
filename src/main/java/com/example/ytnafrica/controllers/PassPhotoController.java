package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.PassportPhoto;
import com.example.ytnafrica.services.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passportphoto")
public class PassPhotoController {
    @Autowired
    private PassportService passportService;

    //POST
    @PostMapping("/post")
    public PassportPhoto postpic (@RequestParam("file") MultipartFile file, @RequestParam("imagetitle") String imagetitle) throws Exception{
        return passportService.postphoto(file,imagetitle);
    }

    //get all
    @GetMapping("/all")
    public List<PassportPhoto> getAllPhotos() throws Exception{
        return passportService.getall();

    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<PassportPhoto> getPhotoById(@PathVariable("id") Long id) throws Exception{
        return passportService.getById(id);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public void deletePhotoById(@PathVariable("id") Long id) throws Exception{
        passportService.delete(id);
    }

    //update this
    @PutMapping("/update/{id}")
    public PassportPhoto updating(Long id, @RequestParam("file") MultipartFile file, @RequestParam("imagetitle") String imagetitle) throws Exception{
        return passportService.updatepho(id,file,imagetitle);
    }

    //viewing
    @GetMapping("/view/{filename:.+}")
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        try {
            Resource resource = passportService.loadFileAsResource(filename);
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
