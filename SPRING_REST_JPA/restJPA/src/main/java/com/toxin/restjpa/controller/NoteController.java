package com.toxin.restjpa.controller;

import com.toxin.restjpa.entity.Note;
import com.toxin.restjpa.exception.ResourceNotFoundException;
import com.toxin.restjpa.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    //GET ALL
    @GetMapping("/notes")
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    //CREATE
    @PostMapping("/notes")
    public Note create(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    //GET BY ID
    @GetMapping("/notes/{id}")
    public Note getById(@PathVariable(value = "id") Long id) {
        return noteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    //UPDATE
    @PutMapping("/notes/{id}")
    public Note update(
        @PathVariable(value = "id") Long id,
        @Valid @RequestBody Note newNote) {

        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

        note.setTitle(newNote.getTitle());
        newNote.setContent(newNote.getContent());

        return noteRepository.save(note);
    }

    //DELETE
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
