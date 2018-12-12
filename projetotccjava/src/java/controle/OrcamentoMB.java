package controle;

import banco.DAOGenerico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Orcamento;
import modelo.Prestador;
import modelo.Consumidor;
//import util.RetornaConsumidorLogado;
//import util.RetornaPrestadorLogado;

@ManagedBean
@ViewScoped
public class OrcamentoMB {

    private Orcamento orcamento;
    private DAOGenerico<Orcamento> daoOrcamento;

    private List<Orcamento> listaOrcamento_totais;
//    private List<Orcamento> listaOrcamento_solicitadoPrest;
//    private List<Orcamento> listaOrcamento_aceitoPrest;
//    private List<Orcamento> listaOrcamento_recusadoPrest;
//    private List<Orcamento> listaOrcamento_solicitadoConsum;
//    private List<Orcamento> listaOrcamento_aceitoConsum;
//    private List<Orcamento> listaOrcamento_recusadoConsum;

    private Prestador prestadorLogado;
    private Consumidor consumidorLogado;

    public OrcamentoMB() {
        orcamento = new Orcamento();
        daoOrcamento = new DAOGenerico<Orcamento>(Orcamento.class);
        listaOrcamento_totais = new ArrayList<Orcamento>();
//        listaOrcamento_solicitadoPrest = new ArrayList<Orcamento>();
//        listaOrcamento_aceitoPrest = new ArrayList<Orcamento>();
//        listaOrcamento_recusadoPrest = new ArrayList<Orcamento>();
//        listaOrcamento_solicitadoConsum = new ArrayList<Orcamento>();
//        listaOrcamento_aceitoConsum = new ArrayList<Orcamento>();
//        listaOrcamento_recusadoConsum = new ArrayList<Orcamento>();

//        prestadorLogado = RetornaPrestadorLogado.retornaLogado();
//        consumidorLogado = RetornaConsumidorLogado.retornaLogado();

        atualizaListasOrcamentos();
    }

    public void solicitarOrcamento() {
//        vincularConsumidor();
        orcamento.setStatusConsumidor("SOLICITADO");
        orcamento.setStatusPrestador("PENDENTE");
        daoOrcamento.salvar(orcamento);
        orcamento = new Orcamento();
        atualizaListasOrcamentos();
    }

    public void aceitarPrestador() {
        orcamento.setStatusPrestador("ACEITO");
        orcamento.setDataParecerPrestador(new Date());
        daoOrcamento.alterar(orcamento);
        orcamento = new Orcamento();
        atualizaListasOrcamentos();
    }

    public void recusarPrestador() {
        orcamento.setStatusPrestador("RECUSADO");
        orcamento.setDataParecerPrestador(new Date());
        daoOrcamento.alterar(orcamento);
        orcamento = new Orcamento();
        atualizaListasOrcamentos();
    }

    public void aceitarConsumidor() {
        orcamento.setStatusConsumidor("ACEITO");
        orcamento.setDataParecerConsumidor(new Date());
        daoOrcamento.alterar(orcamento);
        orcamento = new Orcamento();
        atualizaListasOrcamentos();
    }

    public void recusarConsumidor() {
        orcamento.setStatusConsumidor("RECUSADO");
        orcamento.setDataParecerConsumidor(new Date());
        daoOrcamento.alterar(orcamento);
        orcamento = new Orcamento();
        atualizaListasOrcamentos();
    }

    public void vincularPrestador(Prestador prestador) {
        if (orcamento != null) {
            this.orcamento.setPrestador(prestador);
        }
    }

//    public void vincularConsumidor() {
//        if (orcamento != null) {
//            Consumidor consumidorLogado = RetornaConsumidorLogado.retornaLogado();
//            this.orcamento.setConsumidor(consumidorLogado);
//        }
//    }

//---------------------------------------------------------------------CONSULTAS
    private void buscarOrcamentosTotais() {
        listaOrcamento_totais = daoOrcamento.buscarTodos();
    }

//    private void buscarOrcamento_solicitadoPrest() {
//        listaOrcamento_solicitadoPrest = daoOrcamento.buscarCondicao("orcamento.prestador.id = " + prestadorLogado.getId() + " and statusConsumidor = 'SOLICITADO' and statusPrestador = 'PENDENTE'");
//    }
//
//    private void buscarOrcamento_aceitoPrest() {
//        listaOrcamento_aceitoPrest = daoOrcamento.buscarCondicao("orcamento.prestador.id = " + prestadorLogado.getId() + " and statusPrestador = 'ACEITO'");
//    }
//
//    private void buscarOrcamento_recusadoPrest() {
//        listaOrcamento_recusadoPrest = daoOrcamento.buscarCondicao("orcamento.prestador.id = " + prestadorLogado.getId() + " and statusPrestador = 'RECUSADO'");
//    }
//
//    private void buscarOrcamento_solicitadoConsum() {
//        listaOrcamento_solicitadoConsum = daoOrcamento.buscarCondicao("orcamento.consumidor.id = " + consumidorLogado.getId() + " and statusConsumidor = 'SOLICITADO' and statusPrestador = 'PENDENTE'");
//    }
//
//    private void buscarOrcamento_aceitoConsum() {
//        listaOrcamento_aceitoConsum = daoOrcamento.buscarCondicao("orcamento.consumidor.id = " + consumidorLogado.getId() + " and statusConsumidor = 'ACEITO'");
//    }
//
//    private void buscarOrcamento_recusadoConsum() {
//        listaOrcamento_recusadoConsum = daoOrcamento.buscarCondicao("orcamento.consumidor.id = " + consumidorLogado.getId() + " and statusConsumidor = 'RECUSADO'");
//    }

    public void atualizaListasOrcamentos() {
        buscarOrcamentosTotais();
//        buscarOrcamento_solicitadoPrest();
//        buscarOrcamento_aceitoPrest();
//        buscarOrcamento_recusadoPrest();
//        buscarOrcamento_solicitadoConsum();
//        buscarOrcamento_aceitoConsum();
//        buscarOrcamento_recusadoConsum();
    }
    //--------------------------------------------------------------GETTERSETTER

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public DAOGenerico<Orcamento> getDaoOrcamento() {
        return daoOrcamento;
    }

    public void setDaoOrcamento(DAOGenerico<Orcamento> daoOrcamento) {
        this.daoOrcamento = daoOrcamento;
    }

    public List<Orcamento> getListaOrcamento_totais() {
        return listaOrcamento_totais;
    }

    public void setListaOrcamento_totais(List<Orcamento> listaOrcamento_totais) {
        this.listaOrcamento_totais = listaOrcamento_totais;
    }

//    public List<Orcamento> getListaOrcamento_solicitadoPrest() {
//        return listaOrcamento_solicitadoPrest;
//    }
//
//    public void setListaOrcamento_solicitadoPrest(List<Orcamento> listaOrcamento_solicitadoPrest) {
//        this.listaOrcamento_solicitadoPrest = listaOrcamento_solicitadoPrest;
//    }
//
//    public List<Orcamento> getListaOrcamento_aceitoPrest() {
//        return listaOrcamento_aceitoPrest;
//    }
//
//    public void setListaOrcamento_aceitoPrest(List<Orcamento> listaOrcamento_aceitoPrest) {
//        this.listaOrcamento_aceitoPrest = listaOrcamento_aceitoPrest;
//    }
//
//    public List<Orcamento> getListaOrcamento_recusadoPrest() {
//        return listaOrcamento_recusadoPrest;
//    }
//
//    public void setListaOrcamento_recusadoPrest(List<Orcamento> listaOrcamento_recusadoPrest) {
//        this.listaOrcamento_recusadoPrest = listaOrcamento_recusadoPrest;
//    }
//
//    public List<Orcamento> getListaOrcamento_solicitadoConsum() {
//        return listaOrcamento_solicitadoConsum;
//    }
//
//    public void setListaOrcamento_solicitadoConsum(List<Orcamento> listaOrcamento_solicitadoConsum) {
//        this.listaOrcamento_solicitadoConsum = listaOrcamento_solicitadoConsum;
//    }
//
//    public List<Orcamento> getListaOrcamento_aceitoConsum() {
//        return listaOrcamento_aceitoConsum;
//    }
//
//    public void setListaOrcamento_aceitoConsum(List<Orcamento> listaOrcamento_aceitoConsum) {
//        this.listaOrcamento_aceitoConsum = listaOrcamento_aceitoConsum;
//    }
//
//    public List<Orcamento> getListaOrcamento_recusadoConsum() {
//        return listaOrcamento_recusadoConsum;
//    }
//
//    public void setListaOrcamento_recusadoConsum(List<Orcamento> listaOrcamento_recusadoConsum) {
//        this.listaOrcamento_recusadoConsum = listaOrcamento_recusadoConsum;
//    }

    public Prestador getPrestadorLogado() {
        return prestadorLogado;
    }

    public void setPrestadorLogado(Prestador prestadorLogado) {
        this.prestadorLogado = prestadorLogado;
    }

    public Consumidor getConsumidorLogado() {
        return consumidorLogado;
    }

    public void setConsumidorLogado(Consumidor consumidorLogado) {
        this.consumidorLogado = consumidorLogado;
    }

    
}
