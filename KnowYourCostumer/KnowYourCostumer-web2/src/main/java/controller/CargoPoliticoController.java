package controller;

import dao.CargoPolitico;
import facade.CargoPoliticoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargoPoliticoController")
@ViewScoped
public class CargoPoliticoController extends AbstractController<CargoPolitico> {

    @Inject
    private CiudadController ciudadController;
    @Inject
    private ClienteController clienteController;
    @Inject
    private TipoCargoPoliticoController tipoCargoPoliticoController;

    public CargoPoliticoController() {
        // Inform the Abstract parent controller of the concrete CargoPolitico Entity
        super(CargoPolitico.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCargoPoliticoPK().setCodTipoCargoPolitico(this.getSelected().getTipoCargoPolitico().getCodTipoCargoPolitico());
        this.getSelected().getCargoPoliticoPK().setCodCliente(this.getSelected().getCliente().getCodCliente());
        this.getSelected().getCargoPoliticoPK().setCodCiudad(this.getSelected().getCiudad().getCodCiudad());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCargoPoliticoPK(new dao.CargoPoliticoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
        clienteController.setSelected(null);
        tipoCargoPoliticoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        CargoPolitico selected = this.getSelected();
        if (selected != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(selected.getCiudad());
        }
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        CargoPolitico selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCargoPolitico controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoCargoPolitico(ActionEvent event) {
        CargoPolitico selected = this.getSelected();
        if (selected != null && tipoCargoPoliticoController.getSelected() == null) {
            tipoCargoPoliticoController.setSelected(selected.getTipoCargoPolitico());
        }
    }

}
