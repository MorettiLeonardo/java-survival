package br.com.javasurvival.model;

import br.com.javasurvival.model.Animais.Lobo;

import java.util.HashMap;
import java.util.Map;

public class Mapa {

    private Map<String, Local> locais;

    public Mapa() {
        locais = new HashMap<>();
        carregarMapaPadrao();
    }

    private void carregarMapaPadrao() {
        Local praia = new Local("Praia");
        praia.adicionarRecurso(new Comida("Coco", 2, 15, 10));

        Local floresta = new Local("Floresta");
        floresta.setAnimal(new Lobo());

        Local montanha = new Local("Montanha");
        montanha.adicionarRecurso(new Pedra(4));

        locais.put("praia", praia);
        locais.put("floresta", floresta);
        locais.put("montanha", montanha);
    }

    public Local getLocal(String nome) {
        return locais.get(nome.toLowerCase());
    }

    public Map<String, Local> getLocais() {
        return locais;
    }
}
