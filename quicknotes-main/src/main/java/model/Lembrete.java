package model;

import java.util.Date;

public class Lembrete {
    private int id;
    private Date dataHora;
    private Anotacao anotacao;

    public Lembrete() {}

    public Lembrete(Date dataHora, Anotacao anotacao) {
        this.dataHora = dataHora;
        this.anotacao = anotacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Anotacao getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(Anotacao anotacao) {
        this.anotacao = anotacao;
    }

    // ... Outros getters e setters
}
