package converter;

import dao.Referencia;
import facade.ReferenciaFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "referenciaConverter")
public class ReferenciaConverter implements Converter {

    private ReferenciaFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.ReferenciaPK getKey(String value) {
        dao.ReferenciaPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.ReferenciaPK();
        key.setCodCliente(Integer.parseInt(values[0]));
        key.setCliCodCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(dao.ReferenciaPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodCliente());
        sb.append(SEPARATOR);
        sb.append(value.getCliCodCliente());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Referencia) {
            Referencia o = (Referencia) object;
            return getStringKey(o.getReferenciaPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Referencia.class.getName()});
            return null;
        }
    }

    private ReferenciaFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(ReferenciaFacade.class).get();
        return this.ejbFacade;
    }
}
