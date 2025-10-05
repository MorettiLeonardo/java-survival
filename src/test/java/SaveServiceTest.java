import br.com.javasurvival.model.Jogador;
import br.com.javasurvival.model.Pedra;
import br.com.javasurvival.service.SaveService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaveServiceTest {

    @Test
    void deveSalvarECarregarJogadorCorretamente() {
        SaveService saveService = new SaveService();
        Jogador original = new Jogador("Leo");
        original.coletar(new Pedra(3));
        original.aumentarDano(5);

        saveService.salvar(original);
        Jogador carregado = saveService.carregar();

        assertNotNull(carregado);
        assertEquals(original.getNome(), carregado.getNome());
        assertEquals(original.getInventario().size(), carregado.getInventario().size());
        assertEquals(original.getDanoBase(), carregado.getDanoBase());
    }
}
