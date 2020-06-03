package infra;

import app.UsuarioBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
 
public class TesteJPA {

    public static void main(String[] args) {

    }

    public static void cadastrar(UsuarioBean userBean) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Usuario user = new Usuario();
        user.setLogin(userBean.getLogin());
        user.setSenha(userBean.getSenha());
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
        emf.close();
    }
}
