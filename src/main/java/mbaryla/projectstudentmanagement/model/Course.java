package mbaryla.projectstudentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @NaturalId
    @NotNull(message="Course id cannot be null")
    @Digits(integer=10, fraction=0, message="Number must be a valid whole number")
    private Long courseId;

    @NotNull
    @Size(min=3, message="Course name must be at least 3 characters long.")
    private String courseName;

    @NotNull(message="ECTS can't be null")
    @Digits(integer=2, fraction=0, message="ECTS points must be a whole number containing 2 digits.")
    private int credits;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();


}
