package br.com.javasurvival.controller;

import br.com.javasurvival.model.*;
import br.com.javasurvival.service.AventuraService;
import br.com.javasurvival.service.SaveService;
import br.com.javasurvival.view.ConsoleView;
import java.util.Scanner;

public class JogoController {

    private Jogador jogador;
    private Mapa mapa;
    private ConsoleView view;
    private AventuraService aventuraService;
    private SaveService saveService;
    private Scanner sc;

    public JogoController() {
        this.view = new ConsoleView();
        this.mapa = new Mapa();
        this.aventuraService = new AventuraService();
        this.saveService = new SaveService();
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        view.exibirMensagem("🏝️ Bem-vindo ao Java Survival!");
        view.exibirMensagem("Digite seu nome: ");
        String nome = sc.nextLine();

        jogador = new Jogador(nome);

        boolean jogando = true;
        while (jogando && jogador.isVivo()) {
            view.exibirMenuPrincipal();
            int opcao = view.lerOpcaoUsuario();

            switch (opcao) {
                case 1 -> explorar();
                case 2 -> descansar();
                case 3 -> usarItem();
                case 4 -> verInventario();
                case 5 -> salvarJogo();
                case 0 -> jogando = false;
                default -> view.exibirMensagem("Opção inválida!");
            }
        }

        view.exibirMensagem("🏁 Fim de jogo! Obrigado por jogar.");
    }

    private void explorar() {
        view.exibirMensagem("Para onde deseja ir?");
        mapa.getLocais().keySet().forEach(l -> System.out.println("- " + l));
        String destino = sc.nextLine();
        Local local = mapa.getLocal(destino);
        if (local == null) {
            view.exibirMensagem("Esse local não existe!");
            return;
        }
        aventuraService.explorar(local, jogador);
    }

    private void descansar() {
        jogador.descansar();
    }

    private void usarItem() {
        jogador.exibirInventario();
        view.exibirMensagem("Qual item deseja usar?");
        String nomeItem = sc.nextLine();
        try {
            jogador.usarItem(nomeItem);
        } catch (Exception e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    private void verInventario() {
        jogador.exibirInventario();
    }

    private void salvarJogo() {
        saveService.salvar(jogador);
        view.exibirMensagem("💾 Jogo salvo com sucesso!");
    }
}
