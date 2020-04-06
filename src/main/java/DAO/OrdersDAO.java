package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionFactory;
import Model.Orders;

public class OrdersDAO extends AbstractDAO<Orders> {

	private String createInsertQuery() {
		String sb = "INSERT INTO orders (id, data, total_price, client_id) VALUES (?, ?, ?, ?)";
		return sb;
	}

	/**
	 * Metoda utilizata pentru a insera o comanda noua in baza de date ordersdb. Se
	 * creeaza conexiunea la baza de date. Se pregateste interogarea. Se seteaza
	 * parametrii necesari interogarii. Se executa interogarea si se adaunga o noua
	 * comanda in baza de date
	 * 
	 * @param id         unic pentru fiecare comanda
	 * @param data       sir de caractere
	 * @param totalPrice intreg ce reprezinta suma preturilor tututor produselor
	 * @param clientID   id-ul unic al clientului ce a efectuat comanda
	 * @return
	 */
	public Orders insert(int id, String data, int totalPrice, int clientID) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, data);
			statement.setInt(3, totalPrice);
			statement.setInt(4, clientID);
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
