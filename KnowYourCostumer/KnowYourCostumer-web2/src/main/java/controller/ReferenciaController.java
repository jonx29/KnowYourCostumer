package controller;

import dao.Referencia;
import facade.ReferenciaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "referenciaController")
@ViewScoped
public class ReferenciaController extends AbstractController<Referencia> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private ClienteController cliente1Controller;
    @Inject
    private TipoReferenciaController codTipoReferenciaController;

    public ReferenciaController() {
        // Inform the Abstract parent controller of the concrete Referencia Entity
        super(Referencia.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getReferenciaPK().setCodCliente(this.getSelected().getCliente1().getCodCliente());
        this.getSelected().getReferenciaPK().setCliCodCliente(this.getSelected().getCliente().getCodCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setReferenciaPK(new dao.ReferenciaPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        cliente1Controller.setSelected(null);
        codTipoReferenciaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        Referencia selected = this.getSelected();
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
        Referencia selected = this.getSelected();
        if (selected != null && cliente1Controller.getSelected() == null) {
            cliente1Controller.setSelected(selected.getCliente1());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoReferencia controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodTipoReferencia(ActionEvent event) {
        Referencia selected = this.getSelected();
        if (selected != null && codTipoReferenciaController.getSelected() == null) {
            codTipoReferenciaController.setSelected(selected.getCodTipoReferencia());
        }
    }

}
