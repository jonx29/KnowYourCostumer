package controller;

import dao.Ciudad;
import dao.Calle;
import dao.CargoPolitico;
import java.util.List;
import facade.CiudadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @Inject
    private ProvinciaController codProvinciaController;

    // Flags to indicate if child collections are empty
    private boolean isCalleListEmpty;
    private boolean isCargoPoliticoListEmpty;

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codProvinciaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCalleListEmpty();
        this.setIsCargoPoliticoListEmpty();
    }

    public boolean getIsCalleListEmpty() {
        return this.isCalleListEmpty;
    }

    private void setIsCalleListEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isCalleListEmpty = ejbFacade.isCalleListEmpty(selected);
        } else {
            this.isCalleListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Calle entities that are
     * retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Calle page
     */
    public String navigateCalleList() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<Calle> selectedCalleList = ejbFacade.findCalleList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Calle_items", selectedCalleList);
        }
        return "/app/calle/index";
    }

    public boolean getIsCargoPoliticoListEmpty() {
        return this.isCargoPoliticoListEmpty;
    }

    private void setIsCargoPoliticoListEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isCargoPoliticoListEmpty = ejbFacade.isCargoPoliticoListEmpty(selected);
        } else {
            this.isCargoPoliticoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CargoPolitico entities
     * that are retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for CargoPolitico page
     */
    public String navigateCargoPoliticoList() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<CargoPolitico> selectedCargoPoliticoList = ejbFacade.findCargoPoliticoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargoPolitico_items", selectedCargoPoliticoList);
        }
        return "/app/cargoPolitico/index";
    }

    /**
     * Sets the "selected" attribute of the Provincia controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodProvincia(ActionEvent event) {
        Ciudad selected = this.getSelected();
        if (selected != null && codProvinciaController.getSelected() == null) {
            codProvinciaController.setSelected(selected.getCodProvincia());
        }
    }

}
