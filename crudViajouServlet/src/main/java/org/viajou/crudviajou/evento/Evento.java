package org.viajou.crudviajou.evento;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    // Declarando dos atributos
    private int id;
    private String faixaEtaria;
    private String descricao;
    private String categoria;
    private int capacidade;
    private Time horario;
    private Date dataInicio;
    private Date dataTermino;
    private double precoPessoa;
    private int idAtracao;
    private int idTourVirtual;

//  Métodos Construtores

    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Evento(int capacidade, String categoria, Date dataInicio, Date dataTermino, String descricao, String faixaEtaria, Time horario, int idAtracao, int idTourVirtual, double precoPessoa) {
        this.capacidade = capacidade;
        this.categoria = categoria;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.faixaEtaria = faixaEtaria;
        this.horario = horario;
        this.idAtracao = idAtracao;
        this.idTourVirtual = idTourVirtual;
        this.precoPessoa = precoPessoa;
    }

    // Construtor Vazio
    public Evento() {
    }

//  Métodos Getters e Setters
    // O ID não pode ser alterado, então apenas o método get é criado para acessá-lo
    public int getId(){ return this.id; }

    // Capacidade
    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // Categoria
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // DataInicio
    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    // DataTermino
    public Date getDataTermino() {
        return this.dataTermino;
    }

    public void setdataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    // FaixaEtaria
    public String getFaixaEtaria() {
        return this.faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    // Descricao
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Horario
    public Time getHorario() {
        return this.horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    // IdAtracao
    public int getIdAtracao() {
        return this.idAtracao;
    }

    // IdTourVirtual
    public int getIdTourVirtual() {
        return this.idTourVirtual;
    }

    // PrecoPessoa
    public double getPrecoPessoa() {
        return this.precoPessoa;
    }

    public void setPrecoPessoa(double precoPessoa) {
        this.precoPessoa = precoPessoa;
    }

    //Método toString
    public String toString() {
        return "Capacidade: "+ this.capacidade +
                "\nFaixa etária: "+ this.faixaEtaria +
                "\nDescrição: "+ this.descricao +
                "\nCategoria: "+ this.categoria +
                "\nHorário: "+ this.horario +
                "\nData de início do evento: "+ this.dataInicio +
                "\nData de término do evento: "+ this.dataTermino +
                "\nId da atração: "+ this.idAtracao+
                "\nId do Tour Virtual: "+ this.idTourVirtual;
    }
}
