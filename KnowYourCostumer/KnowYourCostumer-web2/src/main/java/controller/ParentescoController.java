package controller;

import dao.Parentesco;
import facade.ParentescoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "parentescoController")
@ViewScoped
public class ParentescoController extends AbstractController<Parentesco> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private ClienteController cliente1Controller;
    @Inject
    private TipoParentescoController codTipoParentescoController;

    public ParentescoController() {
        // Inform the Abstract parent controller of the concrete Parentesco Entity
        super(Parentesco.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getParentescoPK().setCodCliente(this.getSelected().getCliente1().getCodCliente());
        this.getSelected().getParentescoPK().setCliCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setParentescoPK(new dao.ParentescoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        cliente1Controller.setSelected(null);
        codTipoParentescoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        Parentesco selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente1(ActionEvent event) {
        Parentesco selected = this.getSelected();
        if (selected != null && cliente1Controller.getSelected() == null) {
            cliente1Controller.setSelected(selected.getCliente1());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoParentesco controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodTipoParentesco(ActionEvent event) {
        Parentesco selected = this.getSelected();
        if (selected != null && codTipoParentescoController.getSelected() == null) {
            codTipoParentescoController.setSelected(selected.getCodTipoParentesco());
        }
    }

}
