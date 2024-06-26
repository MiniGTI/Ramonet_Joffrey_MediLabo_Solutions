package com.medilab.microservice_backend_note.controller;

import com.medilab.microservice_backend_note.dto.NoteDto;
import com.medilab.microservice_backend_note.dto.NoteUpdateDto;
import com.medilab.microservice_backend_note.error.DataNotFoundException;
import com.medilab.microservice_backend_note.model.Note;
import com.medilab.microservice_backend_note.service.NoteUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * The main controller of the microservice-backend-note, expose all endpoints.
 * <p>
 * Use GET - POST - PATCH - DELETE http requests.
 * The default url to call the controller is:
 * {@snippet lang = "Properties"}:
 * "/microservice_backend_note/v1/note"
 * </p>
 * <p>
 * Requests return Notes(s) model.
 *
 * @see Note
 * Requests require NoteDto to save a new note in the database.
 * @see NoteDto
 * Requests require NoteUpdateDto to modify a note in the database.
 * @see NoteUpdateDto
 * Require a NoteUseCase to apply business treatments and receive data.
 * @see NoteUseCase
 * </p>
 * <p>
 * Requests can throw exceptions if the note is not found.
 * @see DataNotFoundException
 * </p>
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/microservice-backend-note/v1/note")
public class NoteController {
    
    private final NoteUseCase noteService;
    
    @GetMapping("/all")
    public List<Note> getAll() {
        
        List<Note> notes = noteService.getAll();
        
        log.debug("NoteController - getAll - Notes list size: " + notes.size());
        
        return notes;
    }
    
    @GetMapping("/{id}")
    public Note getById(
            @PathVariable
            final String id) {
        
        Optional<Note> note = noteService.getById(id);
        
        if(note.isEmpty()) {
            throw new DataNotFoundException("Note not found");
        }
        
        log.debug("NoteController - getById - id parsed: " + id);
        
        return note.get();
    }
    
    @GetMapping("/patient/{id}")
    public List<Note> getByPatient(
            @PathVariable
            final String id) {
        
        List<Note> notes = noteService.getByPatient(id);
        
        log.debug("NoteController - getByPatient - id parsed: " + id + "Notes list size: " + notes.size());
        
        return notes;
    }
    
    @PostMapping("/save")
    public Note save(
            @RequestBody
            final NoteDto noteDto) {
        
        log.debug("NoteController - save - Notes parsed to save: " + noteDto.patient() + " - " + noteDto.note());
        
        return noteService.save(noteDto);
    }
    
    @PatchMapping("/update")
    public Note update(
            @RequestBody
            final NoteUpdateDto noteUpdateDto) {
        
        log.debug("NoteController - update - Note to update: " + noteUpdateDto.id() + ", information to update: " +
                noteUpdateDto.note());
        
        return noteService.update(noteUpdateDto);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteById(
            @PathVariable
            final String id) {
        
        if(noteService.getById(id)
                .isEmpty()) {
            throw new DataNotFoundException("Note not found");
        } else {
            
            log.debug("NoteController - deleteById - Id to delete: " + id);
            noteService.deleteById(id);
        }
    }
    
    /**
     * This version of delete is use to delete all patient's notes.
     *
     * @param id - String - The patient's id.
     */
    @DeleteMapping("/patient/delete/{id}")
    public void deleteByPatient(
            @PathVariable
            final String id) {

            log.debug("NoteController - deleteByPatient - Id to delete: " + id);
            noteService.deleteByPatient(id);
        
    }
}
