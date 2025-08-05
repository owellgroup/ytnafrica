package com.example.ytnafrica.services;

import com.example.ytnafrica.models.Note;
import com.example.ytnafrica.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noterepo;

    //posting
    public Note saveNote(Note note){
        return noterepo.save(note);
    }

    //get all
    public List<Note> findAllNote(){
        return noterepo.findAll();
    }

    //get by Id
    public Optional<Note> findNoteById(long id){
        return noterepo.findById(id);
    }

    //updating
    public Note updateNote(Note note){
        Note updatedNote = noterepo.findById(note.getId()).get();
        updatedNote.setNote(note.getNote());
        return noterepo.save(updatedNote);
    }

    //delete
    public void deleteNote(long id){
        noterepo.deleteById(id);
    }


}
