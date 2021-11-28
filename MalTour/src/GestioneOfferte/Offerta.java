
package GestioneOfferte;

import java.util.List;

import GestioneServizi.Servizio;


public class Offerta {
	private int id;
	private String destinazione;
	private String descrizione;
	private String data_partenza;
	private String ora_partenza;
	private String data_ritorno;
	private String ora_ritorno;
	private String partenza_da;
	private String arrivo_a;
	private String pernottamento;
	private int posti_disponibili;
	private long prezzoCent;
	private List<Servizio> servizi;
	
	
	
	public Offerta(int id, String destinazione, String descrizione, String data_partenza, String ora_partenza,
			String data_ritorno, String ora_ritorno, String partenza_da, String arrivo_a, String pernottamento,
			int posti_disponibili, long prezzoCent, List<Servizio> servizi) {
		super();
		this.id = id;
		this.destinazione = destinazione;
		this.descrizione = descrizione;
		this.data_partenza = data_partenza;
		this.ora_partenza = ora_partenza;
		this.data_ritorno = data_ritorno;
		this.ora_ritorno = ora_ritorno;
		this.partenza_da = partenza_da;
		this.arrivo_a = arrivo_a;
		this.pernottamento = pernottamento;
		this.posti_disponibili = posti_disponibili;
		this.prezzoCent = prezzoCent;
		this.servizi = servizi;
	}
	
	public Offerta() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(String data_partenza) {
		this.data_partenza = data_partenza;
	}
	public String getOra_partenza() {
		return ora_partenza;
	}
	public void setOra_partenza(String ora_partenza) {
		this.ora_partenza = ora_partenza;
	}
	public String getData_ritorno() {
		return data_ritorno;
	}
	public void setData_ritorno(String data_ritorno) {
		this.data_ritorno = data_ritorno;
	}
	public String getOra_ritorno() {
		return ora_ritorno;
	}
	public void setOra_ritorno(String ora_ritorno) {
		this.ora_ritorno = ora_ritorno;
	}
	public String getPartenza_da() {
		return partenza_da;
	}
	public void setPartenza_da(String partenza_da) {
		this.partenza_da = partenza_da;
	}
	public String getArrivo_a() {
		return arrivo_a;
	}
	public void setArrivo_a(String arrivo_a) {
		this.arrivo_a = arrivo_a;
	}
	public String getPernottamento() {
		return pernottamento;
	}
	public void setPernottamento(String pernottamento) {
		this.pernottamento = pernottamento;
	}
	public int getPosti_disponibili() {
		return posti_disponibili;
	}
	public void setPosti_disponibili(int posti_disponibili) {
		this.posti_disponibili = posti_disponibili;
	}
	public long getPrezzoCent() {
		return prezzoCent;
	}
	public void setPrezzoCent(long prezzoCent) {
		this.prezzoCent = prezzoCent;
	}
	public List<Servizio> getServizi() {
		return servizi;
	}
	public void setServizi(List<Servizio> servizi) {
		this.servizi = servizi;
	}
	@Override
	public String toString() {
		return "Offerta [id=" + id + ", destinazione=" + destinazione + ", descrizione=" + descrizione
				+ ", data_partenza=" + data_partenza + ", ora_partenza=" + ora_partenza + ", data_ritorno="
				+ data_ritorno + ", ora_ritorno=" + ora_ritorno + ", partenza_da=" + partenza_da + ", arrivo_a="
				+ arrivo_a + ", pernottamento=" + pernottamento + ", posti_disponibili=" + posti_disponibili
				+ ", prezzoCent=" + prezzoCent + ", servizi=" + servizi + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivo_a == null) ? 0 : arrivo_a.hashCode());
		result = prime * result + ((data_partenza == null) ? 0 : data_partenza.hashCode());
		result = prime * result + ((data_ritorno == null) ? 0 : data_ritorno.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((destinazione == null) ? 0 : destinazione.hashCode());
		result = prime * result + id;
		result = prime * result + ((ora_partenza == null) ? 0 : ora_partenza.hashCode());
		result = prime * result + ((ora_ritorno == null) ? 0 : ora_ritorno.hashCode());
		result = prime * result + ((partenza_da == null) ? 0 : partenza_da.hashCode());
		result = prime * result + ((pernottamento == null) ? 0 : pernottamento.hashCode());
		result = prime * result + posti_disponibili;
		result = prime * result + (int) (prezzoCent ^ (prezzoCent >>> 32));
		result = prime * result + ((servizi == null) ? 0 : servizi.hashCode());
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
		Offerta other = (Offerta) obj;
		if (arrivo_a == null) {
			if (other.arrivo_a != null)
				return false;
		} else if (!arrivo_a.equals(other.arrivo_a))
			return false;
		if (data_partenza == null) {
			if (other.data_partenza != null)
				return false;
		} else if (!data_partenza.equals(other.data_partenza))
			return false;
		if (data_ritorno == null) {
			if (other.data_ritorno != null)
				return false;
		} else if (!data_ritorno.equals(other.data_ritorno))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (destinazione == null) {
			if (other.destinazione != null)
				return false;
		} else if (!destinazione.equals(other.destinazione))
			return false;
		if (id != other.id)
			return false;
		if (ora_partenza == null) {
			if (other.ora_partenza != null)
				return false;
		} else if (!ora_partenza.equals(other.ora_partenza))
			return false;
		if (ora_ritorno == null) {
			if (other.ora_ritorno != null)
				return false;
		} else if (!ora_ritorno.equals(other.ora_ritorno))
			return false;
		if (partenza_da == null) {
			if (other.partenza_da != null)
				return false;
		} else if (!partenza_da.equals(other.partenza_da))
			return false;
		if (pernottamento == null) {
			if (other.pernottamento != null)
				return false;
		} else if (!pernottamento.equals(other.pernottamento))
			return false;
		if (posti_disponibili != other.posti_disponibili)
			return false;
		if (prezzoCent != other.prezzoCent)
			return false;
		if (servizi == null) {
			if (other.servizi != null)
				return false;
		} else if (!servizi.equals(other.servizi))
			return false;
		return true;
	}
	
	
	

}