package controller;

import dao.TipoPersoneria;
import dao.Cliente;
import java.util.List;
import facade.TipoPersoneriaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoPersoneriaController")
@ViewScoped
public class TipoPersoneriaController extends AbstractController<TipoPersoneria> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;

    public TipoPersoneriaController() {
        // Inform the Abstract parent controller of the concrete TipoPersoneria Entity
        super(TipoPersoneria.class);
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
        TipoPersoneria selected = this.getSelected();
        if (selected != null) {
            TipoPersoneriaFacade ejbFacade = (TipoPersoneriaFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from TipoPersoneria and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        TipoPersoneria selected = this.getSelected();
        if (selected != null) {
            TipoPersoneriaFacade ejbFacade = (TipoPersoneriaFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

}
