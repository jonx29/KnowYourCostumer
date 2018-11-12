package controller;

import dao.EstadoCivil;
import dao.Cliente;
import java.util.List;
import facade.EstadoCivilFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "estadoCivilController")
@ViewScoped
public class EstadoCivilController extends AbstractController<EstadoCivil> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;

    public EstadoCivilController() {
        // Inform the Abstract parent controller of the concrete EstadoCivil Entity
        super(EstadoCivil.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsClienteListEmpty();
    }

    public boolean getIsClienteListEmpty() {
        return this.isClienteListEmpty;
    }

    private void setIsClienteListEmpty() {
        EstadoCivil selected = this.getSelected();
        if (selected != null) {
            EstadoCivilFacade ejbFacade = (EstadoCivilFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from EstadoCivil and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        EstadoCivil selected = this.getSelected();
        if (selected != null) {
            EstadoCivilFacade ejbFacade = (EstadoCivilFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

}
