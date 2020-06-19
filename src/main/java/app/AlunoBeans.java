package app;

import infra.Aluno;
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
public class AlunoBeans {

    private Aluno a = new Aluno();
    private NotasBeans n = new NotasBeans();
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public AlunoBeans() {
    }

    public Aluno getA() {
        return a;
    }

    public void setA(Aluno a) {
        this.a = a;
    }

    public NotasBeans getN() {
        return n;
    }

    public void setN(NotasBeans n) {
        this.n = n;
    }

    public String salvar() {
        n.setNota1(a.getNota1());
        n.setNota2(a.getNota2());
        n.setNota3(a.getNota3());
        n.setNota4(a.getNota4());
        a.setNotaFinal(n.getNotaFinal());
        a.setStatus(n.getStatus());
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(a);
        et.commit();
        em.close();
        a = new Aluno();
        return "cadAluno";
    }

    public void excluir(Aluno a) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        a = em.merge(a);
        em.remove(a);
        et.commit();
        em.close();
    }

    public void selecionar(Aluno a) {
        this.a = a;
    }

    public List<Aluno> getAlunos() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select a from Aluno a", Aluno.class);
        List<Aluno> ps = q.getResultList();
        em.close();
        return ps;
    }

    public String consultarPorNome(int nome) {
        String retorno = "";
        String consulta = "SELECT a FROM Aluno a WHERE a.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("nome", a.getNome());
        for (Aluno funci : query.getResultList()) {
            if (funci.getNome().equals(a.getNome())) {
                retorno = "consultaResultNome";
            }
        }
        return retorno;
    }

    public List<Aluno> getAlunoNome() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.nome = :nome";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("nome", a.getNome());
        for (Aluno funci : query.getResultList()) {
            if (funci.getNome().equals(a.getNome())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

    public String consultarPorCpf(String cpf) {
        String retorno = "";
        String consulta = "SELECT a FROM Aluno a WHERE a.cpf = :cpf";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("cpf", a.getCpf());
        for (Aluno funci : query.getResultList()) {
            if (funci.getCpf().equals(a.getCpf())) {
                retorno = "consultaResultCpf";
            }
        }
        return retorno;
    }

    public List<Aluno> getAlunoCpf() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.cpf = :cpf";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("cpf", a.getCpf());
        for (Aluno funci : query.getResultList()) {
            if (funci.getCpf().equals(a.getCpf())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

    public String consultarPorDataNascimento(String dataNascimento) {
        String retorno = "";
        String consulta = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("dataNascimento", a.getDataNascimento());
        for (Aluno funci : query.getResultList()) {
            if (funci.getDataNascimento().equals(a.getDataNascimento())) {
                retorno = "consultaResultDataNascimento";
            }
        }
        return retorno;
    }

    public List<Aluno> getAlunoDataNascimento() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("dataNascimento", a.getDataNascimento());
        for (Aluno funci : query.getResultList()) {
            if (funci.getDataNascimento().equals(a.getDataNascimento())) {
                alunos = query.getResultList();
            }
        }
        return alunos;
    }

    public String consultarPorStatus(String status) {
        String retorno = "";
        String consulta = "SELECT a FROM Aluno a WHERE a.status = :status";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("status", a.getStatus());
        for (Aluno funci : query.getResultList()) {
            if (funci.getStatus().equals(a.getStatus())) {
                retorno = "consultaResultStatus";
            }
        }
        return retorno;
    }

    public List<Aluno> getAlunoStatus() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.status = :status";
        EntityManager em = JPAUtils.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("status", a.getStatus());
        for (Aluno funci : query.getResultList()) {
            if (funci.getStatus().equals(a.getStatus())) {
                alunos = query.getResultList();
            }
        }
        return alunos;
    }
}
