package controller;

import dao.EgresoCliente;
import facade.EgresoClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "egresoClienteController")
@ViewScoped
public class EgresoClienteController extends AbstractController<EgresoCliente> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private TipoEgresoController tipoEgresoController;

    public EgresoClienteController() {
        // Inform the Abstract parent controller of the concrete EgresoCliente Entity
        super(EgresoCliente.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getEgresoClientePK().setCodTipoEgreso(this.getSelected().getTipoEgreso().getCodTipoEgreso());
        this.getSelected().getEgresoClientePK().setCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setEgresoClientePK(new dao.EgresoClientePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        tipoEgresoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        EgresoCliente selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoEgreso controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoEgreso(ActionEvent event) {
        EgresoCliente selected = this.getSelected();
        if (selected != null && tipoEgresoController.getSelected() == null) {
            tipoEgresoController.setSelected(selected.getTipoEgreso());
        }
    }

}
