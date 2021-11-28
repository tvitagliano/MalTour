
package GestioneServizi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import GestioneGenerale.ConPool;

public class ServizioDAO {

	public List<Servizio> doRetrieveAll() {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT id, nome, descrizione FROM servizio");
			ArrayList<Servizio> servizi = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Servizio c = new Servizio();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setDescrizione(rs.getString(3));
				servizi.add(c);
			}
			return servizi;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int doSave1(Servizio categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO servizio (nome, descrizione) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescrizione());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di inserimento");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            categoria.setId(rs.getInt(1));
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

	public boolean doUpdate1(Servizio categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE servizio SET nome=?, descrizione=? WHERE id=?");
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescrizione());
            ps.setInt(3, categoria.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di modifica");
            }
            return true;
        } catch (SQLException e) {

            return false;
        }
    }
	
	public int doDelete1(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM servizio WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("Errore nella query di cancellazione");
            }
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Servizio doRetrieveByNome(String nome) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT nome FROM servizio WHERE nome=?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Servizio c = new Servizio();
                c.setNome(rs.getString(1));

                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Servizio doRetrieveByDescrizione(String descrizione) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT descrizione FROM servizio WHERE descrizione=?");
            ps.setString(1, descrizione);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Servizio c = new Servizio();
                c.setDescrizione(rs.getString(1));

                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public void doSave(Servizio servizio) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO servizio (nome, descrizione) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, servizio.getNome());
			ps.setString(2, servizio.getDescrizione());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			servizio.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void doUpdate(Servizio servizio) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE servizio SET nome=?, descrizione=? WHERE id=?");
			ps.setString(1, servizio.getNome());
			ps.setString(2, servizio.getDescrizione());
			ps.setInt(3, servizio.getId());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("UPDATE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void doDelete(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM servizio WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
