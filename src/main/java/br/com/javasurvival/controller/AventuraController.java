package br.com.javasurvival.controller;

import br.com.javasurvival.model.Animal;
import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Local;
import br.com.javasurvival.service.AventuraService;
import br.com.javasurvival.service.CombateService;

public class AventuraController {

    private final AventuraService aventuraService;
    private final CombateService combateService;

    public AventuraController() {
        this.aventuraService = new AventuraService();
        this.combateService = new CombateService();
    }

    public void explorar(Local local, Jogador jogador) {
        System.out.println("🌍 " + jogador.getNome() + " está explorando " + local.getNome() + "...");

        if (local.temAnimal()) {
            Animal animal = local.getAnimal();
            combateService.iniciarCombate(jogador, animal);
        } else {
            aventuraService.explorar(local, jogador);
        }

        jogador.agir();
    }
}
