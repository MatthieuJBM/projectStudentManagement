package mbaryla.projectstudentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, message="Name must be at least 2 characters long")
    private String firstName;

    @NotNull
    @Size(min=2, message="Last Name must be at least 2 characters long")
    private String lastName;

    @NotNull(message="E-Mail address cannot be null")
    @Email
    private String email;

    @NotNull(message="Enrollment date cannot be null")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();



}
