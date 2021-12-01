package GestioneOrdini;


import java.util.ArrayList;
import java.util.List;

import GestioneServizi.Servizio;

public class Ordine {
	private int id;
    private int idutente;
    private int idofferta;
    private String email;
    private boolean stato;
    private ArrayList<ComponentiViaggio> componenti;


    public Ordine() {
    }


	public Ordine(int id, int idutente, int idofferta, String email, boolean stato,
			ArrayList<ComponentiViaggio> componenti) {
		this.id = id;
		this.idutente = idutente;
		this.idofferta = idofferta;
		this.email = email;
		this.stato = stato;
		this.componenti =componenti;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdutente() {
		return idutente;
	}

	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}

	public int getIdofferta() {
		return idofferta;
	}

	public void setIdofferta(int idofferta) {
		this.idofferta = idofferta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}



	public ArrayList<ComponentiViaggio> getComponenti() {
		return (ArrayList<ComponentiViaggio>) componenti;
	}


	public void setComponenti(ArrayList<ComponentiViaggio>componenti) {
		this.componenti = componenti;
	}


	@Override
	public String toString() {
		return "Ordine [id=" + id + ", idutente=" + idutente + ", idofferta=" + idofferta + ", email=" + email
				+ ", stato=" + stato + ", componenti=" + componenti + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componenti == null) ? 0 : componenti.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + idofferta;
		result = prime * result + idutente;
		result = prime * result + (stato ? 1231 : 1237);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordine other = (Ordine) obj;
		if (componenti == null) {
			if (other.componenti != null)
				return false;
		} else if (!componenti.equals(other.componenti))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (idofferta != other.idofferta)
			return false;
		if (idutente != other.idutente)
			return false;
		if (stato != other.stato)
			return false;
		return true;
	}


	
	
    
    

    
}
