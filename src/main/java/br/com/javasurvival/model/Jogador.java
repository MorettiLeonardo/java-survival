package br.com.javasurvival.model;

import java.util.HashMap;
import java.util.Map;
import br.com.javasurvival.exception.ItemNaoEncontradoException;

public class Jogador extends Personagem {

    private Map<String, Recurso> inventario;

    private int experiencia = 0;
    private int nivel = 1;
    private int proximoNivel = 50;
    private int danoBase = 20;
    private Map<String, Boolean> buffsAtivos = new HashMap<>();

    public Jogador(String nome) {
        super(nome);
        this.inventario = new HashMap<>();
    }

    public boolean isBuffAtivo(String nomeBuff) {
        return buffsAtivos.getOrDefault(nomeBuff, false);
    }

    public void ativarBuff(String nomeBuff) {
        buffsAtivos.put(nomeBuff, true);
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void aumentarDano(int valor) {
        danoBase += valor;
        System.out.println("💪 Seu dano aumentou em " + valor + "! Dano atual: " + danoBase);
    }

    public void resetarDano() {
        danoBase = 10;
    }

    public void coletar(Recurso recurso) {
        if (inventario.containsKey(recurso.getNome())) {
            Recurso existente = inventario.get(recurso.getNome());
            existente.setQuantidade(existente.getQuantidade() + recurso.getQuantidade());
        } else {
            inventario.put(recurso.getNome(), recurso);
        }
        System.out.println(nome + " coletou " + recurso.getQuantidade() + "x " + recurso.getNome());
        ganharExperiencia(3); // +3 XP por coleta
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
        ganharExperiencia(2); // +2 XP ao usar item
    }

    @Override
    public void agir() {
        if (energia < 10) {
            System.out.println("Você está muito cansado para explorar...");
            return;
        }
        energia -= 10;
        aumentarFome(10);
        System.out.println(nome + " explorou a ilha!");
        ganharExperiencia(5);
    }

    @Override
    public void descansar() {
        recuperarEnergia(25);
        diminuirFome(10);
        System.out.println(nome + " descansou e recuperou energia.");
        ganharExperiencia(1);
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

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void ganharExperiencia(int xp) {
        experiencia += xp;
        System.out.println("✨ Você ganhou " + xp + " de experiência! (Total: " + experiencia + "/" + proximoNivel + ")");
        verificarNivel();
    }

    private void verificarNivel() {
        while (experiencia >= proximoNivel) {
            experiencia -= proximoNivel;
            nivel++;
            proximoNivel += 50;
            VIDA_MAXIMA += 10;
            ENERGIA_MAXIMA += 10;
            vida = VIDA_MAXIMA;
            energia = ENERGIA_MAXIMA;
            System.out.println("🏅 " + nome + " subiu para o nível " + nivel + "!");
            System.out.println("❤️ Vida máxima e ⚡ energia aumentadas!");
        }
    }

    @Override
    public String getStatus() {
        return String.format(
                """
                === STATUS DO JOGADOR ===
                Nome: %s
                ❤️ Vida: %d/%d
                ⚡ Energia: %d/%d
                🍗 Fome: %d/%d
                ⭐ Experiência: %d/%d
                🏆 Nível: %d
                🗡️ Dano: %d
                ==========================
                """,
                nome,
                vida, VIDA_MAXIMA,
                energia, ENERGIA_MAXIMA,
                fome, FOME_MAXIMA,
                experiencia, proximoNivel,
                nivel,
                danoBase
        );
    }
}
