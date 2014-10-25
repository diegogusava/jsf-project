package br.com.diegogusava.service;

import br.com.diegogusava.model.Usuario;
import com.google.common.base.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UsuarioService implements Serializable {

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
        entityManager.remove(usuario);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Optional<Usuario> buscarPorId(Long id) {
        List<Usuario> resultList = entityManager.createNamedQuery("Usuario.buscarPorId", Usuario.class).setParameter("usuarioId", id).getResultList();
        if (resultList.isEmpty()) {
            return Optional.absent();
        }
        return Optional.of(resultList.get(0));
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuario> listarTodos() {
        return entityManager.createNamedQuery("Usuario.listarTodos", Usuario.class).getResultList();
    }

}
