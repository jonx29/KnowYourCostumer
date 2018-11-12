package controller;

import dao.Cuenta;
import facade.CuentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cuentaController")
@ViewScoped
public class CuentaController extends AbstractController<Cuenta> {

    @Inject
    private ClienteController codClienteController;
    @Inject
    private TipoCuentaController codTipoCuentaController;

    public CuentaController() {
        // Inform the Abstract parent controller of the concrete Cuenta Entity
        super(Cuenta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codClienteController.setSelected(null);
        codTipoCuentaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodCliente(ActionEvent event) {
        Cuenta selected = this.getSelected();
        if (selected != null && codClienteController.getSelected() == null) {
            codClienteController.setSelected(selected.getCodCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCuenta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodTipoCuenta(ActionEvent event) {
        Cuenta selected = this.getSelected();
        if (selected != null && codTipoCuentaController.getSelected() == null) {
            codTipoCuentaController.setSelected(selected.getCodTipoCuenta());
        }
    }

}
