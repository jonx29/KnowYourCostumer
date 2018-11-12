package controller;

import dao.Pais;
import dao.Cliente;
import dao.Provincia;
import dao.Identificacion;
import dao.Cliente;
import java.util.List;
import facade.PaisFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "paisController")
@ViewScoped
public class PaisController extends AbstractController<Pais> {

    // Flags to indicate if child collections are empty
    private boolean isClienteListEmpty;
    private boolean isProvinciaListEmpty;
    private boolean isIdentificacionListEmpty;
    private boolean isClienteList1Empty;

    public PaisController() {
        // Inform the Abstract parent controller of the concrete Pais Entity
        super(Pais.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsClienteListEmpty();
        this.setIsProvinciaListEmpty();
        this.setIsIdentificacionListEmpty();
        this.setIsClienteList1Empty();
    }

    public boolean getIsClienteListEmpty() {
        return this.isClienteListEmpty;
    }

    private void setIsClienteListEmpty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isClienteListEmpty = ejbFacade.isClienteListEmpty(selected);
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            List<Cliente> selectedClienteList = ejbFacade.findClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

    public boolean getIsProvinciaListEmpty() {
        return this.isProvinciaListEmpty;
    }

    private void setIsProvinciaListEmpty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isProvinciaListEmpty = ejbFacade.isProvinciaListEmpty(selected);
        } else {
            this.isProvinciaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Provincia entities that
     * are retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Provincia page
     */
    public String navigateProvinciaList() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            List<Provincia> selectedProvinciaList = ejbFacade.findProvinciaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Provincia_items", selectedProvinciaList);
        }
        return "/app/provincia/index";
    }

    public boolean getIsIdentificacionListEmpty() {
        return this.isIdentificacionListEmpty;
    }

    private void setIsIdentificacionListEmpty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isIdentificacionListEmpty = ejbFacade.isIdentificacionListEmpty(selected);
        } else {
            this.isIdentificacionListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Identificacion entities
     * that are retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Identificacion page
     */
    public String navigateIdentificacionList() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            List<Identificacion> selectedIdentificacionList = ejbFacade.findIdentificacionList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Identificacion_items", selectedIdentificacionList);
        }
        return "/app/identificacion/index";
    }

    public boolean getIsClienteList1Empty() {
        return this.isClienteList1Empty;
    }

    private void setIsClienteList1Empty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isClienteList1Empty = ejbFacade.isClienteList1Empty(selected);
        } else {
            this.isClienteList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList1() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            List<Cliente> selectedClienteList1 = ejbFacade.findClienteList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList1);
        }
        return "/app/cliente/index";
    }

}
