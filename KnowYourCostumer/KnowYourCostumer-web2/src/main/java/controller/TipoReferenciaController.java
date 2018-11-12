package controller;

import dao.TipoReferencia;
import dao.Referencia;
import java.util.List;
import facade.TipoReferenciaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoReferenciaController")
@ViewScoped
public class TipoReferenciaController extends AbstractController<TipoReferencia> {

    // Flags to indicate if child collections are empty
    private boolean isReferenciaListEmpty;

    public TipoReferenciaController() {
        // Inform the Abstract parent controller of the concrete TipoReferencia Entity
        super(TipoReferencia.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsReferenciaListEmpty();
    }

    public boolean getIsReferenciaListEmpty() {
        return this.isReferenciaListEmpty;
    }

    private void setIsReferenciaListEmpty() {
        TipoReferencia selected = this.getSelected();
        if (selected != null) {
            TipoReferenciaFacade ejbFacade = (TipoReferenciaFacade) this.getFacade();
            this.isReferenciaListEmpty = ejbFacade.isReferenciaListEmpty(selected);
        } else {
            this.isReferenciaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Referencia entities that
     * are retrieved from TipoReferencia and returns the navigation outcome.
     *
     * @return navigation outcome for Referencia page
     */
    public String navigateReferenciaList() {
        TipoReferencia selected = this.getSelected();
        if (selected != null) {
            TipoReferenciaFacade ejbFacade = (TipoReferenciaFacade) this.getFacade();
            List<Referencia> selectedReferenciaList = ejbFacade.findReferenciaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Referencia_items", selectedReferenciaList);
        }
        return "/app/referencia/index";
    }

}
