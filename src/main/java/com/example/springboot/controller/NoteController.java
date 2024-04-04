package com.example.springboot.controller;

import com.example.springboot.note.Note;
import com.example.springboot.note.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping(value = "/create")
    public ModelAndView createNotes() {
        ModelAndView result = new ModelAndView("create");
        result.addObject("note", noteService.listAll());
        return result;
    }

    @PostMapping(value = "/create")
    public RedirectView create(@ModelAttribute Note note) {
        RedirectView redirectView = new RedirectView("/note/list");
        noteService.add(note);
        return redirectView;
    }

    @GetMapping(value = "/list")
    public ModelAndView getListNotes() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("note", noteService.listAll());
        return result;
    }

    @PostMapping(value = "/delete")
    public RedirectView delete(@RequestParam(name = "id") Long id) {
        RedirectView redirectView = new RedirectView("/note/list");
        noteService.deleteById(id);
        return redirectView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam(name = "id") long id) {
        ModelAndView result = new ModelAndView("edit");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

    @PostMapping(value = "/edit")
    public RedirectView edit(@ModelAttribute Note note) {
        RedirectView redirectView = new RedirectView("/note/list");
        noteService.update(note);
        return redirectView;
    }
}
