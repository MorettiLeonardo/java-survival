package br.com.javasurvival.service;

import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Pedra;
import br.com.javasurvival.model.Comida;
import br.com.javasurvival.model.Carne;
import br.com.javasurvival.model.Recurso;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveService {

    private static final String SAVE_PATH = "src/main/resources/data/save.txt";

    public void salvar(Jogador jogador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_PATH))) {
            writer.write("nome=" + jogador.getNome() + "\n");
            writer.write("vida=" + jogador.getVida() + "\n");
            writer.write("energia=" + jogador.getEnergia() + "\n");
            writer.write("fome=" + jogador.getFome() + "\n");
            writer.write("nivel=" + jogador.getNivel() + "\n");
            writer.write("experiencia=" + jogador.getExperiencia() + "\n");
            writer.write("dano=" + jogador.getDanoBase() + "\n");

            // salva o inventário num formato simples
            writer.write("inventario=");
            for (Map.Entry<String, Recurso> entry : jogador.getInventario().entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue().getQuantidade() + ",");
            }
            writer.newLine();

            System.out.println("💾 Jogo salvo com sucesso (save.txt)!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public Jogador carregar() {
        File file = new File(SAVE_PATH);
        if (!file.exists()) {
            System.out.println("📂 Nenhum save encontrado. Iniciando novo jogo...");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_PATH))) {
            String linha;
            Map<String, String> dados = new HashMap<>();

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("=", 2);
                if (partes.length == 2) {
                    dados.put(partes[0], partes[1]);
                }
            }

            Jogador jogador = new Jogador(dados.get("nome"));
            jogador.setVida(Integer.parseInt(dados.get("vida")));
            jogador.setEnergia(Integer.parseInt(dados.get("energia")));
            jogador.setFome(Integer.parseInt(dados.get("fome")));
            jogador.ganharExperiencia(Integer.parseInt(dados.get("experiencia")));
            jogador.setDanoBase(Integer.parseInt(dados.get("dano")));

            // reconstrói inventário
            if (dados.containsKey("inventario")) {
                String[] itens = dados.get("inventario").split(",");
                for (String item : itens) {
                    if (item.isBlank()) continue;
                    String[] partes = item.split(":");
                    String nomeItem = partes[0];
                    int quantidade = Integer.parseInt(partes[1]);

                    switch (nomeItem.toLowerCase()) {
                        case "pedra" -> jogador.coletar(new Pedra(quantidade));
                        case "carne" -> jogador.coletar(new Carne(quantidade));
                        case "coco" -> jogador.coletar(new Comida("Coco", quantidade, 15, 10));
                        default -> System.out.println("Item desconhecido no save: " + nomeItem);
                    }
                }
            }

            System.out.println("✅ Jogo carregado com sucesso (save.txt)!");
            return jogador;

        } catch (IOException e) {
            System.out.println("⚠️ Erro ao carregar o save: " + e.getMessage());
            return null;
        }
    }
}
