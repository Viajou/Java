package Excursao;

import java.util.Date;

public class Excursao {

    private String nome_empresa;
    private int capacidade;
    private String duracao;
    private String site;
    private double preco_total;
    private Date data_inicio;
    private Date data_termino;
    private String categoria;
    private int ID_atracao;


    public Excursao() {
        this.nome_empresa = nome_empresa;
        this.capacidade = capacidade;
        this.duracao = duracao;
        this.site = site;
        this.preco_total = preco_total;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.categoria = categoria;
        this.ID_atracao = ID_atracao;
    }


    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSite() {
        return site;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getID_atracao() {
        return ID_atracao;
    }

    public String toString() {
        return "Excursao{" +
                "nome_empresa='" + nome_empresa + '\'' +
                ", capacidade=" + capacidade +
                ", duracao='" + duracao + '\'' +
                ", site='" + site + '\'' +
                ", preco_total=" + preco_total +
                ", data_inicio=" + data_inicio +
                ", data_termino=" + data_termino +
                ", categoria='" + categoria + '\'' +
                ", ID_atracao=" + ID_atracao +
                '}';
    }
}
