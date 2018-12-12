package util;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cidade;
import modelo.Estado;

@ManagedBean
@ViewScoped
public class FiltroCidade {

    private Estado estado;
    private DAOGenerico<Cidade> daoCidade;
    private List<Cidade> listaCidade;

    public FiltroCidade() {
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        estado = new Estado();
    }
//------------------------------------------------------------------------------

    public void filtroCidade() {
        listaCidade = daoCidade.buscarCondicao("estado.id = '" + estado.getId() + "'");
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DAOGenerico<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(DAOGenerico<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

}
