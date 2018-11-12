package converter;

import dao.Identificacion;
import facade.IdentificacionFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "identificacionConverter")
public class IdentificacionConverter implements Converter {

    private IdentificacionFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.IdentificacionPK getKey(String value) {
        dao.IdentificacionPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.IdentificacionPK();
        key.setCodTipoIdentificacion(Integer.parseInt(values[0]));
        key.setCodCliente(Integer.parseInt(values[1]));
        key.setCodPais(values[2]);
        return key;
    }

    String getStringKey(dao.IdentificacionPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodTipoIdentificacion());
        sb.append(SEPARATOR);
        sb.append(value.getCodCliente());
        sb.append(SEPARATOR);
        sb.append(value.getCodPais());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Identificacion) {
            Identificacion o = (Identificacion) object;
            return getStringKey(o.getIdentificacionPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Identificacion.class.getName()});
            return null;
        }
    }

    private IdentificacionFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(IdentificacionFacade.class).get();
        return this.ejbFacade;
    }
}
