package mbaryla.projectstudentmanagement.controllers;

import mbaryla.projectstudentmanagement.data.CourseRepository;
import mbaryla.projectstudentmanagement.data.EnrollmentRepository;
import mbaryla.projectstudentmanagement.data.StudentRepository;
import mbaryla.projectstudentmanagement.model.Course;
import mbaryla.projectstudentmanagement.model.Enrollment;
import mbaryla.projectstudentmanagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnrollmentController {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/addEnrollmentForm")
    public String addEnrollmentForm(Model model){

        Student newStudent = new Student();
        model.addAttribute("student", newStudent);
        model.addAttribute("students", studentRepository.findAll());

        Course newCourse = new Course();
        model.addAttribute("course", newCourse);
        model.addAttribute("courses", courseRepository.findAll());

        Enrollment newEnrollment = new Enrollment();
        model.addAttribute("enrollment", newEnrollment);
        model.addAttribute("enrollments", enrollmentRepository.findAll());
        return "add-enrollment-form";
    }

    @PostMapping("/saveEnrollment")
    public String saveEnrollment(@RequestParam("studentId") Long studentId,
                                 @RequestParam("courseId") Long courseId,
                                 @RequestParam("grade") Enrollment.Grade grade) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + courseId));
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setGrade(Enrollment.Grade.valueOf(String.valueOf(grade)));
        student.getEnrollments().add(enrollment);
        //studentRepository.save(student);
        enrollmentRepository.save(enrollment);

        return "redirect:/addEnrollmentForm";
    }




    /*
    @PostMapping("/saveEnrollment")
    public String saveEnrollment(@RequestParam Long studentId, Model model) {
        enrollmentRepository.save(enrollment);
        student.getEnrollments().add(enrollment);

        return "redirect:/addEnrollmentForm";
    }
    */
}
