package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaMB {

    private Categoria categoria;

    private DAOGenerico<Categoria> daoCategoria;

    private List<Categoria> listaCategoria;

    public CategoriaMB() {
        categoria = new Categoria();
        daoCategoria = new DAOGenerico<Categoria>(Categoria.class);
        listaCategoria = new ArrayList<Categoria>();
        preencherListaCategoria();
    }

    private void preencherListaCategoria() {
        listaCategoria = daoCategoria.buscarTodos();
    }

    public void remover(Long id) {
        daoCategoria.excluir(id);
        preencherListaCategoria();
    }

    public void inserir() {
        if (categoria.getId() == null) {
            daoCategoria.salvar(categoria);
        } else {
            daoCategoria.alterar(categoria);
        }
        categoria = new Categoria();
        preencherListaCategoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public DAOGenerico<Categoria> getDaoCategoria() {
        return daoCategoria;
    }

    public void setDaoCategoria(DAOGenerico<Categoria> daoCategoria) {
        this.daoCategoria = daoCategoria;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
}
