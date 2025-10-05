package br.com.javasurvival.model.Animais;

import br.com.javasurvival.model.Animal;
import br.com.javasurvival.model.Carne;
import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Recurso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lobo extends Animal {
    public Lobo() {
        super("Lobo", 15);
    }

    @Override
    public void atacar(Jogador jogador) {
        System.out.println("🐺 O lobo morde ferozmente!");
        jogador.receberDano(15);
    }

    @Override
    public List<Recurso> gerarDrop() {
        List<Recurso> drops = new ArrayList<>();
        Random random = new Random();

        if (random.nextInt(100) < 70) { // 70% de chance de dropar carne
            drops.add(new Carne(1 + random.nextInt(2))); // 1 ou 2 carnes
        }
        return drops;
    }
}
