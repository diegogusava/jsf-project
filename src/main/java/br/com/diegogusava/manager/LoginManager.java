package br.com.diegogusava.manager;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Named;
import java.io.Serializable;

@URLMapping(id = "login", pattern = "/login" , viewId = "/faces/login.xhtml")
@ViewScoped
@Named
public class LoginManager implements Serializable {

    private String email;
    private String senha;

    public String action() {
        return "pretty:usuario";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
