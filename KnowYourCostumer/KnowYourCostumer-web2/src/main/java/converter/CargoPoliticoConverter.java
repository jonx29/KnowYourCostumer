package converter;

import dao.CargoPolitico;
import facade.CargoPoliticoFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "cargoPoliticoConverter")
public class CargoPoliticoConverter implements Converter {

    private CargoPoliticoFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.CargoPoliticoPK getKey(String value) {
        dao.CargoPoliticoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.CargoPoliticoPK();
        key.setCodTipoCargoPolitico(Integer.parseInt(values[0]));
        key.setCodCliente(Integer.parseInt(values[1]));
        key.setCodCiudad(Integer.parseInt(values[2]));
        key.setFechaInicio(java.sql.Date.valueOf(values[3]));
        key.setFechaFin(java.sql.Date.valueOf(values[4]));
        return key;
    }

    String getStringKey(dao.CargoPoliticoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodTipoCargoPolitico());
        sb.append(SEPARATOR);
        sb.append(value.getCodCliente());
        sb.append(SEPARATOR);
        sb.append(value.getCodCiudad());
        sb.append(SEPARATOR);
        sb.append(value.getFechaInicio());
        sb.append(SEPARATOR);
        sb.append(value.getFechaFin());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof CargoPolitico) {
            CargoPolitico o = (CargoPolitico) object;
            return getStringKey(o.getCargoPoliticoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CargoPolitico.class.getName()});
            return null;
        }
    }

    private CargoPoliticoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(CargoPoliticoFacade.class).get();
        return this.ejbFacade;
    }
}
