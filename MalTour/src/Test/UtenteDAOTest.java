package Test;



import org.junit.Test;

import GestioneUtente.Utente;
import GestioneUtente.UtenteDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtenteDAOTest {

    UtenteDAO utenteDAO = new UtenteDAO();
    Utente utente = new Utente(1,"Angela","titolare01","Angela","angela@maltour.com",1);

    @Test
    public void doRetrieveAll() {
    	List<Utente> utente = new ArrayList<>();
        assertNotEquals(utente, utenteDAO.doRetrieveAll(1, 10));
    }

    @Test
    public void doRetrieveById() {
    	utente = utenteDAO.doRetrieveById(1);
        assertEquals(1, utente.getId());
    }

    @Test
    public void doRetrieveByUsernamePassword() {
    	utente = utenteDAO.doRetrieveByUsernamePassword("Angela", "titolare01");
        assertEquals("Angela", utente.getUsername());
        assertEquals("titolare01", utente.getPasswordhash());
    }

    @Test
    public void doRetrieveByUsername() {
    	utente = utenteDAO.doRetrieveByUsername("Angela");
        assertEquals("Angela", utente.getUsername());
    }

    @Test
    public void doRetrieveByEmail() {
    	utente = utenteDAO.doRetrieveByEmail("angela@maltour.com");
        assertEquals("angela@maltour.com", utente.getEmail());
    }

    @Test
    public void doSave() {
    	boolean succ = utenteDAO.doSave(utente);
        assertEquals(true, succ);
    }

    @Test
    public void doUpdate() {
    	int succ = utenteDAO.doUpdate(utente);
        assertEquals(1, succ);
    }

    @Test
    public void doDelete() {
    	int succ = utenteDAO.doDelete(1);
        assertEquals(1, succ);
    }
    
}