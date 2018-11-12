package converter;

import dao.DireccionCliente;
import facade.DireccionClienteFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "direccionClienteConverter")
public class DireccionClienteConverter implements Converter {

    private DireccionClienteFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.DireccionClientePK getKey(String value) {
        dao.DireccionClientePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.DireccionClientePK();
        key.setCodDireccion(Integer.parseInt(values[0]));
        key.setCodCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(dao.DireccionClientePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodDireccion());
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
        if (object instanceof DireccionCliente) {
            DireccionCliente o = (DireccionCliente) object;
            return getStringKey(o.getDireccionClientePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DireccionCliente.class.getName()});
            return null;
        }
    }

    private DireccionClienteFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(DireccionClienteFacade.class).get();
        return this.ejbFacade;
    }
}
