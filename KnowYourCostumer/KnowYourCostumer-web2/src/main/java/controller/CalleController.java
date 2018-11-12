package controller;

import dao.Calle;
import dao.Direccion;
import dao.Direccion;
import java.util.List;
import facade.CalleFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "calleController")
@ViewScoped
public class CalleController extends AbstractController<Calle> {

    @Inject
    private CiudadController codCiudadController;

    // Flags to indicate if child collections are empty
    private boolean isDireccionListEmpty;
    private boolean isDireccionList1Empty;

    public CalleController() {
        // Inform the Abstract parent controller of the concrete Calle Entity
        super(Calle.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codCiudadController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDireccionListEmpty();
        this.setIsDireccionList1Empty();
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodCiudad(ActionEvent event) {
        Calle selected = this.getSelected();
        if (selected != null && codCiudadController.getSelected() == null) {
            codCiudadController.setSelected(selected.getCodCiudad());
        }
    }

    public boolean getIsDireccionListEmpty() {
        return this.isDireccionListEmpty;
    }

    private void setIsDireccionListEmpty() {
        Calle selected = this.getSelected();
        if (selected != null) {
            CalleFacade ejbFacade = (CalleFacade) this.getFacade();
            this.isDireccionListEmpty = ejbFacade.isDireccionListEmpty(selected);
        } else {
            this.isDireccionListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Direccion entities that
     * are retrieved from Calle and returns the navigation outcome.
     *
     * @return navigation outcome for Direccion page
     */
    public String navigateDireccionList() {
        Calle selected = this.getSelected();
        if (selected != null) {
            CalleFacade ejbFacade = (CalleFacade) this.getFacade();
            List<Direccion> selectedDireccionList = ejbFacade.findDireccionList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Direccion_items", selectedDireccionList);
        }
        return "/app/direccion/index";
    }

    public boolean getIsDireccionList1Empty() {
        return this.isDireccionList1Empty;
    }

    private void setIsDireccionList1Empty() {
        Calle selected = this.getSelected();
        if (selected != null) {
            CalleFacade ejbFacade = (CalleFacade) this.getFacade();
            this.isDireccionList1Empty = ejbFacade.isDireccionList1Empty(selected);
        } else {
            this.isDireccionList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Direccion entities that
     * are retrieved from Calle and returns the navigation outcome.
     *
     * @return navigation outcome for Direccion page
     */
    public String navigateDireccionList1() {
        Calle selected = this.getSelected();
        if (selected != null) {
            CalleFacade ejbFacade = (CalleFacade) this.getFacade();
            List<Direccion> selectedDireccionList1 = ejbFacade.findDireccionList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Direccion_items", selectedDireccionList1);
        }
        return "/app/direccion/index";
    }

}
