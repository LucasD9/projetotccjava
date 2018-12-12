package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataExecucao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPrazoMax;
    private Float preco;
    private String descricao;
    @ManyToOne
    private Consumidor consumidor;
    @ManyToOne
    private Prestador prestador;

    private String statusPrestador; //PENDENTE, ACEITO, RECUSADO//
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataParecerPrestador;

    private String statusConsumidor; //SOLICITADO, ACEITO, RECUSADO//
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataParecerConsumidor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Date getDataPrazoMax() {
        return dataPrazoMax;
    }

    public void setDataPrazoMax(Date dataPrazoMax) {
        this.dataPrazoMax = dataPrazoMax;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public String getStatusPrestador() {
        return statusPrestador;
    }

    public void setStatusPrestador(String statusPrestador) {
        this.statusPrestador = statusPrestador;
    }

    public Date getDataParecerPrestador() {
        return dataParecerPrestador;
    }

    public void setDataParecerPrestador(Date dataParecerPrestador) {
        this.dataParecerPrestador = dataParecerPrestador;
    }

    public String getStatusConsumidor() {
        return statusConsumidor;
    }

    public void setStatusConsumidor(String statusConsumidor) {
        this.statusConsumidor = statusConsumidor;
    }

    public Date getDataParecerConsumidor() {
        return dataParecerConsumidor;
    }

    public void setDataParecerConsumidor(Date dataParecerConsumidor) {
        this.dataParecerConsumidor = dataParecerConsumidor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orcamento other = (Orcamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
