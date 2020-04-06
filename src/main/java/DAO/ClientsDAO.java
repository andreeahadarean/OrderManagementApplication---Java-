package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionFactory;
import Model.Clients;

public class ClientsDAO extends AbstractDAO<Clients> {

	private String createInsertQuery() {
		String sb = "INSERT INTO clients (id, name, adress) VALUES (?, ?, ?)";
		return sb;
	}

	/**
	 * Metoda utilizata pentru a insera un client in baza de date ordersdb. Se
	 * creeaza conexiunea la baza de date. Se pregateste interogarea. Se seteaza
	 * parametrii necesari interogarii. Se executa interogarea si se adaunga un nou
	 * client in baza de date
	 * 
	 * @param id     unic pentru fiecare client
	 * @param name   sir de caractere
	 * @param adress sir de caractere
	 * @return
	 */
	public Clients insert(int id, String name, String adress) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, adress);
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
