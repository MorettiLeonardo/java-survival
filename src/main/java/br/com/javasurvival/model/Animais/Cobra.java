package br.com.javasurvival.model.Animais;

import br.com.javasurvival.model.Animal;
import br.com.javasurvival.model.Comida;
import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Recurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cobra extends Animal {
    public Cobra() {
        super("Cobra", 25);
    }

    @Override
    public void atacar(Jogador jogador) {
        System.out.println("🐍 A cobra te pica! O veneno causa dano contínuo...");
        jogador.receberDano(10);
        jogador.receberDano(5);
    }

    @Override
    public List<Recurso> gerarDrop() {
        List<Recurso> drops = new ArrayList<>();
        Random random = new Random();

        if (random.nextInt(100) < 50) {
            drops.add(new Comida("Veneno de Cobra", 1, 0, 0));
        }

        return drops;
    }
}
