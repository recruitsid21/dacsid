package com.example.welcomeapp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.welcomeapp.dao.StudentDao;
import com.example.welcomeapp.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao studentDAO;
	
	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student")Student student) throws SQLException {
		studentDAO.save(student);
		return"redirect:/list";
		
	}
	@GetMapping("/list")
	public String viewStudent(Model model) throws SQLException{
		List<Student> students = studentDAO.findAll();
		model.addAttribute("students",students);
		return "list";
	}

}
