
package GestioneUtente;

import java.sql.Connection;
import java.util.logging.Logger;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import GestioneGenerale.ConPool;


public class UtenteDAO {

	public List<Utente> doRetrieveAll(int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, username, passwordhash, nome, email, gestore FROM utente LIMIT ?, ?");
			ps.setInt(1, offset);
			ps.setInt(2, limit);
			ArrayList<Utente> utenti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Utente u = new Utente();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPasswordhash(rs.getString(3));
				u.setNome(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setGestione(rs.getInt(6));
				utenti.add(u);
			}
			return utenti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
    public int verificaGestore(String email) {
    	Logger logger=Logger.getLogger("verificaGestore.java");
    	logger.info("Apro una connessione in getCodiceUtente di AdminBean.java");
    	int gestore = 0;
    	try (Connection con = ConPool.getConnection()) {
    		PreparedStatement ps = con
					.prepareStatement("SELECT email from utente where gestore = ?");
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		rs.next();
				rs.getInt(gestore);
				return gestore;
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		throw new RuntimeException(e);
    	}
}

	public Utente doRetrieveByUsernamePassword(String username, String password) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, username, passwordhash, nome, email, gestore FROM utente WHERE username=? AND passwordhash=SHA1(?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setPasswordhash(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setEmail(rs.getString(5));
				p.setGestione(rs.getInt(6));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Utente doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, username, passwordhash, nome, email, gestore FROM utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setUsername(rs.getString(2));
                p.setPasswordhash(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setGestione(rs.getInt(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public Utente doRetrieveByUsername(String username) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, username, passwordhash, nome, email, gestore FROM utente WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setPasswordhash(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setEmail(rs.getString(5));
				p.setGestione(rs.getInt(6));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean doSave(Utente utente) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO utente (username, passwordhash, nome, email, gestore) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, utente.getUsername());
			ps.setString(2, utente.getPasswordhash());
			ps.setString(3, utente.getNome());
			ps.setString(4, utente.getEmail());
			ps.setInt(5, utente.gestore());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			utente.setId(rs.getInt(1));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int doUpdate(Utente utente) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE utente SET  username=?, passwordhash=?, nome=?, email=? WHERE id=?");
			ps.setString(2, utente.getUsername());
			ps.setString(3,utente.getPasswordhash());
			ps.setString(3,utente.getNome());
			ps.setString(3,utente.getEmail());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("UPDATE error.");
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public Utente doRetrieveByEmail(String email) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT email, gestore FROM utente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setEmail(rs.getString(1));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public int doDelete(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
