package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Consumidor;

@ManagedBean
@ViewScoped
public class ConsumidorMB {

    private Consumidor consumidor;
    private DAOGenerico<Consumidor> daoConsumidor;
    private List<Consumidor> listaConsumidor;

    public ConsumidorMB() {
        consumidor = new Consumidor();
        daoConsumidor = new DAOGenerico<Consumidor>(Consumidor.class);
        listaConsumidor = new ArrayList<Consumidor>();
        preencherListaConsumidor();
    }

    public void atualizarCadastro() {
        consumidor = new Consumidor();
        preencherListaConsumidor();
    }

    private void preencherListaConsumidor() {
        listaConsumidor = daoConsumidor.buscarTodos();
    }

    public void remover(Long id) {
        daoConsumidor.excluir(id);
        preencherListaConsumidor();
    }

    public void inserir() {
        consumidor.setPerfil("CONSUMIDOR");
        if (consumidor.getId() == null) {
            daoConsumidor.salvar(consumidor);
        } else {
            daoConsumidor.alterar(consumidor);
        }
        consumidor = new Consumidor();
        preencherListaConsumidor();
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public DAOGenerico<Consumidor> getDaoConsumidor() {
        return daoConsumidor;
    }

    public void setDaoConsumidor(DAOGenerico<Consumidor> daoConsumidor) {
        this.daoConsumidor = daoConsumidor;
    }

    public List<Consumidor> getListaConsumidor() {
        return listaConsumidor;
    }

    public void setListaConsumidor(List<Consumidor> listaConsumidor) {
        this.listaConsumidor = listaConsumidor;
    }

}
