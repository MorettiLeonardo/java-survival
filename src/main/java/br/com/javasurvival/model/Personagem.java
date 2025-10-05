package br.com.javasurvival.model;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int energia;
    protected int fome;

    protected int VIDA_MAXIMA = 100;
    protected int ENERGIA_MAXIMA = 100;
    protected final int FOME_MAXIMA = 100;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = VIDA_MAXIMA;
        this.energia = ENERGIA_MAXIMA;
        this.fome = 0;

    }

    public int getVidaMaxima() {
        return this.VIDA_MAXIMA;
    }

    public abstract void agir();

    public abstract void descansar();

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }

    public void recuperarEnergia(int valor) {
        this.energia += valor;
        if (this.energia > ENERGIA_MAXIMA) this.energia = ENERGIA_MAXIMA;
    }

    public void aumentarFome(int valor) {
        this.fome += valor;
        if (this.fome > FOME_MAXIMA) this.fome = FOME_MAXIMA;
    }

    public void diminuirFome(int valor) {
        this.fome -= valor;
        if (this.fome < 0) this.fome = 0;
    }

    public boolean isVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFome() {
        return fome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = Math.max(0, Math.min(vida, VIDA_MAXIMA));
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, Math.min(energia, ENERGIA_MAXIMA));
    }

    public void setFome(int fome) {
        this.fome = Math.max(0, Math.min(fome, FOME_MAXIMA));
    }

    public String getStatus() {
        return String.format(
                "%s - ❤️ Vida: %d | ⚡ Energia: %d | 🍗 Fome: %d",
                nome, vida, energia, fome
        );
    }
}
