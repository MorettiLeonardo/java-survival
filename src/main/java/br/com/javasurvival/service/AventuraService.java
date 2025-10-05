package br.com.javasurvival.service;

import br.com.javasurvival.model.*;
import br.com.javasurvival.model.Animais.Cobra;
import br.com.javasurvival.model.Animais.Lobo;
import br.com.javasurvival.model.Animais.Urso;

import java.util.Random;

public class AventuraService {

    private Random random = new Random();

    public void explorar(Local local, Jogador jogador) {
        System.out.println("🌍 " + jogador.getNome() + " está explorando " + local.getNome() + "...");

        if (random.nextInt(100) < 15) {
            Animal animal = gerarAnimalAleatorio();
            System.out.println("⚠️ Você encontrou um " + animal.getNome() + "!");
            new CombateService().iniciarCombate(jogador, animal);
        } else {
            System.out.println("🍃 Você explorou tranquilamente e encontrou alguns recursos.");
            jogador.ganharExperiencia(5);
            gerarRecursosAleatorios(jogador);
        }
    }

    private Animal gerarAnimalAleatorio() {
        int tipo = random.nextInt(3);
        return switch (tipo) {
            case 0 -> new Lobo();
            case 1 -> new Urso();
            default -> new Cobra();
        };
    }

    private void gerarRecursosAleatorios(Jogador jogador) {
        int quantidade = 1 + random.nextInt(3); // de 1 a 3 recursos
        for (int i = 0; i < quantidade; i++) {
            int tipo = random.nextInt(100);
            if (tipo < 50) {
                Comida coco = new Comida("Coco", 1 + random.nextInt(2), 15, 10);
                jogador.coletar(coco);
            } else {
                Pedra pedra = new Pedra(1 + random.nextInt(3)); // 1 a 3 pedras
                jogador.coletar(pedra);
            }
        }
    }

}
