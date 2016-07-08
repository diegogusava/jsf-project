package br.com.diegogusava.repository;

import br.com.diegogusava.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRespository {

    void salvar(Usuario usuario);

    void remover(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    List<Usuario> listarTodos();
}
