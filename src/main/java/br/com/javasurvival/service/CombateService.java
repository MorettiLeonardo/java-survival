package br.com.javasurvival.service;

import br.com.javasurvival.model.Animal;
import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Recurso;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CombateService {
    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    public void iniciarCombate(Jogador jogador, Animal animal) {
        System.out.println("\n⚔️ Iniciando combate contra um " + animal.getTipo() + "!");

        while (jogador.isVivo() && animal.isVivo()) {
            System.out.println("\n1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();

            if (escolha == 1) atacar(jogador, animal);
            else if (escolha == 2) {
                if (random.nextBoolean()) {
                    System.out.println("🏃 Você conseguiu fugir!");
                    return;
                } else {
                    System.out.println("❌ Você tentou fugir, mas o animal te alcançou!");
                }
            }

            if (animal.isVivo()) animal.atacar(jogador);
        }

        if (jogador.isVivo()) {
            System.out.println("🏆 Você venceu o combate!");
            jogador.ganharExperiencia(20);
            droparItem(jogador, animal);
        } else {
            System.out.println("💀 Você foi derrotado...");
        }
    }

    private void droparItem(Jogador jogador, Animal animal) {
        List<Recurso> drops = animal.gerarDrop();
        for (Recurso recurso : drops) {
            jogador.coletar(recurso);
            System.out.println("🎁 Você encontrou " + recurso.getQuantidade() + "x " + recurso.getNome() + "!");
        }
    }

    private void atacar(Jogador jogador, Animal animal) {
        int dano = jogador.getDanoBase() + new Random().nextInt(6);

        System.out.println("🗡️ Você atacou o " + animal.getTipo() + " causando " + dano + " de dano!");
        animal.receberDano(dano);
    }
}
