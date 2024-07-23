package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class HelloJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {

            try {
                em.getTransaction().begin();
                System.out.println("EMF: " + emf);
                System.out.println("EM: " + em);

                em.getTransaction().commit();
            } catch (Throwable throwable) {
                em.getTransaction().rollback();
                throwable.printStackTrace();
            }
        }

    }
}
