package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.PassportPhoto;
import com.example.ytnafrica.services.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/passportphoto/")
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



}
