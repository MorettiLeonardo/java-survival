package br.com.javasurvival.model.Animais;

import br.com.javasurvival.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Urso extends Animal {
    public Urso() { super("Urso", 25); }

    @Override
    public void atacar(Jogador jogador) {
        System.out.println("🐻 O urso te acerta com uma patada poderosa!");
        jogador.receberDano(25);
    }

    @Override
    public List<Recurso> gerarDrop() {
        List<Recurso> drops = new ArrayList<>();
        Random random = new Random();

        if (random.nextInt(100) < 80) {
            drops.add(new Carne(2 + random.nextInt(2))); // 2 ou 3 carnes
        }

        if (random.nextInt(100) < 25) {
            drops.add(new Comida("Ervas Medicinais", 1, 0, 0));
        }

        return drops;
    }
}
