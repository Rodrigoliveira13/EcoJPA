package br.com.ecomanager.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ecomanager.dao.UsuarioDAO;
import br.com.ecomanager.model.Usuario;
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario ();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String efetuarLogin() {
		Usuario usuario = new UsuarioDAO().realizarLogin(this.usuario);
		if (usuario != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			System.out.println("Sessão Usuario: " + usuario.getNome());
			return "listarConsumo?faces-redirect=true";
		}
		return "login?faces-redirect=true";
		
	}
	public String efetuarLogout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}

}
