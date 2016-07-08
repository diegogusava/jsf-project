package br.com.diegogusava.repository;

import br.com.diegogusava.model.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilRepository {

    List<Perfil> listarTodos();

    Optional<Perfil> buscarPorId(Long id);

}
