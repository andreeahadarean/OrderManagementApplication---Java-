package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Model.Producers;

public class ProducersDAO extends AbstractDAO<Producers> {

	private String createInsertQuery() {
		String sb = "INSERT INTO orders (id, name, products) VALUES (?, ?, ?)";
		return sb;
	}

	/**
	 * Metoda utilizata pentru a insera un producator in baza de date ordersdb. Se
	 * creeaza conexiunea la baza de date. Se pregateste interogarea. Se seteaza
	 * parametrii necesari interogarii. Se executa interogarea si se adaunga un nou
	 * producator in baza de date
	 * 
	 * @param id       unic pentru fiecare producator
	 * @param name     sir de caractere
	 * @param products sir de caractere ce reprezinta produsele vandute de un anumit
	 *                 producator
	 * @return
	 */
	public Producers insert(int id, String name, String products) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, products);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
