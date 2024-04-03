package com.example.springboot.note;

import com.example.springboot.note.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        Long id = Math.abs(new Random().nextLong());
        note.setId(id);
        notes.add(note);
        return note;
    }

    public void deleteById(Long id) {
        for (Note note : notes) {
            if (Objects.equals(note.getId(), id)) {
                notes.remove(note);
                return;
            }
        }
        throw new IllegalArgumentException("Note with id = " + id + " doesn't exist");
    }

    public void update(Note note) {
        for (Note note1 : notes) {
            if (Objects.equals(note1.getId(), note.getId())) {
                note1.setTitle(note.getTitle());
                note1.setContent(note.getContent());
                return;
            }
        }
        throw new IllegalArgumentException("Note with id = " + note.getId() + " doesn't exist");
    }

    public Note getById(Long id) {
        for (Note note : notes) {
            if (Objects.equals(note.getId(), id)) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note with id = " + id + " doesn't exist");
    }
}
