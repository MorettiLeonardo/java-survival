import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Pedra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedraTest {

    @Test
    void deveAumentarODanoDoJogador() {
        Jogador jogador = new Jogador("Leo");
        Pedra pedra = new Pedra(1);

        int danoAntes = jogador.getDanoBase();
        pedra.usar(jogador);

        assertTrue(jogador.getDanoBase() > danoAntes);
        assertTrue(jogador.isBuffAtivo("Pedra"));
    }

    @Test
    void naoDevePermitirUsarPedraDuasVezes() {
        Jogador jogador = new Jogador("Leo");
        Pedra pedra = new Pedra(2);

        pedra.usar(jogador);
        int danoDepois = jogador.getDanoBase();

        pedra.usar(jogador); // tentar usar de novo
        assertEquals(danoDepois, jogador.getDanoBase(), "O dano não deve aumentar mais de uma vez");
    }
}
