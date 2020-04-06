package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import Model.Products;

public class ProductsDAO extends AbstractDAO<Products> {

	private String createInsertQuery() {
		String sb = "INSERT INTO products (id, name, producer, quantity, price) VALUES (?, ?, ?, ?, ?)";
		return sb;
	}

	/**
	 * Metoda utilizata pentru a insera un nou produs in baza de date ordersdb. Se
	 * creeaza conexiunea la baza de date. Se pregateste interogarea. Se seteaza
	 * parametrii necesari interogarii. Se executa interogarea si se adaunga un nou
	 * produs in baza de date
	 * 
	 * @param id       unic pentru fiecare produs
	 * @param name     sir de caractere
	 * @param producer sir de caractere ce contine numele producatorului
	 * @param quantity intreg
	 * @param price    intreg
	 * @return
	 */
	public Products insert(int id, String name, String producer, int quantity, int price) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, producer);
			statement.setInt(4, quantity);
			statement.setInt(5, price);
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

	/**
	 * Metoda utilizata pentru a modifica un produs. Singura diferenta fata de
	 * metoda de update() din clasa parinte este ca aceasta metoda este utilizata
	 * special pentru a modifica valoarea corepsunzatore cantitatii din tabelul
	 * products.
	 * 
	 * @param col  coloana ce va fi modificata.
	 * @param cond coloana ce va juca rolul conditiei din clauza "WHERE".
	 * @param val1 noua valoare.
	 * @param val2 valoarea ce va juca rolul conditiei.
	 * @return
	 */
	public Products updateInt(String col, String cond, int val1, int val2) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateQuery(col, cond);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, val1);
			statement.setInt(2, val2);
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
