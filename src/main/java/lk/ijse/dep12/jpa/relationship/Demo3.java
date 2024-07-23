package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class Demo3 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            try {
                em.getTransaction().begin();

                Student student = new Student("S003", "Kasun", "Sampath", "Colombo", "077-123443123", Date.valueOf("1998-01-01"));
                Course course = new Course("C003", "GDSE", "24-Months");
                StudentCourse sc001 = new StudentCourse("Tharindu", Date.valueOf(LocalDate.now()),course, student);

                em.persist(student);
                em.persist(course);
                em.persist(sc001);
                em.getTransaction().commit();
            } catch (Throwable throwable) {
                em.getTransaction().rollback();
                throwable.printStackTrace();
            }
        }

    }
}
