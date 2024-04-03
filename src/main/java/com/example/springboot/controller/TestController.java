package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    public ModelAndView getText() {
        ModelAndView result = new ModelAndView("test");
        return result;
    }
}
