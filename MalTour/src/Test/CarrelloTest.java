package Test;


import org.junit.jupiter.api.Test;


import GestioneOrdini.Carrello;

import GestioneOfferte.Offerta;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CarrelloTest {

    @Test
    void testCarrelloBean() {


        int quantita = 2;
        Offerta prodotto = new Offerta(1234, "destinazione","descrizione", "data_partenza", "ora_partenza",
    			"data_ritorno","ora_ritorno", "partenza_da", "arrivo_a", "pernottamento",
    			5, 150, null);

        Carrello.OffertaQuantita prodottoQuantita = new Carrello.OffertaQuantita(prodotto, quantita);
        String test = prodottoQuantita.getOfferta().toString();

        assertEquals(10, prodottoQuantita.getOfferta().getId());
        assertEquals("Prova", prodottoQuantita.getOfferta().getDestinazione());
        assertEquals("Desc", prodottoQuantita.getOfferta().getDescrizione());
        assertEquals(20, prodottoQuantita.getOfferta().getData_partenza());
        assertEquals(20, prodottoQuantita.getOfferta().getOra_partenza());
        assertEquals(20, prodottoQuantita.getOfferta().getData_ritorno());
        assertEquals(20, prodottoQuantita.getOfferta().getOra_ritorno());
        assertEquals(20, prodottoQuantita.getOfferta().getPartenza_da());
        assertEquals(20, prodottoQuantita.getOfferta().getArrivo_a());
        assertEquals(20, prodottoQuantita.getOfferta().getPernottamento());
        assertEquals(22, prodottoQuantita.getOfferta().getPosti_disponibili());
        assertEquals(20, prodottoQuantita.getOfferta().getPrezzoCent());
        assertEquals(1, prodottoQuantita.getOfferta().getServizi());
        assertEquals(test, prodottoQuantita.getOfferta().toString());

    }


}