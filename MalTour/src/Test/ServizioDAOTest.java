package Test;

import org.junit.Test;

import GestioneServizi.Servizio;
import GestioneServizi.ServizioDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ServizioDAOTest {

    ServizioDAO servizioDAO = new ServizioDAO();
    List<Servizio> servizio = new ArrayList<>();
    Servizio servizio1 = new Servizio();
	Servizio servizioEsistente = new Servizio(1,"TOUR","tour enogastronomici e culturali, alla scoperta dell italia");
	Servizio servizioDaSalvare = new Servizio(5,"DESTINAZIONE MONTAGNA", "Ci sono tantissimi luoghi che vi attendono, qui abbiamo realizzato una piccola guida ");
	Servizio servizioUpdate = new Servizio(3, "FERIE ESTIVE", "solo qualche giorno libero");
	
    @Test
    public void doRetrieveAll() {
    	assertNotEquals(servizio , servizioDAO.doRetrieveAll());
    }


    @Test
    public void doSave() {
    	int succ = servizioDAO.doSave(servizioDaSalvare);
        assertEquals(1, succ);
    }

    @Test
    public void doUpdate() {
    	boolean succ = servizioDAO.doUpdate(servizioUpdate);
    	assertEquals(true, succ);
    }

    @Test
    public void doDelete() {
    	int succ = servizioDAO.doDelete(2);
        assertEquals(1, succ);
    }

    @Test
    public void doRetrieveByNome() {
    	servizio1 = servizioDAO.doRetrieveByNome("MINICROCIERE");
        assertEquals("MINICROCIERE", servizio1.getNome());
    }

    @Test
    public void doRetrieveByDescrizione() {
    	servizio1 = servizioDAO.doRetrieveByDescrizione("Hai solo qualche giorno libero e stai pensando ad una vacanza in alto mare? Di seguito ti proponiamo un elenco di mini crociere. Si tratta di Crociere che durano meno di 7 giorni, ma avrai la sensazione di viverne molti di più.");
        assertEquals("Hai solo qualche giorno libero e stai pensando ad una vacanza in alto mare? Di seguito ti proponiamo un elenco di mini crociere. Si tratta di Crociere che durano meno di 7 giorni, ma avrai la sensazione di viverne molti di più.", servizio1.getDescrizione());
    }
}