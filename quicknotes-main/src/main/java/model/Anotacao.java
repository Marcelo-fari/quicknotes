package model;

import java.util.Date;

public class Anotacao {
    private int id;
    private String titulo;
    private String conteudo;
    private String data;
    private Categoria categoria;

    public Anotacao() {
    }

    public Anotacao(int id, String titulo, String conteudo, String data, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "\n ————————————————————" +
                "\n Tabela de anotação" +
                "\n ID: " + id +
                "\n Titulo: " + titulo +
                "\n Conteudo: " + conteudo +
                "\n Data: " + data +
                "\n Categoria: " + categoria;
    }

}
