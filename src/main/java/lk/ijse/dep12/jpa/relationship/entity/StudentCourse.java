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
@Entity
@Table(name = "student_course")
public class StudentCourse  implements Serializable {

    @EmbeddedId
    private StudentCoursePK studentCoursePK;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @MapsId("studentId")
//    @JoinColumn(name = "course_code", referencedColumnName = "code" ,insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @MapsId("courseId")
//    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

//    public StudentCourse(StudentCoursePK studentCoursePK, String registeredBy, Date date) {
//        this.studentCoursePK = studentCoursePK;
//        this.registeredBy = registeredBy;
//        this.date = date;
//    }

    public StudentCourse(Student student,Course course, String registeredBy, Date date) {
        this.studentCoursePK = new StudentCoursePK(student.getId(), course.getCode());
        this.student = student;
        this.course = course;
        this.registeredBy = registeredBy;
        this.date = date;
    }

}
