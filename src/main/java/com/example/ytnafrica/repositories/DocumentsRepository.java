package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {
    //List<Documents> getDocumentByDocumentsCategory_Id(Long categoryId);

    List<Documents> findDocumentByDocumentsCategoryId(Long categoryId);
}