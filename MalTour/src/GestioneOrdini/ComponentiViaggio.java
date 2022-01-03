package GestioneOrdini;




public class ComponentiViaggio {
	private int id;
	private String nome;
	private String cognome;
	private String data_nascita;
	
	
	public ComponentiViaggio() {
		
	}
	
	public ComponentiViaggio(int id, String nome, String cognome, String data_nascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getData_nascita() {
		return data_nascita;
	}



	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}



	@Override
	public String toString() {
		return "ComponentiViaggio [id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((data_nascita == null) ? 0 : data_nascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + id;
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
		ComponentiViaggio other = (ComponentiViaggio) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (data_nascita == null) {
			if (other.data_nascita != null)
				return false;
		} else if (!data_nascita.equals(other.data_nascita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
