package Test;

import org.junit.Test;


import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OffertaDAOTest {
    OffertaDAO prodottoDAO = new OffertaDAO();
    @Test
    public void doRetrieveAll() {

        List<Offerta> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveAll(1, 10));

    }

    @Test
    public void doRetrieveById() {

        List<Offerta> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveById(1));

    }

    @Test
    public void doRetrieveByCategoria() {

        List<Offerta> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByDestinazione(null,1, 10));

    }

    @Test
    public void doSave() {


    	Offerta prodotto= new Offerta(1, "destinazione","descrizione", "data_partenza", "ora_partenza",
    			"data_ritorno","ora_ritorno", "partenza_da", "arrivo_a", "pernottamento",
    			5, 150, null);
        int pippo = prodottoDAO.doSave(prodotto);
        assertEquals(1, pippo);

    }

    @Test
    public void doUpdate() {


    	Offerta prodotto= new Offerta(1234, "destinazione","descrizione", "data_partenza", "ora_partenza",
    			"data_ritorno","oraritorno", "partenzada", "arrivoa", "pernottamento",
    			5, 150, null);
        boolean succ = prodottoDAO.doUpdate(prodotto);

        assertEquals(true, succ);

    }

    @Test
    public void doDelete() {

        int pippo = prodottoDAO.doDelete(4);
        assertEquals(1, pippo);

    }

    @Test
    public void doRetrieveByNomeOrDescrizione() {

        List<Offerta> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByNomeOrDescrizione("nome", 0, 0));

    }

 

    @Test
    public void doRetrieveByServizio() {

        List<Offerta> prodottoList = new ArrayList<>();
        assertNotEquals(prodottoList,prodottoDAO.doRetrieveByServizio(1, 0, 0));

    }
   
   

}