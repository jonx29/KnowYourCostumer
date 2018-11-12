package converter;

import dao.Parentesco;
import facade.ParentescoFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "parentescoConverter")
public class ParentescoConverter implements Converter {

    private ParentescoFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    dao.ParentescoPK getKey(String value) {
        dao.ParentescoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new dao.ParentescoPK();
        key.setCodCliente(Integer.parseInt(values[0]));
        key.setCliCodCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(dao.ParentescoPK value) {
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
        if (object instanceof Parentesco) {
            Parentesco o = (Parentesco) object;
            return getStringKey(o.getParentescoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Parentesco.class.getName()});
            return null;
        }
    }

    private ParentescoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(ParentescoFacade.class).get();
        return this.ejbFacade;
    }
}
