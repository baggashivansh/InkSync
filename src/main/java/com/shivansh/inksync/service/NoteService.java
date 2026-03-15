package com.shivansh.inksync.service;

import com.shivansh.inksync.dto.EditMessage;
import com.shivansh.inksync.model.Note;
import com.shivansh.inksync.repository.NoteRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void saveEdit(EditMessage message) {

        Optional<Note> existingNote = noteRepository.findById(message.getDocId());

        Note note;

        if (existingNote.isPresent()) {

            note = existingNote.get();
            note.setContent(message.getContent());
            note.setLastUpdated(System.currentTimeMillis());

        } else {

            note = new Note(
                    message.getDocId(),
                    message.getContent(),
                    System.currentTimeMillis()
            );
        }

        noteRepository.save(note);
    }
}