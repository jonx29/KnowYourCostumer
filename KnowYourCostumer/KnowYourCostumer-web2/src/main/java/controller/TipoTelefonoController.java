package controller;

import dao.TipoTelefono;
import dao.NumeroTelefono;
import java.util.List;
import facade.TipoTelefonoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoTelefonoController")
@ViewScoped
public class TipoTelefonoController extends AbstractController<TipoTelefono> {

    // Flags to indicate if child collections are empty
    private boolean isNumeroTelefonoListEmpty;

    public TipoTelefonoController() {
        // Inform the Abstract parent controller of the concrete TipoTelefono Entity
        super(TipoTelefono.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsNumeroTelefonoListEmpty();
    }

    public boolean getIsNumeroTelefonoListEmpty() {
        return this.isNumeroTelefonoListEmpty;
    }

    private void setIsNumeroTelefonoListEmpty() {
        TipoTelefono selected = this.getSelected();
        if (selected != null) {
            TipoTelefonoFacade ejbFacade = (TipoTelefonoFacade) this.getFacade();
            this.isNumeroTelefonoListEmpty = ejbFacade.isNumeroTelefonoListEmpty(selected);
        } else {
            this.isNumeroTelefonoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumeroTelefono entities
     * that are retrieved from TipoTelefono and returns the navigation outcome.
     *
     * @return navigation outcome for NumeroTelefono page
     */
    public String navigateNumeroTelefonoList() {
        TipoTelefono selected = this.getSelected();
        if (selected != null) {
            TipoTelefonoFacade ejbFacade = (TipoTelefonoFacade) this.getFacade();
            List<NumeroTelefono> selectedNumeroTelefonoList = ejbFacade.findNumeroTelefonoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NumeroTelefono_items", selectedNumeroTelefonoList);
        }
        return "/app/numeroTelefono/index";
    }

}
