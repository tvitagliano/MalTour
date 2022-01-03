package GestioneOrdini;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

import GestioneGenerale.ConPool;


public class OrdineDAO {

	
	public List<Ordine> doRetrieveAll(int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, idutente, idofferta,email, stato FROM ordine LIMIT ?, ?");
			ps.setInt(1, offset);
			ps.setInt(2, limit);
			ArrayList<Ordine> ordine = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ordine p = new Ordine();
				p.setId(rs.getInt(1));
				p.setIdutente(rs.getInt(2));
				p.setIdofferta(rs.getInt(3));
				p.setEmail(rs.getString(4));
				p.setStato(rs.getBoolean(5));

				ordine.add(p);
			}
			return ordine;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<ComponentiViaggio> doRetrieveByOrdine(int ordine, int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, nome, cognome, data_nascita FROM componentiViaggio LEFT JOIN ordine_componenti ON id=idcomponente WHERE idordine=? LIMIT ?, ?");
			ps.setInt(1, ordine);
			ps.setInt(2, offset);
			ps.setInt(3, limit);
			ArrayList<ComponentiViaggio> componenti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComponentiViaggio p = new ComponentiViaggio();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setCognome(rs.getString(3));
				p.setData_nascita(rs.getString(4));
				componenti.add(p);
			}
			return componenti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public int doSave(Ordine ordine) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO ordine (idutente,idofferta, email,stato) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ordine.getIdutente());
			ps.setInt(2, ordine.getIdofferta());
			ps.setString(3, ordine.getEmail());
			ps.setBoolean(4, ordine.isStato());
			
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			ordine.setId(id);

			PreparedStatement psCa = con
					.prepareStatement("INSERT INTO ordine_componenti (idordine, idcomponente) VALUES (?, ?)");
			for (ComponentiViaggio c : ordine.getComponenti()) {
				psCa.setInt(1, id);
				psCa.setInt(2, c.getId());
				psCa.addBatch();
			}
			psCa.executeBatch();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

    public List<Ordine> doRetrieveByUtente(int utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, idutente, idofferta,email,stato FROM ordine WHERE idutente=? ");
            ps.setInt(1, utente);
            ArrayList<Ordine> ordini = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ordine o = new Ordine();
                o.setId(rs.getInt(1));
                o.setIdutente(rs.getInt(2));
                o.setIdofferta(rs.getInt(3));
                o.setEmail(rs.getString(4));
                o.setStato(rs.getBoolean(5));
                ordini.add(o);
            }
            return ordini;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<ComponentiViaggio> getComponenti(Connection con, int idordine) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"SELECT id, nome, cognome, data_nascita FROM componentiViaggio LEFT JOIN ordine_componenti ON id=idordine WHERE idcomponente=?");
		ps.setInt(1, idordine);
		ArrayList<ComponentiViaggio> componenti = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ComponentiViaggio c = new ComponentiViaggio();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setCognome(rs.getString(3));
			c.setData_nascita(rs.getString(3));
			componenti.add(c);
		}
		return componenti;
	}



}
