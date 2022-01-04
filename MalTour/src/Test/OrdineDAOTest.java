package Test;



import org.junit.Test;

import GestioneOrdini.ComponentiViaggio;
import GestioneOrdini.Ordine;
import GestioneOrdini.OrdineDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdineDAOTest {
    OrdineDAO ordineDAO = new OrdineDAO();
    ArrayList<ComponentiViaggio> componenti = new ArrayList<>();
    List<Ordine> ordineList = new ArrayList<>();
	Ordine ordineDaSalvare = new Ordine(4, 2, 4, "serena@maltour.com", false, componenti);
    
    @Test
    public void doSave() {
    	int yes = ordineDAO.doSave(ordineDaSalvare);
        assertEquals(1, yes);
    }

    @Test
    public void doRetrieveByUtente() {
    	assertNotEquals(ordineList,ordineDAO.doRetrieveByUtente(2));
    }
    
}