package com.example.ytnafrica.services;

import com.example.ytnafrica.models.DocumentsCategory;
import com.example.ytnafrica.repositories.DocumentsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentCatService {
    @Autowired
    private DocumentsCategoryRepository docuCatRepository;

    //posting
    public DocumentsCategory saveDocCat(DocumentsCategory docCat) {
        return docuCatRepository.save(docCat);
    }
    //get all
    public List<DocumentsCategory> getDocCats() {
        return docuCatRepository.findAll();
    }

    //get by Id
    public Optional<DocumentsCategory> getDocCatById(Long id) {
        return docuCatRepository.findById(id);
    }
    //updating
    public DocumentsCategory updateDocCat(DocumentsCategory docCat) {
        DocumentsCategory cat = docuCatRepository.findById(docCat.getId()).orElse(null);
        cat.setCategoryname(docCat.getCategoryname());
        return docuCatRepository.save(cat);
    }

    //deleting
    public void deleteDocCat(long id) {
        docuCatRepository.deleteById(id);
    }



}
