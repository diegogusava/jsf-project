package br.com.diegogusava.service;

import br.com.diegogusava.model.Perfil;
import com.google.common.base.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerfilService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Perfil> listarTodos() {
        return entityManager.createNamedQuery("Perfil.listarTodos", Perfil.class).getResultList();
    }

    public Optional<Perfil> buscarPorId(Long id) {
        List<Perfil> lista = entityManager.createNamedQuery("Perfil.buscarPorId", Perfil.class).setParameter("id", id).getResultList();
        if (lista.isEmpty()) {
            return Optional.absent();
        } else {
            return Optional.of(lista.get(0));
        }
    }


}
