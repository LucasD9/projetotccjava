package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Estado;

@ManagedBean
@ViewScoped
public class EstadoMB {

    private Estado estado;
    private DAOGenerico<Estado> daoEstado;
    private List<Estado> listaEstado;

    public EstadoMB() {
        estado = new Estado();
        daoEstado = new DAOGenerico<Estado>(Estado.class);
        listaEstado = new ArrayList<Estado>();
        preencherListasEstados();
    }

    private void preencherListasEstados() {
        listaEstado = daoEstado.buscarTodos();
    }

    public void remover(Long id) {
        daoEstado.excluir(id);
        preencherListasEstados();
    }

    public void inserir() {
        if (estado.getId() == null) {
            daoEstado.salvar(estado);
        } else {
            daoEstado.alterar(estado);
        }
        estado = new Estado();
        preencherListasEstados();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }

}
