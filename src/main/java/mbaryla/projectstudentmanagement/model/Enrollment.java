package mbaryla.projectstudentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrollments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    public enum Grade {
        A, B, C, D, E, F
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Long courseId;

    @Transient
    private int studentId;

    @Enumerated(EnumType.ORDINAL)
    private Grade grade;

    @NotNull
    @ManyToOne
    private Student student;

    @NotNull
    @ManyToOne
    private Course course;


}
