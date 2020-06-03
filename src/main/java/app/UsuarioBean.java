package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import infra.Usuario;
import infra.TesteJPA;

@ManagedBean
@SessionScoped
public class UsuarioBean {

    private String login, senha;

    public UsuarioBean() {
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
        UsuarioBean user = new UsuarioBean();
        user.setLogin(this.login);
        user.setSenha(this.senha);
        TesteJPA.cadastrar(user);
        return "dashboard";
    }
    public String logar(){
        return "dashboard";
    }
}
