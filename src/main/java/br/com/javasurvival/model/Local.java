package br.com.javasurvival.model;

import java.util.ArrayList;
import java.util.List;

public class Local {

    private String nome;
    private List<Recurso> recursos;
    private Animal animal; // opcional

    public Local(String nome) {
        this.nome = nome;
        this.recursos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void adicionarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean temAnimal() {
        return animal != null && animal.isVivo();
    }

    public String getDescricao() {
        return "🌍 Local: " + nome +
                (temAnimal() ? " | Animal: " + animal.getTipo() : " | Sem animais perigosos.");
    }
}
