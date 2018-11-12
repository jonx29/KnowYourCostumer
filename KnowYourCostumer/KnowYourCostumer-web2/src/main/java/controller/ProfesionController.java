package controller;

import dao.Profesion;
import dao.Cliente;
import java.util.List;
import facade.ProfesionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "profesionController")
@ViewScoped
public class ProfesionController extends AbstractController<Profesion> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;

    public ProfesionController() {
        // Inform the Abstract parent controller of the concrete Profesion Entity
        super(Profesion.class);
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
        Profesion selected = this.getSelected();
        if (selected != null) {
            ProfesionFacade ejbFacade = (ProfesionFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Profesion and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        Profesion selected = this.getSelected();
        if (selected != null) {
            ProfesionFacade ejbFacade = (ProfesionFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

}
