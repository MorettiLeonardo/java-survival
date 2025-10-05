package br.com.javasurvival.view;

import java.util.Scanner;

public class ConsoleView {

    private Scanner sc = new Scanner(System.in);

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirMenuPrincipal() {
        System.out.println("""
                \n=== MENU PRINCIPAL ===
                1 - Explorar
                2 - Descansar
                3 - Usar item
                4 - Ver inventário
                5 - Mostrar status
                6 - Salvar jogo
                0 - Sair
                =======================
                Escolha uma opção:
                """);
    }

    public int lerOpcaoUsuario() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
