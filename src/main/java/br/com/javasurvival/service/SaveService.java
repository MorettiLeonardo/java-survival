package br.com.javasurvival.service;

import br.com.javasurvival.model.Jogador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveService {

    private static final String SAVE_PATH = "src/main/resources/data/save.json";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void salvar(Jogador jogador) {
        try (FileWriter writer = new FileWriter(SAVE_PATH)) {
            gson.toJson(jogador, writer);
            System.out.println("💾 Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public Jogador carregar() {
        try (FileReader reader = new FileReader(SAVE_PATH)) {
            return gson.fromJson(reader, Jogador.class);
        } catch (com.google.gson.JsonIOException e) {
            System.out.println("⚠️ Save antigo ou incompatível detectado. Criando novo jogo...");
            return null;
        } catch (IOException e) {
            System.out.println("Nenhum save encontrado. Iniciando novo jogo...");
            return null;
        } catch (Exception e) {
            System.out.println("⚠️ Erro ao carregar save. Criando novo jogo...");
            return null;
        }
    }
}
