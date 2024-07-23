package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentCoursePK.class)
@Entity
@Table(name = "student_course")
public class StudentCourse  implements Serializable {

    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_code " ,referencedColumnName = "code")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


}
