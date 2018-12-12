package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Prestador;

@ManagedBean
@ViewScoped
public class PrestadorMB {

    private Prestador prestador;
    private DAOGenerico<Prestador> daoPrestador;
    private List<Prestador> listaPrestador;

    public PrestadorMB() {
        prestador = new Prestador();
        daoPrestador = new DAOGenerico<Prestador>(Prestador.class);
        listaPrestador = new ArrayList<Prestador>();
        preencherListaPrestador();
    }

    private void preencherListaPrestador() {
        listaPrestador = daoPrestador.buscarTodos();
    }

    public void remover(Long id) {
        daoPrestador.excluir(id);
        preencherListaPrestador();
    }

    public void inserir() {
        prestador.setPerfil("PRESTADOR");
        if (prestador.getId() == null) {
            daoPrestador.salvar(prestador);
        } else {
            daoPrestador.alterar(prestador);
        }
        prestador = new Prestador();
        preencherListaPrestador();
    }

    public void atualizarCadastro() {
        prestador = new Prestador();
        preencherListaPrestador();
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public DAOGenerico<Prestador> getDaoPrestador() {
        return daoPrestador;
    }

    public void setDaoPrestador(DAOGenerico<Prestador> daoPrestador) {
        this.daoPrestador = daoPrestador;
    }

    public List<Prestador> getListaPrestador() {
        return listaPrestador;
    }

    public void setListaPrestador(List<Prestador> listaPrestador) {
        this.listaPrestador = listaPrestador;
    }

}
