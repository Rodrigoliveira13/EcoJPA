package br.com.ecomanager.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.ecomanager.dao.UsuarioDAO;
import br.com.ecomanager.model.Usuario;

@ManagedBean
public class UsuarioBean {
	UsuarioDAO uDao;
	private Usuario usuario = new Usuario();
	private List <Usuario> usuarios;
	
		public UsuarioBean(UsuarioDAO uDao, Usuario usuario, List<Usuario> usuarios) {
		super();
		this.uDao = uDao;
		this.usuario = usuario;
		this.usuarios = usuarios;
	}
		public UsuarioBean() {
			
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		
		public void cadastrarUsuario() {
			uDao = new UsuarioDAO();
			uDao.salvar(usuario);
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuario cadastrado"));
		}
		
		public void buscarPorId() {
			uDao = new UsuarioDAO();
			Usuario uBusca = uDao.buscarPorId(usuario.getId());
			usuario = uBusca;
			if(uBusca == null) {
				FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuario não encontrado"));
			}
		}
		public void removerPorId() {
			uDao = new UsuarioDAO();
			Usuario uBusca = uDao.buscarPorId(usuario.getId());
			usuario = uBusca;
			if (uBusca == null) {
				FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário não existe"));
			}else {
				uDao.remover(usuario.getId());
				FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário removido"));
			}
		}

}
