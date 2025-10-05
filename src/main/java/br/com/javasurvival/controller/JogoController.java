package br.com.javasurvival.controller;

import br.com.javasurvival.model.*;
import br.com.javasurvival.service.*;
import br.com.javasurvival.view.ConsoleView;
import java.util.Scanner;

public class JogoController {

    private Jogador jogador;
    private Mapa mapa;
    private ConsoleView view;
    private AventuraController aventuraController;
    private JogadorController jogadorController;
    private SaveService saveService;
    private Scanner sc;

    public JogoController() {
        this.view = new ConsoleView();
        this.mapa = new Mapa();
        this.aventuraController = new AventuraController();
        this.jogadorController = new JogadorController();
        this.saveService = new SaveService();
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        view.exibirMensagem("🏝️ Bem-vindo ao Java Survival!");

        // 🔹 Tenta carregar o save
        Jogador jogadorSalvo = saveService.carregar();
        if (jogadorSalvo != null) {
            view.exibirMensagem("💾 Progresso encontrado!");
            view.exibirMensagem("Deseja continuar o jogo salvo? (S/N)");
            String opcao = sc.nextLine().trim().toUpperCase();

            if (opcao.equals("S")) {
                this.jogador = jogadorSalvo;
                view.exibirMensagem("Jogador " + jogador.getNome() + " carregado com sucesso!");
            } else {
                criarNovoJogador();
            }
        } else {
            criarNovoJogador();
        }

        loopPrincipal();
    }

    private void criarNovoJogador() {
        view.exibirMensagem("Digite seu nome: ");
        String nome = sc.nextLine();
        this.jogador = new Jogador(nome);
    }

    private void loopPrincipal() {
        boolean jogando = true;

        while (jogando && jogador.isVivo()) {
            view.exibirMenuPrincipal();
            int opcao = view.lerOpcaoUsuario();

            switch (opcao) {
                case 1 -> explorar();
                case 2 -> jogadorController.descansar(jogador);
                case 3 -> jogadorController.usarItem(jogador, view);
                case 4 -> jogador.exibirInventario();
                case 5 -> mostrarStatus();
                case 6 -> salvarJogo();
                case 0 -> jogando = false;
                default -> view.exibirMensagem("⚠️ Opção inválida!");
            }
        }

        view.exibirMensagem("🏁 Fim de jogo! Obrigado por jogar.");
    }

    private void mostrarStatus() {
        view.exibirMensagem("\n=== STATUS DO JOGADOR ===");
        view.exibirMensagem(jogador.getStatus());
    }

    private void explorar() {
        view.exibirMensagem("\nPara onde deseja ir?");
        mapa.getLocais().keySet().forEach(local -> System.out.println("- " + local));
        String destino = sc.nextLine();

        Local local = mapa.getLocal(destino);
        if (local == null) {
            view.exibirMensagem("❌ Esse local não existe!");
            return;
        }

        aventuraController.explorar(local, jogador);
    }

    private void salvarJogo() {
        saveService.salvar(jogador);
    }
}
