package br.com.javasurvival.controller;

import br.com.javasurvival.model.*;
import br.com.javasurvival.service.AventuraService;

public class AventuraController {

    private AventuraService aventuraService;

    public AventuraController() {
        this.aventuraService = new AventuraService();
    }

    public void explorar(Local local, Jogador jogador) {
        System.out.println("🌍 " + jogador.getNome() + " está explorando " + local.getNome() + "...");

        // Se tiver animal, há combate
        if (local.temAnimal()) {
            Animal animal = local.getAnimal();
            System.out.println("⚠️ Um " + animal.getTipo() + " apareceu!");
            animal.atacar(jogador);
            if (!jogador.isVivo()) {
                System.out.println("💀 Você foi derrotado pelo " + animal.getTipo() + "...");
                return;
            }
        } else {
            aventuraService.explorar(local, jogador);
        }

        jogador.agir();
    }
}
