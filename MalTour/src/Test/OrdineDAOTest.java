package Test;



import org.junit.Test;

import GestioneOrdini.Ordine;
import GestioneOrdini.OrdineDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdineDAOTest {
    OrdineDAO ordineDAO = new OrdineDAO();
    @Test
    public void doSave() {

    	Ordine ordine = new Ordine(1, 2, 3, "", false, null);
        int pippo = ordineDAO.doSave(ordine);
        assertEquals(1, pippo);

    }

    @Test
    public void doRetrieveByUtente() {

        List<Ordine> ordineList = new ArrayList<>();
        assertNotEquals(ordineList,ordineDAO.doRetrieveByUtente(2));

    }
}