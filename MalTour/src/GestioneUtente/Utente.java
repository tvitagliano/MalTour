
package GestioneUtente;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Utente {
	private int id;
	private String username;
	private String passwordhash;
	private String nome;
	private String email;
	private int gestore;

	
	
	public Utente(int id, String username, String passwordhash, String nome, String email, int gestore) {
		this.id = id;
		this.username = username;
		this.passwordhash = passwordhash;
		this.nome = nome;
		this.email = email;
		this.gestore = gestore;
	}
	

	public Utente() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(password.getBytes(StandardCharsets.UTF_8));
			this.passwordhash = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int gestore() {
		return gestore;
	}

	public void setGestione(int gestore) {
		this.gestore = gestore;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", passwordhash=" + passwordhash + ", nome=" + nome
				+ ", email=" + email + ", gestore=" + gestore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gestore;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((passwordhash == null) ? 0 : passwordhash.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Utente other = (Utente) obj;
		if (gestore != other.gestore)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (passwordhash == null) {
			if (other.passwordhash != null)
				return false;
		} else if (!passwordhash.equals(other.passwordhash))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
