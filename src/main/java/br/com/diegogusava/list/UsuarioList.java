package br.com.diegogusava.list;

import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.service.UsuarioService;
import com.google.common.collect.ImmutableMap;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
@URLMapping(id = "usuario", pattern = "/usuarios", viewId = "/faces/usuario/listar.xhtml")
@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UsuarioList implements Serializable {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Inject
    private UsuarioService usuarioService;

    private Long usuarioId;

    private String login;

    private List<Usuario> usuarios;

    private Map<Usuario, Boolean> itens = new HashMap<>();

    private Boolean existeSelecionado;

    @URLAction(mappingId = "usuario", onPostback = false)
    public void init(){
        this.usuarios = entityManager.createNamedQuery("Usuario.listarTodos", Usuario.class).getResultList();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Map<Usuario, Boolean> getItens() {
        return itens;
    }

    public void setItens(Map<Usuario, Boolean> itens) {
        this.itens = itens;
    }

    public void prepararParaRemover(){
        existeSelecionado = false;
        for (Map.Entry<Usuario, Boolean> entry : itens.entrySet()) {
            if(entry.getValue()){
                existeSelecionado = true;
            }
        }

        if(!existeSelecionado){
            Messages.addGlobalInfo("Selecione pelo menos um registro para excluir");
        }
    }

    public void remover() {
        for (Map.Entry<Usuario, Boolean> entry : ImmutableMap.copyOf(itens).entrySet()) {
            if (entry.getValue()) {
                usuarioService.remover(entry.getKey());
                usuarios.remove(entry.getKey());
                itens.remove(entry.getKey());
            }
        }
    }
}
