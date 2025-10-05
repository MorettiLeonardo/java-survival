package br.com.javasurvival.controller;

import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.exception.ItemNaoEncontradoException;
import br.com.javasurvival.view.ConsoleView;

import java.util.Scanner;

public class JogadorController {

    private Scanner sc = new Scanner(System.in);

    public void descansar(Jogador jogador) {
        jogador.descansar();
    }

    public void usarItem(Jogador jogador, ConsoleView view) {
        jogador.exibirInventario();
        view.exibirMensagem("Digite o nome do item para usar:");
        String nomeItem = sc.nextLine();

        try {
            jogador.usarItem(nomeItem);
        } catch (ItemNaoEncontradoException e) {
            view.exibirMensagem(e.getMessage());
        }
    }
}
