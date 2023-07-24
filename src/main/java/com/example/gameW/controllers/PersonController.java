package com.example.gameW.controllers;

import com.example.gameW.dao.PersonDao;
import com.example.gameW.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @GetMapping()
    public String getPerson(Model model){
        model.addAttribute("people", personDao.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDao.show(id));
        return "show";

    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        personDao.save(person);
        return "redirect:/people";
    }
    @GetMapping("/game")
    public int wordle(@RequestParam("word") String word){      //новое
        return word.length();
    }


}
