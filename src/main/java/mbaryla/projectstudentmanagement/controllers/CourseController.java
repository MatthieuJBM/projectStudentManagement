package mbaryla.projectstudentmanagement.controllers;

import mbaryla.projectstudentmanagement.data.CourseRepository;
import mbaryla.projectstudentmanagement.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/addCourseForm")
    public String addCourseForm(Model model) {
        Course newCourse = new Course();
        model.addAttribute("course", newCourse);
        model.addAttribute("courses", courseRepository.findAll());
        return "add-course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute Course course){
        courseRepository.save(course);
        return "redirect:/addCourseForm";
    }

    @GetMapping("/showUpdateCourseForm")
    public String showUpdateCourseForm(@RequestParam Long courseId, Model model){
        Course course = courseRepository.findById(courseId).get();
        model.addAttribute("course", course);
        return "redirect:/addCourseForm";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam Long courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/addCourseForm";
    }

}
