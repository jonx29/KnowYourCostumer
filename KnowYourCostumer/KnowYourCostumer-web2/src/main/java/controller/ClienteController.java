package controller;

import dao.Cliente;
import dao.Pais;
import dao.Cliente;
import dao.Cliente;
import dao.TipoActividadEconomica;
import dao.Profesion;
import dao.DireccionCliente;
import dao.Cuenta;
import dao.CargoPolitico;
import dao.Identificacion;
import dao.IngresoCliente;
import dao.NumeroTelefono;
import dao.Parentesco;
import dao.Parentesco;
import dao.Referencia;
import dao.Referencia;
import dao.EgresoCliente;
import java.util.List;
import facade.ClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "clienteController")
@ViewScoped
public class ClienteController extends AbstractController<Cliente> {

    @Inject
    private EstadoCivilController codEstadoCivilController;
    @Inject
    private GeneroController codGeneroController;
    @Inject
    private PaisController paisNacimientoController;
    @Inject
    private TipoPersoneriaController codTipoPersoneriaController;

    // Flags to indicate if child collections are empty
    private boolean isPaisListEmpty;
    private boolean isClienteListEmpty;
    private boolean isClienteList1Empty;
    private boolean isTipoActividadEconomicaListEmpty;
    private boolean isProfesionListEmpty;
    private boolean isDireccionClienteListEmpty;
    private boolean isCuentaListEmpty;
    private boolean isCargoPoliticoListEmpty;
    private boolean isIdentificacionListEmpty;
    private boolean isIngresoClienteListEmpty;
    private boolean isNumeroTelefonoListEmpty;
    private boolean isParentescoListEmpty;
    private boolean isParentescoList1Empty;
    private boolean isReferenciaListEmpty;
    private boolean isReferenciaList1Empty;
    private boolean isEgresoClienteListEmpty;

    public ClienteController() {
        // Inform the Abstract parent controller of the concrete Cliente Entity
        super(Cliente.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codEstadoCivilController.setSelected(null);
        codGeneroController.setSelected(null);
        paisNacimientoController.setSelected(null);
        codTipoPersoneriaController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPaisListEmpty();
        this.setIsClienteListEmpty();
        this.setIsClienteList1Empty();
        this.setIsTipoActividadEconomicaListEmpty();
        this.setIsProfesionListEmpty();
        this.setIsDireccionClienteListEmpty();
        this.setIsCuentaListEmpty();
        this.setIsCargoPoliticoListEmpty();
        this.setIsIdentificacionListEmpty();
        this.setIsIngresoClienteListEmpty();
        this.setIsNumeroTelefonoListEmpty();
        this.setIsParentescoListEmpty();
        this.setIsParentescoList1Empty();
        this.setIsReferenciaListEmpty();
        this.setIsReferenciaList1Empty();
        this.setIsEgresoClienteListEmpty();
    }

    public boolean getIsPaisListEmpty() {
        return this.isPaisListEmpty;
    }

    private void setIsPaisListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isPaisListEmpty = (selected.getPaisList() == null || selected.getPaisList().isEmpty());
        } else {
            this.isPaisListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Pais entities that are
     * retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Pais page
     */
    public String navigatePaisList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            // Note: PaisList has already been read as is initialized
            List<Pais> selectedPaisList = selected.getPaisList();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pais_items", selectedPaisList);
        }
        return "/app/pais/index";
    }

    public boolean getIsClienteListEmpty() {
        return this.isClienteListEmpty;
    }

    private void setIsClienteListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isClienteListEmpty = (selected.getClienteList() == null || selected.getClienteList().isEmpty());
        } else {
            this.isClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            // Note: ClienteList has already been read as is initialized
            List<Cliente> selectedClienteList = selected.getClienteList();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList);
        }
        return "/app/cliente/index";
    }

    public boolean getIsClienteList1Empty() {
        return this.isClienteList1Empty;
    }

    private void setIsClienteList1Empty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isClienteList1Empty = ejbFacade.isClienteList1Empty(selected);
        } else {
            this.isClienteList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList1() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Cliente> selectedClienteList1 = ejbFacade.findClienteList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", selectedClienteList1);
        }
        return "/app/cliente/index";
    }

    public boolean getIsTipoActividadEconomicaListEmpty() {
        return this.isTipoActividadEconomicaListEmpty;
    }

    private void setIsTipoActividadEconomicaListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isTipoActividadEconomicaListEmpty = (selected.getTipoActividadEconomicaList() == null || selected.getTipoActividadEconomicaList().isEmpty());
        } else {
            this.isTipoActividadEconomicaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of TipoActividadEconomica
     * entities that are retrieved from Cliente and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoActividadEconomica page
     */
    public String navigateTipoActividadEconomicaList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            // Note: TipoActividadEconomicaList has already been read as is initialized
            List<TipoActividadEconomica> selectedTipoActividadEconomicaList = selected.getTipoActividadEconomicaList();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoActividadEconomica_items", selectedTipoActividadEconomicaList);
        }
        return "/app/tipoActividadEconomica/index";
    }

    public boolean getIsProfesionListEmpty() {
        return this.isProfesionListEmpty;
    }

    private void setIsProfesionListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isProfesionListEmpty = (selected.getProfesionList() == null || selected.getProfesionList().isEmpty());
        } else {
            this.isProfesionListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Profesion entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Profesion page
     */
    public String navigateProfesionList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            // Note: ProfesionList has already been read as is initialized
            List<Profesion> selectedProfesionList = selected.getProfesionList();
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Profesion_items", selectedProfesionList);
        }
        return "/app/profesion/index";
    }

    public boolean getIsDireccionClienteListEmpty() {
        return this.isDireccionClienteListEmpty;
    }

    private void setIsDireccionClienteListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isDireccionClienteListEmpty = ejbFacade.isDireccionClienteListEmpty(selected);
        } else {
            this.isDireccionClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of DireccionCliente entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for DireccionCliente page
     */
    public String navigateDireccionClienteList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<DireccionCliente> selectedDireccionClienteList = ejbFacade.findDireccionClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionCliente_items", selectedDireccionClienteList);
        }
        return "/app/direccionCliente/index";
    }

    public boolean getIsCuentaListEmpty() {
        return this.isCuentaListEmpty;
    }

    private void setIsCuentaListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isCuentaListEmpty = ejbFacade.isCuentaListEmpty(selected);
        } else {
            this.isCuentaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cuenta entities that are
     * retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Cuenta page
     */
    public String navigateCuentaList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Cuenta> selectedCuentaList = ejbFacade.findCuentaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cuenta_items", selectedCuentaList);
        }
        return "/app/cuenta/index";
    }

    public boolean getIsCargoPoliticoListEmpty() {
        return this.isCargoPoliticoListEmpty;
    }

    private void setIsCargoPoliticoListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isCargoPoliticoListEmpty = ejbFacade.isCargoPoliticoListEmpty(selected);
        } else {
            this.isCargoPoliticoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CargoPolitico entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for CargoPolitico page
     */
    public String navigateCargoPoliticoList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<CargoPolitico> selectedCargoPoliticoList = ejbFacade.findCargoPoliticoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargoPolitico_items", selectedCargoPoliticoList);
        }
        return "/app/cargoPolitico/index";
    }

    public boolean getIsIdentificacionListEmpty() {
        return this.isIdentificacionListEmpty;
    }

    private void setIsIdentificacionListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isIdentificacionListEmpty = ejbFacade.isIdentificacionListEmpty(selected);
        } else {
            this.isIdentificacionListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Identificacion entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Identificacion page
     */
    public String navigateIdentificacionList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Identificacion> selectedIdentificacionList = ejbFacade.findIdentificacionList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Identificacion_items", selectedIdentificacionList);
        }
        return "/app/identificacion/index";
    }

    /**
     * Sets the "selected" attribute of the EstadoCivil controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodEstadoCivil(ActionEvent event) {
        Cliente selected = this.getSelected();
        if (selected != null && codEstadoCivilController.getSelected() == null) {
            codEstadoCivilController.setSelected(selected.getCodEstadoCivil());
        }
    }

    /**
     * Sets the "selected" attribute of the Genero controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodGenero(ActionEvent event) {
        Cliente selected = this.getSelected();
        if (selected != null && codGeneroController.getSelected() == null) {
            codGeneroController.setSelected(selected.getCodGenero());
        }
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePaisNacimiento(ActionEvent event) {
        Cliente selected = this.getSelected();
        if (selected != null && paisNacimientoController.getSelected() == null) {
            paisNacimientoController.setSelected(selected.getPaisNacimiento());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoPersoneria controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodTipoPersoneria(ActionEvent event) {
        Cliente selected = this.getSelected();
        if (selected != null && codTipoPersoneriaController.getSelected() == null) {
            codTipoPersoneriaController.setSelected(selected.getCodTipoPersoneria());
        }
    }

    public boolean getIsIngresoClienteListEmpty() {
        return this.isIngresoClienteListEmpty;
    }

    private void setIsIngresoClienteListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isIngresoClienteListEmpty = ejbFacade.isIngresoClienteListEmpty(selected);
        } else {
            this.isIngresoClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of IngresoCliente entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for IngresoCliente page
     */
    public String navigateIngresoClienteList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<IngresoCliente> selectedIngresoClienteList = ejbFacade.findIngresoClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("IngresoCliente_items", selectedIngresoClienteList);
        }
        return "/app/ingresoCliente/index";
    }

    public boolean getIsNumeroTelefonoListEmpty() {
        return this.isNumeroTelefonoListEmpty;
    }

    private void setIsNumeroTelefonoListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isNumeroTelefonoListEmpty = ejbFacade.isNumeroTelefonoListEmpty(selected);
        } else {
            this.isNumeroTelefonoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of NumeroTelefono entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for NumeroTelefono page
     */
    public String navigateNumeroTelefonoList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<NumeroTelefono> selectedNumeroTelefonoList = ejbFacade.findNumeroTelefonoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NumeroTelefono_items", selectedNumeroTelefonoList);
        }
        return "/app/numeroTelefono/index";
    }

    public boolean getIsParentescoListEmpty() {
        return this.isParentescoListEmpty;
    }

    private void setIsParentescoListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isParentescoListEmpty = ejbFacade.isParentescoListEmpty(selected);
        } else {
            this.isParentescoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Parentesco entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Parentesco page
     */
    public String navigateParentescoList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Parentesco> selectedParentescoList = ejbFacade.findParentescoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Parentesco_items", selectedParentescoList);
        }
        return "/app/parentesco/index";
    }

    public boolean getIsParentescoList1Empty() {
        return this.isParentescoList1Empty;
    }

    private void setIsParentescoList1Empty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isParentescoList1Empty = ejbFacade.isParentescoList1Empty(selected);
        } else {
            this.isParentescoList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Parentesco entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Parentesco page
     */
    public String navigateParentescoList1() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Parentesco> selectedParentescoList1 = ejbFacade.findParentescoList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Parentesco_items", selectedParentescoList1);
        }
        return "/app/parentesco/index";
    }

    public boolean getIsReferenciaListEmpty() {
        return this.isReferenciaListEmpty;
    }

    private void setIsReferenciaListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isReferenciaListEmpty = ejbFacade.isReferenciaListEmpty(selected);
        } else {
            this.isReferenciaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Referencia entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Referencia page
     */
    public String navigateReferenciaList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Referencia> selectedReferenciaList = ejbFacade.findReferenciaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Referencia_items", selectedReferenciaList);
        }
        return "/app/referencia/index";
    }

    public boolean getIsReferenciaList1Empty() {
        return this.isReferenciaList1Empty;
    }

    private void setIsReferenciaList1Empty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isReferenciaList1Empty = ejbFacade.isReferenciaList1Empty(selected);
        } else {
            this.isReferenciaList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Referencia entities that
     * are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for Referencia page
     */
    public String navigateReferenciaList1() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<Referencia> selectedReferenciaList1 = ejbFacade.findReferenciaList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Referencia_items", selectedReferenciaList1);
        }
        return "/app/referencia/index";
    }

    public boolean getIsEgresoClienteListEmpty() {
        return this.isEgresoClienteListEmpty;
    }

    private void setIsEgresoClienteListEmpty() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isEgresoClienteListEmpty = ejbFacade.isEgresoClienteListEmpty(selected);
        } else {
            this.isEgresoClienteListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of EgresoCliente entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for EgresoCliente page
     */
    public String navigateEgresoClienteList() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            List<EgresoCliente> selectedEgresoClienteList = ejbFacade.findEgresoClienteList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EgresoCliente_items", selectedEgresoClienteList);
        }
        return "/app/egresoCliente/index";
    }

}
