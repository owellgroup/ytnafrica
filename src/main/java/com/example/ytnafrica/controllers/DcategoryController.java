package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.DocumentsCategory;
import com.example.ytnafrica.services.DocumentCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentcategory")
public class DcategoryController {
    @Autowired
    private DocumentCatService documentCatService;

    //posting
    @PostMapping("/post")
    public DocumentsCategory postDocCat(@RequestBody DocumentsCategory docCat) {
        return documentCatService.saveDocCat(docCat);
    }
    //get all
    @GetMapping("/all")
    public List<DocumentsCategory> getAllDocCat() {
        return documentCatService.getDocCats();
    }

    //get by Id
    @GetMapping("/{id}")
    public Optional<DocumentsCategory> getDocCatById(@PathVariable Long id) {
        return documentCatService.getDocCatById(id);
    }

    //deleting
    @DeleteMapping("/delete/{id}")
    public void deleteDocCId(@PathVariable Long id) {
        documentCatService.deleteDocCat(id);
    }

    //updating
    @PutMapping("/update/{id}")
    public DocumentsCategory updateDocCat(@RequestBody DocumentsCategory docCat, @PathVariable Long id) {
        docCat.setId(id);
        return documentCatService.updateDocCat(docCat);
    }
}
