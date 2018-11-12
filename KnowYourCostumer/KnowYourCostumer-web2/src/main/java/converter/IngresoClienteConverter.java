package converter;

import dao.IngresoCliente;
import facade.IngresoClienteFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "ingresoClienteConverter")
public class IngresoClienteConverter implements Converter {

    private IngresoClienteFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.IngresoClientePK getKey(String value) {
        dao.IngresoClientePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.IngresoClientePK();
        key.setCodTipoIngreso(Integer.parseInt(values[0]));
        key.setCodCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(dao.IngresoClientePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodTipoIngreso());
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
        if (object instanceof IngresoCliente) {
            IngresoCliente o = (IngresoCliente) object;
            return getStringKey(o.getIngresoClientePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), IngresoCliente.class.getName()});
            return null;
        }
    }

    private IngresoClienteFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(IngresoClienteFacade.class).get();
        return this.ejbFacade;
    }
}
