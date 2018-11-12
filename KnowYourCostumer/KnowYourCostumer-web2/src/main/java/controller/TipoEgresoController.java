package controller;

import dao.TipoEgreso;
import dao.EgresoCliente;
import java.util.List;
import facade.TipoEgresoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoEgresoController")
@ViewScoped
public class TipoEgresoController extends AbstractController<TipoEgreso> {

    // Flags to indicate if child collections are empty
    private boolean isEgresoClienteListEmpty;

    public TipoEgresoController() {
        // Inform the Abstract parent controller of the concrete TipoEgreso Entity
        super(TipoEgreso.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEgresoClienteListEmpty();
    }

    public boolean getIsEgresoClienteListEmpty() {
        return this.isEgresoClienteListEmpty;
    }

    private void setIsEgresoClienteListEmpty() {
        TipoEgreso selected = this.getSelected();
        if (selected != null) {
            TipoEgresoFacade ejbFacade = (TipoEgresoFacade) this.getFacade();
            this.isEgresoClienteListEmpty = ejbFacade.isEgresoClienteListEmpty(selected);
        } else {
            this.isEgresoClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of EgresoCliente entities
     * that are retrieved from TipoEgreso and returns the navigation outcome.
     *
     * @return navigation outcome for EgresoCliente page
     */
    public String navigateEgresoClienteList() {
        TipoEgreso selected = this.getSelected();
        if (selected != null) {
            TipoEgresoFacade ejbFacade = (TipoEgresoFacade) this.getFacade();
            List<EgresoCliente> selectedEgresoClienteList = ejbFacade.findEgresoClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EgresoCliente_items", selectedEgresoClienteList);
        }
        return "/app/egresoCliente/index";
    }

}
