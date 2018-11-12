package controller;

import dao.DireccionCliente;
import facade.DireccionClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionClienteController")
@ViewScoped
public class DireccionClienteController extends AbstractController<DireccionCliente> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private DireccionController direccionController;

    public DireccionClienteController() {
        // Inform the Abstract parent controller of the concrete DireccionCliente Entity
        super(DireccionCliente.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDireccionClientePK().setCodDireccion(this.getSelected().getDireccion().getCodDireccion());
        this.getSelected().getDireccionClientePK().setCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDireccionClientePK(new dao.DireccionClientePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        direccionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        DireccionCliente selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Direccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDireccion(ActionEvent event) {
        DireccionCliente selected = this.getSelected();
        if (selected != null && direccionController.getSelected() == null) {
            direccionController.setSelected(selected.getDireccion());
        }
    }

}
