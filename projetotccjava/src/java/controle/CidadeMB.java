package controle;

import banco.DAOGenerico;
import modelo.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CidadeMB {

    private Cidade cidade;

    private DAOGenerico<Cidade> daoCidade;

    private List<Cidade> listaCidade;

    public CidadeMB() {
        cidade = new Cidade();
        daoCidade = new DAOGenerico<Cidade>(Cidade.class);
        listaCidade = new ArrayList<Cidade>();
        preencherListasCidades();
    }

    private void preencherListasCidades() {
        listaCidade = daoCidade.buscarTodos();
    }

    public void remover(Long id) {
        daoCidade.excluir(id);
        preencherListasCidades();
    }

    public void inserir() {
        if (cidade.getId() == null) {
            daoCidade.salvar(cidade);
        } else {
            daoCidade.alterar(cidade);
        }
        cidade = new Cidade();
        preencherListasCidades();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
