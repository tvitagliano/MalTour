package Test;


import org.junit.jupiter.api.Test;


import GestioneOrdini.Carrello;

import GestioneOfferte.Offerta;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CarrelloTest {

    @Test
    void testCarrelloBean() {


        int quantita = 2;
        Offerta offerta1 = new Offerta(10, "Mauritius","meta mare", "30/01/2022", "10:30",
    			"12/02/2022","20:15", "roma fiumicino", "Sir Seewoosagur", "hotel la maison",
    			5, 1500, null);

        Carrello.OffertaQuantita prodottoQuantita = new Carrello.OffertaQuantita(offerta1, quantita);
        String test = prodottoQuantita.getOfferta().toString();

        assertEquals(10, prodottoQuantita.getOfferta().getId());
        assertEquals("Mauritius", prodottoQuantita.getOfferta().getDestinazione());
        assertEquals("meta mare", prodottoQuantita.getOfferta().getDescrizione());
        assertEquals("30/01/2022", prodottoQuantita.getOfferta().getData_partenza());
        assertEquals("10:30", prodottoQuantita.getOfferta().getOra_partenza());
        assertEquals("12/02/2022", prodottoQuantita.getOfferta().getData_ritorno());
        assertEquals("20:15", prodottoQuantita.getOfferta().getOra_ritorno());
        assertEquals("roma fiumicino", prodottoQuantita.getOfferta().getPartenza_da());
        assertEquals("Sir Seewoosagur", prodottoQuantita.getOfferta().getArrivo_a());
        assertEquals("hotel la maison", prodottoQuantita.getOfferta().getPernottamento());
        assertEquals(5, prodottoQuantita.getOfferta().getPosti_disponibili());
        assertEquals(1500, prodottoQuantita.getOfferta().getPrezzoCent());
        assertEquals(null, prodottoQuantita.getOfferta().getServizi());
        assertEquals(test, prodottoQuantita.getOfferta().toString());

    }

}