import br.com.javasurvival.exception.ItemNaoEncontradoException;
import br.com.javasurvival.model.Comida;
import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Pedra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogadorTest {

    private Jogador jogador;

    @BeforeEach
    void setUp() {
        jogador = new Jogador("Leo");
    }

    @Test
    void deveColetarItemCorretamente() {
        Pedra pedra = new Pedra(2);
        jogador.coletar(pedra);
        assertTrue(jogador.getInventario().containsKey("Pedra"));
        assertEquals(2, jogador.getInventario().get("Pedra").getQuantidade());
    }

    @Test
    void deveUsarItemComidaEDiminuirQuantidade() throws ItemNaoEncontradoException {
        Comida coco = new Comida("Coco", 1, 15, 10);
        jogador.coletar(coco);

        int fomeAntes = jogador.getFome();
        jogador.usarItem("Coco");

        assertTrue(jogador.getFome() <= fomeAntes);
        assertFalse(jogador.getInventario().containsKey("Coco"));
    }

    @Test
    void deveLancarExcecaoAoUsarItemInexistente() {
        assertThrows(ItemNaoEncontradoException.class, () -> jogador.usarItem("Espada"));
    }
}
