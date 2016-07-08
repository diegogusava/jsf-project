package br.com.diegogusava.repository.jpa;

import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.repository.UsuarioRespository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class UsuarioRespositoryJPA implements UsuarioRespository {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            entityManager.persist(usuario);
        } else {
            entityManager.merge(usuario);
        }
    }

    public void remover(Usuario usuario) {
        entityManager.remove(entityManager.merge(usuario));
    }

    public Optional<Usuario> buscarPorId(Long id) {
        List<Usuario> resultList = entityManager.createNamedQuery("Usuario.buscarPorId", Usuario.class).setParameter("usuarioId", id).getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(resultList.get(0));
    }

    public List<Usuario> listarTodos() {
        return entityManager.createNamedQuery("Usuario.listarTodos", Usuario.class)
                .getResultList();
    }
}
