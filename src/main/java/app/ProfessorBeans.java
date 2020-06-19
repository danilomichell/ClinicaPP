package app;

import infra.JPAUtils;
import infra.Professor;
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
public class ProfessorBeans {

    private Professor p = new Professor();
    private FolhaBeans fl = new FolhaBeans();
    private List<Professor> professorer = new ArrayList<Professor>();

    public ProfessorBeans() {
    }

    public Professor getP() {
        return p;
    }

    public void setP(Professor p) {
        this.p = p;
    }

    public void excluir(Professor p) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        p = em.merge(p);
        em.remove(p);
        et.commit();
        em.close();
    }

    public String salvarPaciente() {
        p.setCargo("Professor");
        fl.setSalarioBruto(p.getSalariobruto());
        p.setSalarioliquido(fl.getSalarioliquido());
        p.setIrrf(fl.getIrrf());
        p.setInss(fl.getInss());
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(p);
        et.commit();
        em.close();
        p = new Professor();
        fl = new FolhaBeans();
        return "cadProfessor";

    }

    public void selecionar(Professor p) {
        this.p = p;
    }

    public List<Professor> getProfessor() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select p from Professor p", Professor.class);
        List<Professor> ps = q.getResultList();
        em.close();
        return ps;
    }

    public String consultarPorNome(int nome) {
        String retorno = "";
        String consulta = "select p from Professor p WHERE p.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("nome", p.getNome());
        for (Professor funci : query.getResultList()) {
            if (funci.getNome().equals(p.getNome())) {
                retorno = "consultaResultNome";
            }
        }
        return retorno;
    }

    public List<Professor> getProfessorNome() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("nome", p.getNome());
        for (Professor funci : query.getResultList()) {
            if (funci.getNome().equals(p.getNome())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

    public String consultarPorId(int id) {
        String retorno = "";
        String consulta = "SELECT p FROM Professor p WHERE p.id = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("id", p.getId());
        for (Professor funci : query.getResultList()) {
            if (funci.getId().equals(p.getId())) {
                retorno = "consultaResultId";
            }
        }
        return retorno;
    }

    public List<Professor> getProfessorId() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.id = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("id", p.getId());
        for (Professor funci : query.getResultList()) {
            if (funci.getId().equals(p.getId())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }
    
    
    public String consultarPorDisciplina(int disciplina) {
        String retorno = "";
        String consulta = "select p from Professor p WHERE p.disciplina = :disciplina";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("disciplina", p.getDisciplina());
        for (Professor funci : query.getResultList()) {
            if (funci.getDisciplina().equals(p.getDisciplina())) {
                retorno = "consultaResultDisciplina";
            }
        }
        return retorno;
    }

    public List<Professor> getProfessorDisciplina() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.disciplina = :disciplina";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("disciplina", p.getDisciplina());
        for (Professor funci : query.getResultList()) {
            if (funci.getDisciplina().equals(p.getDisciplina())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

    public String consultarPorAreaInteresse(int areaInteresse) {
        String retorno = "";
        String consulta = "SELECT p FROM Professor p WHERE p.areaInteresse = :areaInteresse";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("areaInteresse", p.getAreaInteresse());
        for (Professor funci : query.getResultList()) {
            if (funci.getAreaInteresse().equals(p.getAreaInteresse())) {
                retorno = "consultaResultId";
            }
        }
        return retorno;
    }

    public List<Professor> getProfessorAreaInteresse() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.areaInteresse = :areaInteresse";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("areaInteresse", p.getAreaInteresse());
        for (Professor funci : query.getResultList()) {
            if (funci.getAreaInteresse().equals(p.getAreaInteresse())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }
}
