package org.viajou.crudviajou.evento;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    // declarando as variaveis da tabela
    private String faixa_etaria;
    private String descricao;
    private String categoria;
    private int capacidade;
    private Time horario;
    private Date data_inicio;
    private Date data_termino;
    private Double preco_pessoa;
    private int id_atracao;
    private int id_tour_virtual;
    //Métodos construdores

    public Evento() {
    }

    public Evento(int capacidade, String categoria, Date data_inicio, Date data_termino, String descricao, String faixa_etaria, Time horario, int id_atracao, int id_tour_virtual, Double preco_pessoa) {
        this.capacidade = capacidade;
        this.categoria = categoria;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.descricao = descricao;
        this.faixa_etaria = faixa_etaria;
        this.horario = horario;
        this.id_atracao = id_atracao;
        this.id_tour_virtual = id_tour_virtual;
        this.preco_pessoa = preco_pessoa;
    }
    //Métodos gets e sets

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData_inicio() {
        return this.data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return this.data_termino;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    public String getFaixa_etaria() {
        return this.faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getHorario() {
        return this.horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getId_atracao() {
        return this.id_atracao;
    }

    public int getId_tour_virtual() {
        return this.id_tour_virtual;
    }

    public Double getPreco_pessoa() {
        return this.preco_pessoa;
    }

    public void setPreco_pessoa(Double preco_pessoa) {
        this.preco_pessoa = preco_pessoa;
    }
    //Fazendo o ToString
    @Override
    public String toString() {
        return "capacidade=" + this.capacidade +
                ", faixa_etaria='" + this.faixa_etaria + '\'' +
                ", descricao='" + this.descricao + '\'' +
                ", categoria='" + this.categoria + '\'' +
                ", horario=" + this.horario +
                ", data_inicio=" + this.data_inicio +
                ", data_termino=" + this.data_termino +
                ", preco_pessoa=" + this.preco_pessoa +
                ", id_atracao=" + this.id_atracao +
                ", id_tour_virtual=" + this.id_tour_virtual;
    }
}
