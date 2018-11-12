package controller;

import dao.TipoIdentificacion;
import dao.Identificacion;
import java.util.List;
import facade.TipoIdentificacionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoIdentificacionController")
@ViewScoped
public class TipoIdentificacionController extends AbstractController<TipoIdentificacion> {

    // Flags to indicate if child collections are empty
    private boolean isIdentificacionListEmpty;

    public TipoIdentificacionController() {
        // Inform the Abstract parent controller of the concrete TipoIdentificacion Entity
        super(TipoIdentificacion.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsIdentificacionListEmpty();
    }

    public boolean getIsIdentificacionListEmpty() {
        return this.isIdentificacionListEmpty;
    }

    private void setIsIdentificacionListEmpty() {
        TipoIdentificacion selected = this.getSelected();
        if (selected != null) {
            TipoIdentificacionFacade ejbFacade = (TipoIdentificacionFacade) this.getFacade();
            this.isIdentificacionListEmpty = ejbFacade.isIdentificacionListEmpty(selected);
        } else {
            this.isIdentificacionListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Identificacion entities
     * that are retrieved from TipoIdentificacion and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Identificacion page
     */
    public String navigateIdentificacionList() {
        TipoIdentificacion selected = this.getSelected();
        if (selected != null) {
            TipoIdentificacionFacade ejbFacade = (TipoIdentificacionFacade) this.getFacade();
            List<Identificacion> selectedIdentificacionList = ejbFacade.findIdentificacionList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Identificacion_items", selectedIdentificacionList);
        }
        return "/app/identificacion/index";
    }

}
