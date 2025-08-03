package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}