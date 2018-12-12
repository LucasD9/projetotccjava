package converter;

import banco.DAOGenerico;
import modelo.Consumidor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterConsumidor")
public class ConverterConsumidor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Consumidor> dao = new DAOGenerico<Consumidor>(Consumidor.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Consumidor consumidor = (Consumidor) o;
            return String.valueOf(consumidor.getId());
        }
        return null;
    }
}
