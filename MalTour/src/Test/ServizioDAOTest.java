package Test;

import org.junit.Test;

import GestioneServizi.Servizio;
import GestioneServizi.ServizioDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ServizioDAOTest {

    ServizioDAO categoriaDAO = new ServizioDAO();


    @Test
    public void doRetrieveAll() {

        List<Servizio> categoria = new ArrayList<>();
        assertNotEquals(categoria, categoriaDAO.doRetrieveAll());

    }


    @Test
    public void doSave() {


    	Servizio categoriaValida = new Servizio(10, "Categoria1", "Descrione1");
    	int succ = categoriaDAO.doSave(categoriaValida);
        assertEquals(1, succ);


    }

    @Test
    public void doUpdate() {

    	Servizio categoriaUpdate = new Servizio(4, "CategoriaNuova", "DescrizioneNuova");
        boolean succ = categoriaDAO.doUpdate(categoriaUpdate);

        assertEquals(true, succ);


    }

    @Test
    public void doDelete() {

        int succ = categoriaDAO.doDelete(1);
        assertEquals(1, succ);

    }

    @Test
    public void doRetrieveByNome() {

    	Servizio categoria = new Servizio();

        categoria = categoriaDAO.doRetrieveByNome("Minicrociere");
        assertEquals("Minicrociere", categoria.getNome());

    }

    @Test
    public void doRetrieveByDescrizione() {

    	Servizio categoria = new Servizio();

        categoria = categoriaDAO.doRetrieveByDescrizione("");
        assertEquals("", categoria.getDescrizione());


    }
}