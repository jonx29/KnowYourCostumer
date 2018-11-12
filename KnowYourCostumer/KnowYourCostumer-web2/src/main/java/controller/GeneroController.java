package controller;

import dao.Genero;
import dao.Cliente;
import java.util.List;
import facade.GeneroFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "generoController")
@ViewScoped
public class GeneroController extends AbstractController<Genero> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;

    public GeneroController() {
        // Inform the Abstract parent controller of the concrete Genero Entity
        super(Genero.class);
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
        Genero selected = this.getSelected();
        if (selected != null) {
            GeneroFacade ejbFacade = (GeneroFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Genero and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        Genero selected = this.getSelected();
        if (selected != null) {
            GeneroFacade ejbFacade = (GeneroFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

}
