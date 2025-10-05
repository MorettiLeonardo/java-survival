package br.com.javasurvival.service;

import br.com.javasurvival.model.*;

import java.util.Random;

public class AventuraService {

    private Random random = new Random();

    public void explorar(Local local, Jogador jogador) {
        System.out.println("🌍 " + jogador.getNome() + " está explorando " + local.getNome() + "...");

        if (local.temAnimal()) {
            Animal animal = local.getAnimal();
            System.out.println("⚠️ Um " + animal.getTipo() + " apareceu!");
            animal.atacar(jogador);
        } else {
            if (random.nextBoolean() && !local.getRecursos().isEmpty()) {
                Recurso recurso = local.getRecursos().get(random.nextInt(local.getRecursos().size()));
                jogador.coletar(recurso);
            } else {
                System.out.println("Nada encontrado dessa vez...");
            }
        }

        jogador.agir();
    }
}
