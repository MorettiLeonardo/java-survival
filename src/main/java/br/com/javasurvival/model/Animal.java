package br.com.javasurvival.model;

public class Animal extends Personagem {

    private int dano;
    private String tipo;

    public Animal(String tipo, int dano) {
        super(tipo);
        this.tipo = tipo;
        this.dano = dano;
    }

    @Override
    public void agir() {
        if (Math.random() < 0.3) {
            System.out.println(tipo + " está rugindo perto de você...");
        } else {
            System.out.println(tipo + " está vagando pela área...");
        }
    }

    @Override
    public void descansar() {
    }

    public void atacar(Jogador jogador) {
        System.out.println("⚔️ " + tipo + " atacou " + jogador.getNome() + " causando " + dano + " de dano!");
        jogador.receberDano(dano);
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public String getStatus() {
        return String.format("%s - ❤️ Vida: %d | 🩸 Dano: %d", tipo, vida, dano);
    }
}
