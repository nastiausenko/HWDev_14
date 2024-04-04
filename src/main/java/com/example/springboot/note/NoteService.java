package com.example.springboot.note;

import com.example.springboot.exceptions.NoteNotFoundException;
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
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NoteNotFoundException(id);
    }

    public void update(Note note) {
        if (repository.existsById(note.getId())) {
            repository.save(note);
        } else throw new NoteNotFoundException(note.getId());
    }

    public Note getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }
}
