  
package GestioneGenerale;


import java.sql.Connection;

import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class ConPool {
	private static DataSource datasource;

	public static Connection getConnection() throws SQLException {
		 Logger logger=Logger.getLogger("ConPool.java");
		if (datasource == null) {
			PoolProperties p = new PoolProperties();
			p.setUrl("jdbc:mysql://localhost:3306/maltour?serverTimezone=" + TimeZone.getDefault().getID());
			p.setDriverClassName("com.mysql.cj.jdbc.Driver");
			p.setUsername("root");
			p.setPassword("Password7");
			p.setMaxActive(100);
			p.setInitialSize(10);
			p.setMinIdle(10);
			p.setRemoveAbandonedTimeout(60);
			p.setRemoveAbandoned(true);
			datasource = new DataSource();
			logger.info("Entarto in ConPool.java");
			datasource.setPoolProperties(p);
		}
		return datasource.getConnection();
	}
}
