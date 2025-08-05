package com.example.ytnafrica.controllers;

import com.example.ytnafrica.models.Note;
import com.example.ytnafrica.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    //posting
    @PostMapping("/post")
    public Note postNote(@RequestBody Note note){
        return noteService.saveNote(note);
    }
    //get all
    @GetMapping("/all")
    public List<Note> getAllNote(){
        return noteService.findAllNote();
    }

    //get by id
    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable long id){
        return noteService.findNoteById(id);
    }
    //updating
    @PutMapping("/update/{id}")
    public Note updateNote(@RequestBody Note note, @PathVariable long id){
        note.setId(id);
        return noteService.saveNote(note);
    }

    //delete
    @DeleteMapping("delete/{id}")
    public void deleteNote(@PathVariable long id){
        noteService.deleteNote(id);
    }
}
