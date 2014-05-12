package br.com.diegogusava.converter;

import br.com.diegogusava.model.Usuario;
import br.com.diegogusava.service.UsuarioService;
import com.google.common.base.Optional;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{

    @Resource
    private SessionContext sessionContext;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Long id = Long.valueOf(s);
        final UsuarioService usuarioService = this.sessionContext.getBusinessObject(UsuarioService.class);
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.orNull();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Usuario usuario = (Usuario) o;

        if (usuario == null) {
            return null;
        }

        return usuario.getLogin();
    }
}
