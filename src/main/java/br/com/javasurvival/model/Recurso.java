package br.com.javasurvival.model;

public abstract class Recurso {

    protected String nome;
    protected int quantidade;
    protected double peso;

    public Recurso(String nome, int quantidade, double peso) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public abstract void usar(Jogador jogador);

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + " (x" + quantidade + ")";
    }
}
