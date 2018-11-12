package controller;

import dao.Provincia;
import dao.Ciudad;
import java.util.List;
import facade.ProvinciaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "provinciaController")
@ViewScoped
public class ProvinciaController extends AbstractController<Provincia> {

    @Inject
    private PaisController codPaisController;

    // Flags to indicate if child collections are empty
    private boolean isCiudadListEmpty;

    public ProvinciaController() {
        // Inform the Abstract parent controller of the concrete Provincia Entity
        super(Provincia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codPaisController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCiudadListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodPais(ActionEvent event) {
        Provincia selected = this.getSelected();
        if (selected != null && codPaisController.getSelected() == null) {
            codPaisController.setSelected(selected.getCodPais());
        }
    }

    public boolean getIsCiudadListEmpty() {
        return this.isCiudadListEmpty;
    }

    private void setIsCiudadListEmpty() {
        Provincia selected = this.getSelected();
        if (selected != null) {
            ProvinciaFacade ejbFacade = (ProvinciaFacade) this.getFacade();
            this.isCiudadListEmpty = ejbFacade.isCiudadListEmpty(selected);
        } else {
            this.isCiudadListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ciudad entities that are
     * retrieved from Provincia and returns the navigation outcome.
     *
     * @return navigation outcome for Ciudad page
     */
    public String navigateCiudadList() {
        Provincia selected = this.getSelected();
        if (selected != null) {
            ProvinciaFacade ejbFacade = (ProvinciaFacade) this.getFacade();
            List<Ciudad> selectedCiudadList = ejbFacade.findCiudadList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ciudad_items", selectedCiudadList);
        }
        return "/app/ciudad/index";
    }

}
