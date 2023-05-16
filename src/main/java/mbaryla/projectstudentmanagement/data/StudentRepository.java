package mbaryla.projectstudentmanagement.data;

import mbaryla.projectstudentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
