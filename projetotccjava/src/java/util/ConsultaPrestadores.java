package util;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;
import modelo.Cidade;
import modelo.Prestador;

@ManagedBean
@ViewScoped
public class ConsultaPrestadores {

    private Categoria categoria;
    private Cidade cidade;
    private DAOGenerico<Prestador> daoConsultaPrestadores;
    private List<Prestador> listaPrestador;
    private Prestador prestadorSelecionado;

    public Prestador getPrestadorSelecionado() {
        return prestadorSelecionado;
    }

    public void setPrestadorSelecionado(Prestador prestadorSelecionado) {
        this.prestadorSelecionado = prestadorSelecionado;
    }

    public ConsultaPrestadores() {
        daoConsultaPrestadores = new DAOGenerico<Prestador>(Prestador.class);
        listaPrestador = new ArrayList<Prestador>();
    }
//------------------------------------------------------------------------------

    public void consultarPrestadores() {
        listaPrestador = daoConsultaPrestadores.buscarCondicao("categoria.id = '" + categoria.getId() + "' and cidade.id = '" + cidade.getId() + "'");
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DAOGenerico<Prestador> getDaoConsultaPrestadores() {
        return daoConsultaPrestadores;
    }

    public void setDaoConsultaPrestadores(DAOGenerico<Prestador> daoConsultaPrestadores) {
        this.daoConsultaPrestadores = daoConsultaPrestadores;
    }

    public List<Prestador> getListaPrestador() {
        return listaPrestador;
    }

    public void setListaPrestador(List<Prestador> listaPrestador) {
        this.listaPrestador = listaPrestador;
    }
}
