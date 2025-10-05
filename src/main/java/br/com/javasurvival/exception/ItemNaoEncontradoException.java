package br.com.javasurvival.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemNaoEncontradoException extends Exception {

    private final String item;
    private final String jogador;
    private final LocalDateTime momento;

    public ItemNaoEncontradoException(String item, String jogador) {
        super("Item '" + item + "' não encontrado no inventário de " + jogador + ".");
        this.item = item;
        this.jogador = jogador;
        this.momento = LocalDateTime.now();
    }

    public String getItem() {
        return item;
    }

    public String getJogador() {
        return jogador;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] ❌ ItemNaoEncontradoException: %s tentou usar '%s', mas o item não existe no inventário.",
                momento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                jogador,
                item
        );
    }
}
