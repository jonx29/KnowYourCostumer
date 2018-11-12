package controller;

import dao.TipoCargoPolitico;
import dao.CargoPolitico;
import java.util.List;
import facade.TipoCargoPoliticoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCargoPoliticoController")
@ViewScoped
public class TipoCargoPoliticoController extends AbstractController<TipoCargoPolitico> {

    // Flags to indicate if child collections are empty
    private boolean isCargoPoliticoListEmpty;

    public TipoCargoPoliticoController() {
        // Inform the Abstract parent controller of the concrete TipoCargoPolitico Entity
        super(TipoCargoPolitico.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCargoPoliticoListEmpty();
    }

    public boolean getIsCargoPoliticoListEmpty() {
        return this.isCargoPoliticoListEmpty;
    }

    private void setIsCargoPoliticoListEmpty() {
        TipoCargoPolitico selected = this.getSelected();
        if (selected != null) {
            TipoCargoPoliticoFacade ejbFacade = (TipoCargoPoliticoFacade) this.getFacade();
            this.isCargoPoliticoListEmpty = ejbFacade.isCargoPoliticoListEmpty(selected);
        } else {
            this.isCargoPoliticoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CargoPolitico entities
     * that are retrieved from TipoCargoPolitico and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CargoPolitico page
     */
    public String navigateCargoPoliticoList() {
        TipoCargoPolitico selected = this.getSelected();
        if (selected != null) {
            TipoCargoPoliticoFacade ejbFacade = (TipoCargoPoliticoFacade) this.getFacade();
            List<CargoPolitico> selectedCargoPoliticoList = ejbFacade.findCargoPoliticoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargoPolitico_items", selectedCargoPoliticoList);
        }
        return "/app/cargoPolitico/index";
    }

}
