package br.com.diegogusava.service;

import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.repository.UsuarioRespository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class UsuarioService implements Serializable {

    @Inject
    private UsuarioRespository respository;

    public void salvar(Usuario usuario) {
        respository.salvar(usuario);
    }

    public void remover(Usuario usuario) {
        respository.remover(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return respository.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return respository.listarTodos();
    }

}
