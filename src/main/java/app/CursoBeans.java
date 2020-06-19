package app;

import infra.Curso;
import infra.JPAUtils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@ManagedBean
@SessionScoped
public class CursoBeans {
    private Curso c = new Curso();
    private List<Curso> cursos = new ArrayList<Curso>();
    public CursoBeans() {
    }

    public Curso getC() {
        return c;
    }

    public void setC(Curso c) {
        this.c = c;
    }
    
public String salvar() {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(c);
        et.commit();
        em.close();
        c = new Curso();
        return "cadCurso";
    }

    public void excluir(Curso c) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        c = em.merge(c);
        em.remove(c);
        et.commit();
        em.close();
    }

    public void selecionar(Curso c) {
        this.c = c;
    }

    public List<Curso> getCursos() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select c from Curso c", Curso.class);
        List<Curso> ps = q.getResultList();
        em.close();
        return ps;
    }
    
    public String consultarPorTitulo(int titulo) {
        String retorno = "";
        String consulta = "SELECT c FROM Curso c WHERE c.titulo = :titulo";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("titulo", c.getTitulo());
        for (Curso funci : query.getResultList()) {
            if (funci.getTitulo().equals(c.getTitulo())) {
                retorno = "consultaResultTitulo";
            }
        }
        return retorno;
    }

    public List<Curso> getCursoTitulo() {
        List<Curso> cursos = null;
        String consulta = "SELECT c FROM Curso c WHERE c.titulo = :titulo";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("titulo", c.getTitulo());
        for (Curso funci : query.getResultList()) {
            if (funci.getTitulo().equals(c.getTitulo())) {
                cursos = query.getResultList();
            }
        }
        return cursos;

    }

    public String consultarPorId(int id) {
        String retorno = "";
        String consulta = "SELECT c FROM Curso c WHERE c.idcurso = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("id", c.getIdcurso());
        for (Curso funci : query.getResultList()) {
            if (funci.getIdcurso().equals(c.getIdcurso())) {
                retorno = "consultaResultID";
            }
        }
        return retorno;
    }

    public List<Curso> getCursoId() {
        List<Curso> cursos = null;
        String consulta = "SELECT c FROM Curso c WHERE c.idcurso = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("id", c.getIdcurso());
        for (Curso funci : query.getResultList()) {
            if (funci.getIdcurso().equals(c.getIdcurso())) {
                cursos = query.getResultList();
            }
        }
        return cursos;

    }
}
