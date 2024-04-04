package com.example.springboot.note;

import com.example.springboot.repo.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public List<Note> listAll() {
        return repository.findAll();
    }

    public Note add(Note note) {
        return repository.save(note);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Note note) {
        repository.save(note);
    }

    public Note getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id = " + id + " doesn't exist"));
    }
}
