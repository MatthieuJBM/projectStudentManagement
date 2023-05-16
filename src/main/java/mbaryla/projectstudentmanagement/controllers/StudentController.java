package mbaryla.projectstudentmanagement.controllers;

import mbaryla.projectstudentmanagement.data.StudentRepository;
import mbaryla.projectstudentmanagement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private List<Enrollment> enrollments;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "list-students";
    }

    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model) {
        Student newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "add-student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/showUpdateStudentForm")
    public String showUpdateStudentForm(@RequestParam Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).get();
        model.addAttribute("student", student);
        return "add-student-form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Long studentId) {
        studentRepository.deleteById(studentId);
        return "redirect:/students";
    }

    /*
    @GetMapping("/addEnrollment")
    public String addEnrollment(@RequestParam Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).get();
        Enrollment enrollment = new Enrollment();
        model.addAttribute("student", student);
        model.addAttribute("enrollment", enrollment);
        return "add-enrollment-form";
    }
    */






}
