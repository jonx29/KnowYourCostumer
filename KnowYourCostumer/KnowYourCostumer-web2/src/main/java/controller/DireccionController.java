package controller;

import dao.Direccion;
import dao.DireccionCliente;
import java.util.List;
import facade.DireccionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionController")
@ViewScoped
public class DireccionController extends AbstractController<Direccion> {

    @Inject
    private CalleController codCalleTransController;
    @Inject
    private CalleController codCalleController;

    // Flags to indicate if child collections are empty
    private boolean isDireccionClienteListEmpty;

    public DireccionController() {
        // Inform the Abstract parent controller of the concrete Direccion Entity
        super(Direccion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codCalleTransController.setSelected(null);
        codCalleController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDireccionClienteListEmpty();
    }

    public boolean getIsDireccionClienteListEmpty() {
        return this.isDireccionClienteListEmpty;
    }

    private void setIsDireccionClienteListEmpty() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            this.isDireccionClienteListEmpty = ejbFacade.isDireccionClienteListEmpty(selected);
        } else {
            this.isDireccionClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of DireccionCliente entities
     * that are retrieved from Direccion and returns the navigation outcome.
     *
     * @return navigation outcome for DireccionCliente page
     */
    public String navigateDireccionClienteList() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            List<DireccionCliente> selectedDireccionClienteList = ejbFacade.findDireccionClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionCliente_items", selectedDireccionClienteList);
        }
        return "/app/direccionCliente/index";
    }

    /**
     * Sets the "selected" attribute of the Calle controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodCalleTrans(ActionEvent event) {
        Direccion selected = this.getSelected();
        if (selected != null && codCalleTransController.getSelected() == null) {
            codCalleTransController.setSelected(selected.getCodCalleTrans());
        }
    }

    /**
     * Sets the "selected" attribute of the Calle controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodCalle(ActionEvent event) {
        Direccion selected = this.getSelected();
        if (selected != null && codCalleController.getSelected() == null) {
            codCalleController.setSelected(selected.getCodCalle());
        }
    }

}
