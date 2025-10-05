package br.com.javasurvival.model;

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
        floresta.adicionarRecurso(new Madeira(3));
        floresta.setAnimal(new Animal("Javali", 15));

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
