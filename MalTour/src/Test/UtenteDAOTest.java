package Test;

import org.junit.Test;

import GestioneUtente.Utente;
import GestioneUtente.UtenteDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtenteDAOTest {

    UtenteDAO utenteDAO = new UtenteDAO();
    Utente utenteSucc =new Utente();
    List<Utente> utente = new ArrayList<>();
    Utente utenteDaSalvare = new Utente(7,"Giovanni01","Giov234","Giovanni","giovanni@gmail.com",1);
    Utente utenteUpdate = new Utente(2,"Giovanni01","Giov234","Giovanni","serena@maltour.com",1);
    
    @Test
    public void doRetrieveAll() {
    	
        assertNotEquals(utente, utenteDAO.doRetrieveAll(1, 10));
    }

    @Test
    public void doRetrieveById() {
    	utenteSucc = utenteDAO.doRetrieveById(1);
        assertEquals(1, utenteSucc.getId());
    }

    @Test
    public void doRetrieveByUsernamePassword() {
    	utenteSucc = utenteDAO.doRetrieveByUsernamePassword("Angela", "titolare01");
        assertEquals("Angela", utenteSucc.getUsername());

    }

    @Test
    public void doRetrieveByUsername() {
    	utenteSucc = utenteDAO.doRetrieveByUsername("Angela");
        assertEquals("Angela", utenteSucc.getUsername());
    }

    @Test
    public void doRetrieveByEmail() {
    	utenteSucc = utenteDAO.doRetrieveByEmail("angela@maltour.com");
        assertEquals("angela@maltour.com", utenteSucc.getEmail());
    }

    @Test
    public void doSave() {
    	boolean succ = utenteDAO.doSave(utenteDaSalvare);
        assertEquals(true, succ);
    }


    @Test
    public void doDelete() {
    	int succ = utenteDAO.doDelete(1);
        assertEquals(1, succ);
    }
    
}