package controller;

import dao.TipoCuenta;
import dao.Cuenta;
import java.util.List;
import facade.TipoCuentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCuentaController")
@ViewScoped
public class TipoCuentaController extends AbstractController<TipoCuenta> {

    // Flags to indicate if child collections are empty
    private boolean isCuentaListEmpty;

    public TipoCuentaController() {
        // Inform the Abstract parent controller of the concrete TipoCuenta Entity
        super(TipoCuenta.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCuentaListEmpty();
    }

    public boolean getIsCuentaListEmpty() {
        return this.isCuentaListEmpty;
    }

    private void setIsCuentaListEmpty() {
        TipoCuenta selected = this.getSelected();
        if (selected != null) {
            TipoCuentaFacade ejbFacade = (TipoCuentaFacade) this.getFacade();
            this.isCuentaListEmpty = ejbFacade.isCuentaListEmpty(selected);
        } else {
            this.isCuentaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cuenta entities that are
     * retrieved from TipoCuenta and returns the navigation outcome.
     *
     * @return navigation outcome for Cuenta page
     */
    public String navigateCuentaList() {
        TipoCuenta selected = this.getSelected();
        if (selected != null) {
            TipoCuentaFacade ejbFacade = (TipoCuentaFacade) this.getFacade();
            List<Cuenta> selectedCuentaList = ejbFacade.findCuentaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cuenta_items", selectedCuentaList);
        }
        return "/app/cuenta/index";
    }

}
