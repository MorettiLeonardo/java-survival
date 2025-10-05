package br.com.javasurvival.service;

import br.com.javasurvival.model.Jogador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveService {

    private final String SAVE_PATH = "src/main/resources/data/save.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void salvar(Jogador jogador) {
        try (FileWriter writer = new FileWriter(SAVE_PATH)) {
            gson.toJson(jogador, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo: " + e.getMessage());
        }
    }

    public Jogador carregar() {
        try (FileReader reader = new FileReader(SAVE_PATH)) {
            return gson.fromJson(reader, Jogador.class);
        } catch (IOException e) {
            System.out.println("Nenhum save encontrado, começando novo jogo...");
            return null;
        }
    }
}
