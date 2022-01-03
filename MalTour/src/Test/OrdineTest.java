package Test;



import org.junit.jupiter.api.Test;

import GestioneOrdini.ComponentiViaggio;
import GestioneOrdini.Ordine;
import GestioneUtente.Utente;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class OrdineTest {

    @Test
    void testOrdine() {

        int id = 1;
        String indirizzo = "Indirizzo";
        String prezzo = "token";
        Utente utente = new Utente(1, "username", "password", "nome","email", 1);
        Ordine ordine = new Ordine(1,2, 3, "email", false, null );

        assertNotNull(ordine);
        String test = ordine.toString();

        assertEquals(id, ordine.getId());
        assertEquals(indirizzo, ordine.getEmail());
        assertEquals(prezzo, ordine.getIdofferta());
        assertEquals(utente, ordine.getIdutente());
        assertEquals(utente, ordine.getComponenti());
        assertEquals(test, ordine.toString());



    }


}