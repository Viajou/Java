package org.viajou.crudviajou.excursao;

import java.util.Date;

public class Excursao {
    // Declarando os atributos
    private int id;
    private String nomeEmpresa;
    private int capacidade;
    private String duracao;
    private String site;
    private double precoTotal;
    private Date dataInicio;
    private Date dataTermino;
    private String categoria;
    private int idAtracao;
    private Date dataCriacao;
    private Date dataAtualizacao;

  // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Excursao(String nomeEmpresa, int capacidade, String duracao, String site, double precoTotal,
                    java.sql.Date dataInicio, java.sql.Date dataTermino, String categoria, int idAtracao) {
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
    // Construtor Vazio
    public Excursao() {}

// Getters e Setters
    // O ID não pode ser alterado, então apenas o método get é criado para acessá-lo
    public int getId() { return this.id; }

    // NomeEmpresa
    public String getNomeEmpresa() { return this.nomeEmpresa; }

    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }

    // Capacidade
    public int getCapacidade() { return this.capacidade; }

    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    // Duracao
    public String getDuracao() { return this.duracao; }

    public void setDuracao(String duracao) { this.duracao = duracao; }

    // Site
    public String getSite() { return this.site; }

    public void setSite(String site) { this.site = site; }


    // PrecoTotal
    public double getPrecoTotal() { return this.precoTotal; }

    public void setPrecoTotal(double precoTotal) { this.precoTotal = precoTotal; }

    // DataInicio
    public Date getDataInicio() { return this.dataInicio; }

    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    // DataTermino
    public Date getDataTermino() { return this.dataTermino; }

    public void setDataTermino(Date dataTermino) { this.dataTermino = dataTermino; }


    // Categoria
    public String getCategoria() { return this.categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    // IdAtracao
    public int getIdAtracao() { return this.idAtracao; }

    // DataCriacao
    public Date getDataCriacao() { return dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return this.dataAtualizacao;}

    public void setDataAtualizacao(Date dataAtualizacao) {}

// toString
    public String toString() {
        return "Nome da Empresa: " + nomeEmpresa +
                "\nCapacidade: " + capacidade +
                "\nDuracao: " + duracao +
                "\nSite: " + site +
                "\nPreco total: " + precoTotal +
                "\nData de início: " + dataInicio +
                "\nData de termino: " + dataTermino +
                "\nCategoria: " + categoria +
                "\nidAtracao: " + idAtracao +
                "\nData de criacao: " + dataCriacao +
                "\nData da última atualização: " + dataAtualizacao;
    }
}
