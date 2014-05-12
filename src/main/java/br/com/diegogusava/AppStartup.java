package br.com.diegogusava;

import br.com.diegogusava.model.Papel;
import br.com.diegogusava.model.Perfil;
import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.service.UsuarioService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class AppStartup {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void inserir() {

        Perfil admin = new Perfil("Admin");
        entityManager.persist(admin);
        Papel papel1 = new Papel("Papel Admin 1", admin);
        entityManager.persist(papel1);
        Papel papel2 = new Papel("Papel Admin 2", admin);
        entityManager.persist(papel2);
        Papel papel3 = new Papel("Papel Admin 3", admin);
        entityManager.persist(papel3);
        Papel papel4 = new Papel("Papel Admin 4", admin);
        entityManager.persist(papel4);

        Perfil usuario = new Perfil("Usuário");
        entityManager.persist(usuario);
        Papel papel5 = new Papel("Papel Usuário 1", usuario);
        entityManager.persist(papel5);
        Papel papel6 = new Papel("Papel Usuário 2", usuario);
        entityManager.persist(papel6);
        Papel papel7 = new Papel("Papel Usuário 3", usuario);
        entityManager.persist(papel7);
        Papel papel8 = new Papel("Papel Usuário 4", usuario);
        entityManager.persist(papel8);

        for (int i = 0; i < 100; i++) {
            Usuario user = new Usuario();
            user.setLogin("Usuario " + i);
            user.setPassword(String.valueOf(i));
            if (i % 2 == 0) {
                user.setPerfil(admin);
            } else {
                user.setPerfil(usuario);
            }
            entityManager.persist(user);
        }

    }

}
