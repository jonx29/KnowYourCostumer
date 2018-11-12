package converter;

import dao.EgresoCliente;
import facade.EgresoClienteFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "egresoClienteConverter")
public class EgresoClienteConverter implements Converter {

    private EgresoClienteFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.EgresoClientePK getKey(String value) {
        dao.EgresoClientePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.EgresoClientePK();
        key.setCodTipoEgreso(Integer.parseInt(values[0]));
        key.setCodCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(dao.EgresoClientePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodTipoEgreso());
        sb.append(SEPARATOR);
        sb.append(value.getCodCliente());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof EgresoCliente) {
            EgresoCliente o = (EgresoCliente) object;
            return getStringKey(o.getEgresoClientePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EgresoCliente.class.getName()});
            return null;
        }
    }

    private EgresoClienteFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(EgresoClienteFacade.class).get();
        return this.ejbFacade;
    }
}
