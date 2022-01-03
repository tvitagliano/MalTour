package Test;



import org.junit.jupiter.api.Test;

import GestioneUtente.Utente;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UtenteTest {

    @Test
    void testUtente() {

        int id = 1;
        String username = "Indirizzo";
        String passwordhash = "token";
        String nome = "Nome";
        String email = "Email";
        int admin = 1;

        Utente utente = new Utente(id, username, passwordhash, nome, email, admin);
        Utente utente1 = new Utente(id, username, passwordhash, nome, email, admin);
        String test = utente.toString();
        String test1 = utente1.toString();


        assertEquals(id, utente.getId());
        assertEquals(username, utente.getUsername());
        assertEquals(passwordhash, utente.getPasswordhash());
        assertEquals(nome, utente.getNome());
        assertEquals(email, utente.getEmail());
        assertEquals(admin, utente.isCliente());
        assertEquals(test, utente.toString());

        utente1.setId(id);
        utente1.setUsername(username);
        utente1.setPasswordhash(passwordhash);
        utente1.setNome(nome);
        utente1.setEmail(email);
        utente1.setGestore(admin);;
        
        assertEquals(id, utente1.getId());
        assertEquals(username, utente1.getUsername());
        assertEquals(passwordhash, utente1.getPasswordhash());
        assertEquals(nome, utente1.getNome());
        assertEquals(email, utente1.getEmail());
        assertEquals(admin, utente1.isCliente());
        assertEquals(test1, utente1.toString());

    }


}