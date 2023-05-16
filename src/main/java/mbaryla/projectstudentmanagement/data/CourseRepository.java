package mbaryla.projectstudentmanagement.data;

import mbaryla.projectstudentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
