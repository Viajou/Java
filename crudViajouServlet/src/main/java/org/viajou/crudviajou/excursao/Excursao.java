package org.viajou.crudviajou.excursao;

import java.util.Date;

public class Excursao {
    // Declarando os atributos
    private String nomeEmpresa;
    private int capacidade;
    private String duracao;
    private String site;
    private double precoTotal;
    private Date dataInicio;
    private Date dataTermino;
    private String categoria;
    private int idAtracao;
//  Métodos construtores
    // Construto
    public Excursao(String nomeEmpresa, int capacidade, String duracao, String site, double precoTotal, java.sql.Date dataInicio, java.sql.Date dataTermino, String categoria, int idAtracao) {
        this.nomeEmpresa = nomeEmpresa;
        this.capacidade = capacidade;
        this.duracao = duracao;
        this.site = site;
        this.precoTotal = precoTotal;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.categoria = categoria;
        this.idAtracao = idAtracao;
    }

    public String getNomeEmpresa() { return this.nomeEmpresa; }

    public void setNomeEmpresa(String nomeEmpresa) {
            this.nomeEmpresa = nomeEmpresa;
        }

    public int getCapacidade() { return this.capacidade; }

    public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }

    public String getDuracao() {
            return this.duracao;
        }

    public void setDuracao(String duracao) {
            this.duracao = duracao;
        }

    public String getSite() {
            return this.site;
        }

    public void setSite(String site) {
            this.site = site;
        }

    public double getPrecoTotal() {
            return this.precoTotal;
        }

    public void setPrecoTotal(double precoTotal) {
            this.precoTotal = precoTotal;
        }

    public Date getDataInicio() {
            return this.dataInicio;
        }

    public void setDataInicio(Date dataInicio) {
            this.dataInicio = dataInicio;
        }

    public Date getDataTermino() {
            return this.dataTermino;
        }

    public void setDataTermino(Date dataTermino) {
            this.dataTermino = dataTermino;
        }

    public String getCategoria() {
            return this.categoria;
        }

    public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

    public int getIdAtracao() {
            return this.idAtracao;
        }


    public String toString() {
        return "Nome da Empresa: "+ nomeEmpresa +
                "\nCapacidade: "+ capacidade +
                "\nDuracao: "+ duracao +
                "\nSite: "+ site +
                "\nPreco total: "+ precoTotal +
                "\nData de início: "+ dataInicio +
                "\nData de termino: "+ dataTermino +
                "\nCategoria: "+ categoria +
                "idAtracao: "+ idAtracao;
    }
}
