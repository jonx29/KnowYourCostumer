package controller;

import dao.TipoParentesco;
import dao.Parentesco;
import java.util.List;
import facade.TipoParentescoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoParentescoController")
@ViewScoped
public class TipoParentescoController extends AbstractController<TipoParentesco> {

    // Flags to indicate if child collections are empty
    private boolean isParentescoListEmpty;

    public TipoParentescoController() {
        // Inform the Abstract parent controller of the concrete TipoParentesco Entity
        super(TipoParentesco.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsParentescoListEmpty();
    }

    public boolean getIsParentescoListEmpty() {
        return this.isParentescoListEmpty;
    }

    private void setIsParentescoListEmpty() {
        TipoParentesco selected = this.getSelected();
        if (selected != null) {
            TipoParentescoFacade ejbFacade = (TipoParentescoFacade) this.getFacade();
            this.isParentescoListEmpty = ejbFacade.isParentescoListEmpty(selected);
        } else {
            this.isParentescoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Parentesco entities that
     * are retrieved from TipoParentesco and returns the navigation outcome.
     *
     * @return navigation outcome for Parentesco page
     */
    public String navigateParentescoList() {
        TipoParentesco selected = this.getSelected();
        if (selected != null) {
            TipoParentescoFacade ejbFacade = (TipoParentescoFacade) this.getFacade();
            List<Parentesco> selectedParentescoList = ejbFacade.findParentescoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Parentesco_items", selectedParentescoList);
        }
        return "/app/parentesco/index";
    }

}
