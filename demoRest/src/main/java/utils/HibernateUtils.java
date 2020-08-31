package utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager em = emf.createEntityManager();
        return em;
    }

    public static void main(String[] args) {
       if(getEntityManager() != null){
           System.out.println("done");
       };
    }
}
