package controller;

import dao.TipoIngreso;
import dao.IngresoCliente;
import java.util.List;
import facade.TipoIngresoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoIngresoController")
@ViewScoped
public class TipoIngresoController extends AbstractController<TipoIngreso> {

    // Flags to indicate if child collections are empty
    private boolean isIngresoClienteListEmpty;

    public TipoIngresoController() {
        // Inform the Abstract parent controller of the concrete TipoIngreso Entity
        super(TipoIngreso.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsIngresoClienteListEmpty();
    }

    public boolean getIsIngresoClienteListEmpty() {
        return this.isIngresoClienteListEmpty;
    }

    private void setIsIngresoClienteListEmpty() {
        TipoIngreso selected = this.getSelected();
        if (selected != null) {
            TipoIngresoFacade ejbFacade = (TipoIngresoFacade) this.getFacade();
            this.isIngresoClienteListEmpty = ejbFacade.isIngresoClienteListEmpty(selected);
        } else {
            this.isIngresoClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of IngresoCliente entities
     * that are retrieved from TipoIngreso and returns the navigation outcome.
     *
     * @return navigation outcome for IngresoCliente page
     */
    public String navigateIngresoClienteList() {
        TipoIngreso selected = this.getSelected();
        if (selected != null) {
            TipoIngresoFacade ejbFacade = (TipoIngresoFacade) this.getFacade();
            List<IngresoCliente> selectedIngresoClienteList = ejbFacade.findIngresoClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("IngresoCliente_items", selectedIngresoClienteList);
        }
        return "/app/ingresoCliente/index";
    }

}
