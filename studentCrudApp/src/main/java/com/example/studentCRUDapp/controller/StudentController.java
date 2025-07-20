


package com.example.studentCRUDapp.controller;

import com.example.studentCRUDapp.dao.StudentDAO;
import com.example.studentCRUDapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO dao;

    /* ---- CREATE form ---- */
    @GetMapping("/")
    public String showForm(Model m) {
        m.addAttribute("student", new Student());
        return "register";
    }

    /* ---- SAVE new ---- */
    @PostMapping("/register")
    public String save(@ModelAttribute Student s) {
        dao.save(s);
        return "redirect:/students";
    }

    /* ---- LIST ---- */
    @GetMapping("/students")
    public String list(Model m) {
        m.addAttribute("students", dao.findAll());
        return "students";
    }

    /* ---- EDIT form ---- */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("student", dao.findById(id));
        return "edit";
    }

    /* ---- UPDATE ---- */
    @PostMapping("/update")
    public String update(@ModelAttribute Student s) {
        dao.update(s);
        return "redirect:/students";
    }

    /* ---- DELETE ---- */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/students";
    }
}
