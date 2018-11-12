package controller;

import dao.IngresoCliente;
import facade.IngresoClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ingresoClienteController")
@ViewScoped
public class IngresoClienteController extends AbstractController<IngresoCliente> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private TipoIngresoController tipoIngresoController;

    public IngresoClienteController() {
        // Inform the Abstract parent controller of the concrete IngresoCliente Entity
        super(IngresoCliente.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getIngresoClientePK().setCodTipoIngreso(this.getSelected().getTipoIngreso().getCodTipoIngreso());
        this.getSelected().getIngresoClientePK().setCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setIngresoClientePK(new dao.IngresoClientePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        tipoIngresoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        IngresoCliente selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoIngreso controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoIngreso(ActionEvent event) {
        IngresoCliente selected = this.getSelected();
        if (selected != null && tipoIngresoController.getSelected() == null) {
            tipoIngresoController.setSelected(selected.getTipoIngreso());
        }
    }

}
