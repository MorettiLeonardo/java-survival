package br.com.javasurvival.model;

public class Comida extends Recurso {

    private int restaurarFome;
    private int restaurarEnergia;

    public Comida(String nome, int quantidade, int restaurarFome, int restaurarEnergia) {
        super(nome, quantidade, 0.2);
        this.restaurarFome = restaurarFome;
        this.restaurarEnergia = restaurarEnergia;
    }

    @Override
    public void usar(Jogador jogador) {
        jogador.diminuirFome(restaurarFome);
        jogador.recuperarEnergia(restaurarEnergia);
        System.out.println(jogador.getNome() + " comeu " + nome + " e recuperou energia!");
    }
}
