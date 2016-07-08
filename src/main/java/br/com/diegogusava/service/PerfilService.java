package br.com.diegogusava.service;

import br.com.diegogusava.model.Perfil;
import br.com.diegogusava.repository.PerfilRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class PerfilService implements Serializable {

    @Inject
    private PerfilRepository repository;

    public List<Perfil> listarTodos() {
        return repository.listarTodos();
    }

    public Optional<Perfil> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

}
