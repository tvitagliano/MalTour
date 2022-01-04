package Test;

import org.junit.Test;


import GestioneOfferte.Offerta;
import GestioneOfferte.OffertaDAO;
import GestioneServizi.Servizio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OffertaDAOTest {
    OffertaDAO offertaDAO = new OffertaDAO();

    
    List<Servizio> servizi = new ArrayList<>();
    
    List<Offerta> offertaList = new ArrayList<>();
    
    Offerta offerta = new Offerta(20, "Mauritius","meta mare", "30/01/2022", "10:30",
			"12/02/2022","20:15", "roma fiumicino", "Sir Seewoosagur", "hotel la maison",
			5, 1500,servizi);
    
    Offerta offertaUpdate = new Offerta(4, "Mauriti","meta mare", "30/01/2022", "10:30",
			"12/02/2022","20:15", "roma fiumicino", "Sir Seewoosagur", "hotel la maison",
			5, 1500, servizi);
    
   Offerta offertaServizio = new Offerta(6,"Nord Italia Tour","Il tour si fa strada attraverso incantevoli località come Milano e Torino; costeggia laghi meravigliosi come quelli di Como. Smetti di pensarci troppo: fai rotta verso uno dei percorsi più suggestivi del vecchio continente.","21/12/2021","12:30","28/12/2021","22:10","Roma fiumicino","aerepoporto di havana","hotel ischia",5,9000, servizi);
    
    @Test
    public void doRetrieveAll() {
    	assertNotEquals(offertaList,offertaDAO.doRetrieveAll(1, 10));
    }

    @Test
    public void doRetrieveById() {
    	assertNotEquals(offertaList,offertaDAO.doRetrieveById(1));
    }

    @Test
    public void doSave() {
    	int yes = offertaDAO.doSave(offerta);
        assertEquals(1, yes);
    }

    @Test
    public void doUpdate() {
        boolean succ = offertaDAO.doUpdate(offertaUpdate);
        assertEquals(true, succ);
    }

    @Test
    public void doDelete() {
    	int yes = offertaDAO.doDelete(1);
        assertEquals(1, yes);
    }

    @Test
    public void doRetrieveByNomeOrDescrizione() {
        assertEquals(offertaList,offertaDAO.doRetrieveByNomeOrDescrizione("Singapore", 1, 10));
    }

 
    @Test
    public void doRetrieveByServizio() {
        assertNotEquals(offertaServizio,offertaDAO.doRetrieveByServizio(1, 0, 10));

    }
   
   

}