package app;

import infra.Funcionario;
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
public class FuncionarioBeans {

    private Funcionario f = new Funcionario();
    private FolhaBeans fl = new FolhaBeans();
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public FuncionarioBeans() {
    }

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }

    public void excluir(Funcionario f) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        f = em.merge(f);
        em.remove(f);
        et.commit();
        em.close();
    }

    public String salvarPaciente() {
        fl.setSalarioBruto(f.getSalariobruto());
        f.setSalarioliquido(fl.getSalarioliquido());
        f.setIrrf(fl.getIrrf());
        f.setInss(fl.getInss());
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(f);
        et.commit();
        em.close();
        f = new Funcionario();
        fl = new FolhaBeans();
        return "cadFuncionario";

    }

    public List<Funcionario> getFuncionarios() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select f from Funcionario f", Funcionario.class);
        List<Funcionario> ps = q.getResultList();
        em.close();
        return ps;
    }

    public void selecionar(Funcionario f) {
        this.f = f;
    }

    public FolhaBeans getFl() {
        return fl;
    }

    public void setFl(FolhaBeans fl) {
        this.fl = fl;
    }

    public String consultarPorNome(int nome) {
        String retorno = "";
        String consulta = "SELECT f FROM Funcionario f WHERE f.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("nome", f.getNome());
        for (Funcionario funci : query.getResultList()) {
            if (funci.getNome().equals(f.getNome())) {
                retorno = "consultaResultNome";
            }
        }
        return retorno;
    }

    public List<Funcionario> getFuncionarioNome() {
        List<Funcionario> funcionarios = null;
        String consulta = "SELECT f FROM Funcionario f WHERE f.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("nome", f.getNome());
        for (Funcionario funci : query.getResultList()) {
            if (funci.getNome().equals(f.getNome())) {
                funcionarios = query.getResultList();
            }
        }
        return funcionarios;

    }

    public String consultarPorId(int id) {
        String retorno = "";
        String consulta = "SELECT f FROM Funcionario f WHERE f.id = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("id", f.getId());
        for (Funcionario funci : query.getResultList()) {
            if (funci.getId().equals(f.getId())) {
                retorno = "consultaResultId";
            }
        }
        return retorno;
    }

    public List<Funcionario> getFuncionarioId() {
        List<Funcionario> funcionarios = null;
        String consulta = "SELECT f FROM Funcionario f WHERE f.id = :id";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("id", f.getId());
        for (Funcionario funci : query.getResultList()) {
            if (funci.getId().equals(f.getId())) {
                funcionarios = query.getResultList();
            }
        }
        return funcionarios;

    }
}
