package com.example.servletviajou.Model;

import java.sql.Date;
import java.sql.Time;

public class Eventos {
    // Declarando dos atributos
    private int id;
    private String faixaEtaria;
    private String descricao;
    private int capacidade;
    private Time horario;
    private Date dataInicio;
    private Date dataTermino;
    private double precoPessoa;
    private int idAtracao;
    private int idTourVirtual;
    private Date dataCriacao;
    private Date dataAtualizacao;

//  Métodos Construtores

    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Eventos( int capacidade,  Date dataInicio, Date dataTermino, String descricao, String faixaEtaria, Time horario, int idAtracao, int idTourVirtual, double precoPessoa) {
        this.id = id;
        this.capacidade = capacidade;
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
    public Eventos() {
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

    // DataCriacao
    public Date getDataCriacao() { return this.dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return this.dataAtualizacao; }
    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    //Método toString
    public String toString() {
        return "Capacidade: " + this.capacidade +
                "\nFaixa etária: " + this.faixaEtaria +
                "\nDescrição: " + this.descricao +
                "\nHorário: " + this.horario +
                "\nData de início do evento: " + this.dataInicio +
                "\nData de término do evento: " + this.dataTermino +
                "\nId da atração: " + this.idAtracao+
                "\nId do Tour Virtual: " + this.idTourVirtual +
                "\nData de criação do evento: " + this.dataCriacao +
                "\nData da última atualizacao: " + this.dataAtualizacao;
    }
}
