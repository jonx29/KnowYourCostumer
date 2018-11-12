package controller;

import dao.NumeroTelefono;
import facade.NumeroTelefonoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "numeroTelefonoController")
@ViewScoped
public class NumeroTelefonoController extends AbstractController<NumeroTelefono> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private TipoTelefonoController codTipoTelefonoController;

    public NumeroTelefonoController() {
        // Inform the Abstract parent controller of the concrete NumeroTelefono Entity
        super(NumeroTelefono.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNumeroTelefonoPK().setCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNumeroTelefonoPK(new dao.NumeroTelefonoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        codTipoTelefonoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        NumeroTelefono selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoTelefono controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodTipoTelefono(ActionEvent event) {
        NumeroTelefono selected = this.getSelected();
        if (selected != null && codTipoTelefonoController.getSelected() == null) {
            codTipoTelefonoController.setSelected(selected.getCodTipoTelefono());
        }
    }

}
