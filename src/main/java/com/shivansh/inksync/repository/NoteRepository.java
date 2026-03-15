package com.shivansh.inksync.repository;

import com.shivansh.inksync.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, String> {
}