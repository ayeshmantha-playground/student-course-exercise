//package lk.ijse.dep12.jpa.relationship;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import lk.ijse.dep12.jpa.relationship.entity.Course;
//import lk.ijse.dep12.jpa.relationship.entity.Student;
//import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
//import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//public class Demo1 {
//    public static void main(String[] args) {
//        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
//             EntityManager em = emf.createEntityManager()) {
//
//            try {
//                em.getTransaction().begin();
//
//                Student student = new Student("S001", "Kasun", "Sampath", "Colombo", "077-123443123", Date.valueOf("1998-01-01"));
//                Course course = new Course("C001", "DEP", "6-Months");
//                StudentCourse sc001 = new StudentCourse(student, course, "Tharindu", Date.valueOf(LocalDate.now()));
//
//                em.persist(student);
//                em.persist(course);
//                em.persist(sc001);
//                em.getTransaction().commit();
//            } catch (Throwable throwable) {
//                em.getTransaction().rollback();
//                throwable.printStackTrace();
//            }
//        }
//
//    }
//}
