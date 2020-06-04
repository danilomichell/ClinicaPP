package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import infra.Usuario;
import infra.TesteJPA;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class UsuarioBean {

    private String login, senha;
    private Usuario user = new Usuario();

    public UsuarioBean() {
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String cadastrar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
        emf.close();
        return "dashboard";
    }

    public String logar() {
        return "dashboard";
    }
}
