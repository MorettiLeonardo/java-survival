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
        view.exibirMensagem("Digite seu nome: ");
        String nome = sc.nextLine();

        jogador = new Jogador(nome);

        boolean jogando = true;
        while (jogando && jogador.isVivo()) {
            view.exibirMenuPrincipal();
            int opcao = view.lerOpcaoUsuario();

            switch (opcao) {
                case 1 -> explorar();
                case 2 -> jogadorController.descansar(jogador);
                case 3 -> jogadorController.usarItem(jogador, view);
                case 4 -> jogador.exibirInventario();
                case 5 -> salvarJogo();
                case 0 -> jogando = false;
                default -> view.exibirMensagem("⚠️ Opção inválida!");
            }
        }

        view.exibirMensagem("🏁 Fim de jogo! Obrigado por jogar.");
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
        view.exibirMensagem("💾 Jogo salvo com sucesso!");
    }
}
