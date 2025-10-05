package br.com.javasurvival.model;

public class Madeira extends Recurso {

    public Madeira(int quantidade) {
        super("Madeira", quantidade, 0.5);
    }

    @Override
    public void usar(Jogador jogador) {
        System.out.println(jogador.getNome() + " usou madeira. Pode servir para construir abrigo.");
    }
}
