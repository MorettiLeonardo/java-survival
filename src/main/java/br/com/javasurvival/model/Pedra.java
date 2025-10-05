package br.com.javasurvival.model;

public class Pedra extends Recurso {

    public Pedra(int quantidade) {
        super("Pedra", quantidade, 0.8);
    }

    @Override
    public void usar(Jogador jogador) {
        // Verifica se o jogador já usou pedra antes
        if (jogador.isBuffAtivo("Pedra")) {
            System.out.println("⚠️ Você já usou uma pedra para afiar sua arma!");
            return;
        }

        jogador.aumentarDano(5); // aumenta o dano
        jogador.ativarBuff("Pedra"); // registra o buff como ativo

        setQuantidade(getQuantidade() - 1);
        if (getQuantidade() <= 0) {
            System.out.println("A pedra se desgastou e foi consumida.");
        }

        System.out.println("🪨 " + jogador.getNome() + " afiou sua arma com a pedra! Seu ataque ficou mais forte!");
    }
}
