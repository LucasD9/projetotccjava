package converter;

import banco.DAOGenerico;
import modelo.Prestador;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterPrestador")
public class ConverterPrestador implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id != null && !id.isEmpty()) {
            DAOGenerico<Prestador> dao = new DAOGenerico<Prestador>(Prestador.class);
            return dao.buscar(new Long(id));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Prestador prestador = (Prestador) o;
            return String.valueOf(prestador.getId());
        }
        return null;
    }
}
