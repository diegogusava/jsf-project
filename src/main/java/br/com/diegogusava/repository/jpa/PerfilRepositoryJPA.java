package br.com.diegogusava.repository.jpa;

import br.com.diegogusava.model.Perfil;
import br.com.diegogusava.repository.PerfilRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class PerfilRepositoryJPA implements PerfilRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Perfil> listarTodos() {
        return entityManager.createNamedQuery("Perfil.listarTodos", Perfil.class).getResultList();
    }

    public Optional<Perfil> buscarPorId(Long id) {
        return entityManager.createNamedQuery("Perfil.buscarPorId", Perfil.class).setParameter("id", id)
                .getResultList().stream().findFirst();
    }

}
