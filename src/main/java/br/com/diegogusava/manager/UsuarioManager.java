package br.com.diegogusava.manager;

import br.com.diegogusava.model.Perfil;
import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.service.PerfilService;
import br.com.diegogusava.service.UsuarioService;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.omnifaces.util.Messages;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@URLMappings(mappings = {
        @URLMapping(id = "usuario-criar", pattern = "/usuarios/criar", viewId = "/faces/usuario/editar.xhtml"),
        @URLMapping(id = "usuario-editar", pattern = "/usuarios/editar/#{id : usuarioManager.usuarioId}", viewId = "/faces/usuario/editar.xhtml")
})
@Named
@ConversationScoped
public class UsuarioManager implements Serializable {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private PerfilService perfilService;

    @Inject
    private Conversation conversation;

    private Usuario usuario;

    private Long usuarioId = 0l;

    @URLAction(mappingId = "usuario-criar", onPostback = false)
    public void criar() {
        conversation.begin();
        usuario = new Usuario();
    }

    @URLAction(mappingId = "usuario-editar", onPostback = false)
    public void editar() {
        conversation.begin();
        usuario = usuarioService.buscarPorId(usuarioId).or(new Usuario());
    }

    public String salvar() {
        usuarioService.salvar(usuario);
        conversation.end();
        return "pretty:usuario";
    }

    public List<Perfil> listarPerfis(){
        return perfilService.listarTodos();
    }

    public void deletar(Usuario usuario) {
        usuarioService.remover(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }


}
