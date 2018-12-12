package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Consumidor extends Pessoa implements Serializable {

    @ManyToOne
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
