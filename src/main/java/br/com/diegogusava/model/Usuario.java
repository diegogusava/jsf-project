package br.com.diegogusava.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@NamedQueries({
        @NamedQuery(name = "Usuario.buscarPorId", query = "SELECT u FROM Usuario u WHERE u.id = :usuarioId"),
        @NamedQuery(name = "Usuario.listarTodos", query = "SELECT u FROM Usuario u")
})
@Table
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String login;

    @NotNull
    private String password;

    private String nome;

    @ManyToOne
    @JoinColumn
    private Perfil perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(this.login, usuario.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.login);
    }
}
