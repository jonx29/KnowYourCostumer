package controller;

import dao.TipoActividadEconomica;
import dao.Cliente;
import java.util.List;
import facade.TipoActividadEconomicaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoActividadEconomicaController")
@ViewScoped
public class TipoActividadEconomicaController extends AbstractController<TipoActividadEconomica> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;

    public TipoActividadEconomicaController() {
        // Inform the Abstract parent controller of the concrete TipoActividadEconomica Entity
        super(TipoActividadEconomica.class);
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
        TipoActividadEconomica selected = this.getSelected();
        if (selected != null) {
            TipoActividadEconomicaFacade ejbFacade = (TipoActividadEconomicaFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from TipoActividadEconomica and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        TipoActividadEconomica selected = this.getSelected();
        if (selected != null) {
            TipoActividadEconomicaFacade ejbFacade = (TipoActividadEconomicaFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

}
