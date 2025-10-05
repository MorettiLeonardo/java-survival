package br.com.javasurvival.model;

import java.util.HashMap;
import java.util.Map;
import br.com.javasurvival.exception.ItemNaoEncontradoException;

public class Jogador extends Personagem {

    private Map<String, Recurso> inventario;

    public Jogador(String nome) {
        super(nome);
        this.inventario = new HashMap<>();
    }

    public void coletar(Recurso recurso) {
        if (inventario.containsKey(recurso.getNome())) {
            Recurso existente = inventario.get(recurso.getNome());
            existente.setQuantidade(existente.getQuantidade() + recurso.getQuantidade());
        } else {
            inventario.put(recurso.getNome(), recurso);
        }
        System.out.println(nome + " coletou " + recurso.getQuantidade() + "x " + recurso.getNome());
    }

    public void usarItem(String nomeItem) throws ItemNaoEncontradoException {
        Recurso recurso = inventario.get(nomeItem);
        if (recurso == null) {
            throw new ItemNaoEncontradoException("Item '" + nomeItem + "' não encontrado no inventário!");
        }

        recurso.usar(this);
        recurso.setQuantidade(recurso.getQuantidade() - 1);

        if (recurso.getQuantidade() <= 0) {
            inventario.remove(nomeItem);
        }
    }

    // Implementação de métodos abstratos
    @Override
    public void agir() {
        if (energia < 10) {
            System.out.println("Você está muito cansado para explorar...");
            return;
        }
        energia -= 10;
        aumentarFome(10);
        System.out.println(nome + " explorou a ilha!");
    }

    @Override
    public void descansar() {
        recuperarEnergia(25);
        diminuirFome(10);
        System.out.println(nome + " descansou e recuperou energia.");
    }

    public Map<String, Recurso> getInventario() {
        return inventario;
    }

    public void exibirInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("📦 Inventário de " + nome + ":");
            inventario.values().forEach(r ->
                    System.out.println("- " + r.getNome() + " (x" + r.getQuantidade() + ")")
            );
        }
    }
}
