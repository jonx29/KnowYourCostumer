package controller;

import dao.Identificacion;
import facade.IdentificacionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "identificacionController")
@ViewScoped
public class IdentificacionController extends AbstractController<Identificacion> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private PaisController paisController;
    @Inject
    private TipoIdentificacionController tipoIdentificacionController;

    public IdentificacionController() {
        // Inform the Abstract parent controller of the concrete Identificacion Entity
        super(Identificacion.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getIdentificacionPK().setCodTipoIdentificacion(this.getSelected().getTipoIdentificacion().getCodTipoIdentificacion());
        this.getSelected().getIdentificacionPK().setCodCliente(this.getSelected().getCliente().getCodCliente());
        this.getSelected().getIdentificacionPK().setCodPais(this.getSelected().getPais().getCodPais());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setIdentificacionPK(new dao.IdentificacionPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        paisController.setSelected(null);
        tipoIdentificacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        Identificacion selected = this.getSelected();
        if (selected != null && clienteController.getSelected() == null) {
            clienteController.setSelected(selected.getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePais(ActionEvent event) {
        Identificacion selected = this.getSelected();
        if (selected != null && paisController.getSelected() == null) {
            paisController.setSelected(selected.getPais());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoIdentificacion controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoIdentificacion(ActionEvent event) {
        Identificacion selected = this.getSelected();
        if (selected != null && tipoIdentificacionController.getSelected() == null) {
            tipoIdentificacionController.setSelected(selected.getTipoIdentificacion());
        }
    }

}
