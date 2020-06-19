package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}