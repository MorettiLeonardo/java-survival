package br.com.javasurvival.model;

public class Carne extends Comida {

    public Carne(int quantidade) {
        super("Carne", quantidade, 20, 10);
    }

    @Override
    public void usar(Jogador jogador) {
        jogador.diminuirFome(restaurarFome);
        jogador.recuperarEnergia(restaurarEnergia);
        jogador.setVida(Math.min(jogador.getVida() + 15, jogador.getVidaMaxima()));
        System.out.println("🍖 Você comeu carne e recuperou energia e vida!");
    }
}
