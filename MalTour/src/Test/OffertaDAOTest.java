package Test;

import org.junit.Test;


import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OffertaDAOTest {
    OffertaDAO prodottoDAO = new OffertaDAO();
    List<Offerta> offertaList = new ArrayList<>();
    Offerta offerta = new Offerta(10, "Mauritius","meta mare", "30/01/2022", "10:30",
			"12/02/2022","20:15", "roma fiumicino", "Sir Seewoosagur", "hotel la maison",
			5, 1500, null);
    
    Offerta offerta2 = new Offerta(10, "Mauriti","meta mare", "30/01/2022", "10:30",
			"12/02/2022","20:15", "roma fiumicino", "Sir Seewoosagur", "hotel la maison",
			5, 1500, null);
    
    @Test
    public void doRetrieveAll() {
    	assertNotEquals(offertaList,prodottoDAO.doRetrieveAll(1, 10));
    }

    @Test
    public void doRetrieveById() {

        assertNotEquals(offertaList,prodottoDAO.doRetrieveById(1));

    }

    @Test
    public void doRetrieveByCategoria() {
        assertNotEquals(offertaList,prodottoDAO.doRetrieveByDestinazione(null,1, 10));
    }

    @Test
    public void doSave() {
    	int yes = prodottoDAO.doSave(offerta);
        assertEquals(1, yes);
    }

    @Test
    public void doUpdate() {
        boolean succ = prodottoDAO.doUpdate(offerta2);
        assertEquals(false, succ);
    }

    @Test
    public void doDelete() {
    	int yes = prodottoDAO.doDelete(1);
        assertEquals(1, yes);
    }

    @Test
    public void doRetrieveByNomeOrDescrizione() {
        assertNotEquals(offertaList,prodottoDAO.doRetrieveByNomeOrDescrizione("nome", 0, 0));
    }

 
    @Test
    public void doRetrieveByServizio() {
        assertNotEquals(offertaList,prodottoDAO.doRetrieveByServizio(1, 0, 0));

    }
   
   

}