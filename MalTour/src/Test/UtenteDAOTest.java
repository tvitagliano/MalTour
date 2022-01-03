package Test;



import org.junit.Test;

import GestioneUtente.Utente;
import GestioneUtente.UtenteDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtenteDAOTest {

    UtenteDAO utenteDAO = new UtenteDAO();


    @Test
    public void doRetrieveAll() {

        List<Utente> utente = new ArrayList<>();
        assertNotEquals(utente, utenteDAO.doRetrieveAll(1, 10));

    }

    @Test
    public void doRetrieveById() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveById(1);
        assertEquals(1, utente.getId());
    }

    @Test
    public void doRetrieveByUsernamePassword() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByUsernamePassword("Giovanni", "password1");
        assertEquals("Giovanni", utente.getUsername());
        assertEquals("password1", utente.getPasswordhash());

    }

    @Test
    public void doRetrieveByUsername() {
        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByUsername("Giovanni");
        assertEquals("Giovanni", utente.getUsername());
    }

    @Test
    public void doRetrieveByEmail() {

        Utente utente = new Utente();

        utente = utenteDAO.doRetrieveByEmail("");
        assertEquals("utente1@libero.it", utente.getEmail());
    }

    @Test
    public void doSave() {

        Utente utente = new Utente(5, "Prova", "Prova", "Email", "Prova", 1);

        boolean succ = utenteDAO.doSave(utente);
        assertEquals(true, succ);


    }

    @Test
    public void doUpdate() {
    	
    	Utente utente1 = new Utente(5, "Prova", "Prova", "Email", "Prova", 1);
        int succ = utenteDAO.doUpdate(utente1);
        assertEquals(1, succ);



    }

    @Test
    public void doDelete() {

        int succ = utenteDAO.doDelete(1);
        assertEquals(1, succ);

    }
}