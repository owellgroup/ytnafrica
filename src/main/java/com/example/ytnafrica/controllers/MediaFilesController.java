package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Documents;
import com.example.ytnafrica.models.MediaFiles;
import com.example.ytnafrica.services.MediaFilesService;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mediafiles/")
public class MediaFilesController {
    @Autowired
    private MediaFilesService mediaFilesService;

    //post media
    @PostMapping("/post")
    public MediaFiles post(@RequestParam("file") MultipartFile file, @RequestParam("MediafileName") String MediafileName, @RequestParam("lyrics") String lyrics) throws Exception{
        return mediaFilesService.uploadMediaFile(file, MediafileName, lyrics);
    }

    //get media files
    @GetMapping("/all")
    public List<MediaFiles> getAllMediaFiles() throws Exception{
        return mediaFilesService.getMediaFiles();
    }

    //get by id
    @GetMapping("/{id}")
    public Optional<MediaFiles> getMediaFileById(@PathVariable("id") Long id) throws Exception{
        return mediaFilesService.getMediaFileById(id);
    }

    //Updating
   @PutMapping("/update/{id}")
   public MediaFiles updatedMediaFiles(@PathVariable("id") Long id, @RequestParam("MediafileName") String MediafileName, @RequestParam("lyrics") String lyrics, @RequestParam(value = "file", required = false) MultipartFile file)  throws Exception{
        return mediaFilesService.updateMediaFiles(id, file, MediafileName, lyrics);
   }
    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteMediaFileById(@PathVariable("id") Long id) throws Exception{
        mediaFilesService.deleteMediaFileById(id);
    }
    //viewing
    //
    @GetMapping("/view/{filename:.+}")
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        try {
            Resource resource = mediaFilesService.loadFileAsResource(filename);
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


