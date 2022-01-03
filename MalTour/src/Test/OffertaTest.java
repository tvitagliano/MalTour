package Test;

import org.junit.jupiter.api.Test;

import GestioneOfferte.Offerta;
import GestioneServizi.Servizio;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OffertaTest {

    private int id;
    private String nome;
    private String descrizione;
    private long prezzoBase;
    private int iva;
    private List<Servizio> categorie;
    private Servizio Rame = new Servizio();


    @Test
    void testProdotto() {

        int id = 1;
        String nome = "Indirizzo";
        String descrizione = "token";
        long prezzoBase = 2000;
        int iva = 22;
        int idcategoria = 1;


        Offerta prodotto = new Offerta(1234, "destinazione","descrizione", "data_partenza", "ora_partenza",
    			"data_ritorno","ora_ritorno", "partenza_da", "arrivo_a", "pernottamento",
    			5, 150, null);
        Offerta prodotto1 = new Offerta(1234, "destinazione","descrizione", "data_partenza", "ora_partenza",
    			"data_ritorno","ora_ritorno", "partenza_da", "arrivo_a", "pernottamento",
    			5, 150, null);
        String test = prodotto.toString();
        String test1 = prodotto1.toString();


        assertEquals(id, prodotto.getId());
        assertEquals(nome, prodotto.getDestinazione());
        assertEquals(descrizione, prodotto.getDescrizione());
        assertEquals(prezzoBase, prodotto.getData_partenza());
        assertEquals(iva, prodotto.getOra_partenza());
        assertEquals(idcategoria, prodotto.getData_ritorno());
        assertEquals(idcategoria, prodotto.getPartenza_da());
        assertEquals(idcategoria, prodotto.getArrivo_a());
        assertEquals(idcategoria, prodotto.getPernottamento());
        assertEquals(idcategoria, prodotto.getPosti_disponibili());
        assertEquals(idcategoria, prodotto.getPrezzoCent());
        assertEquals(idcategoria, prodotto.getServizi());
        assertEquals(test, prodotto.toString());

        prodotto1.setId(id);
        prodotto1.setDescrizione(descrizione);
        String destinazione=" ";
		prodotto1.setDestinazione(destinazione);
        String data_partenza=" ";
		prodotto1.setData_partenza(data_partenza);
        String ora_partenza=" ";
		prodotto1.setOra_partenza(ora_partenza);
        String data_ritorno=" ";
		prodotto1.setData_ritorno(data_ritorno);
        String ora_ritorno=" ";
		prodotto1.setOra_ritorno(ora_ritorno);
        String partenza_da=" ";
		prodotto1.setPartenza_da(partenza_da);
        String arrivo_a=" ";
		prodotto1.setArrivo_a(arrivo_a);
        String pernottamento=" ";
		prodotto1.setPernottamento(pernottamento);
        long prezzoCent=150;
		prodotto1.setPrezzoCent(prezzoCent);
        prodotto1.setServizi(categorie);
        
        
        assertEquals(id, prodotto1.getId());
        assertEquals(nome, prodotto1.getDestinazione());
        assertEquals(descrizione, prodotto1.getDescrizione());
        assertEquals(prezzoBase, prodotto1.getData_partenza());
        assertEquals(iva, prodotto1.getOra_partenza());
        assertEquals(idcategoria, prodotto1.getData_ritorno());
        assertEquals(idcategoria, prodotto1.getPartenza_da());
        assertEquals(idcategoria, prodotto1.getArrivo_a());
        assertEquals(idcategoria, prodotto1.getPernottamento());
        assertEquals(idcategoria, prodotto1.getPosti_disponibili());
        assertEquals(idcategoria, prodotto1.getPrezzoCent());
        assertEquals(idcategoria, prodotto1.getServizi());
        assertEquals(test1, prodotto1.toString());

    }


}