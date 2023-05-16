package mbaryla.projectstudentmanagement.data;

import mbaryla.projectstudentmanagement.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
