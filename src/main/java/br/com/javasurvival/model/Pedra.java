package br.com.javasurvival.model;

public class Pedra extends Recurso {

    public Pedra(int quantidade) {
        super("Pedra", quantidade, 0.8);
    }

    @Override
    public void usar(Jogador jogador) {
        System.out.println(jogador.getNome() + " usou pedra. Pode servir como arma ou ferramenta.");
    }
}
