package br.com.ecomanager.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizacao implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent evento) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String pagina = context.getViewRoot().getViewId();
		
		if(pagina.equals("/login.xhtml")) {
			return;
		}
		
		if(context.getExternalContext().getSessionMap().get("usuarioLogado")!= null) {
			return;
		}
		
		NavigationHandler navigation = context.getApplication().getNavigationHandler();
		navigation.handleNavigation(context, null, "login?faces-redirect=true");
		
		System.out.println("Aqui");
		
		context.setCurrentPhaseId(PhaseId.RENDER_RESPONSE);
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	

}
