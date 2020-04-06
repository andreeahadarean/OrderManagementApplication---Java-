package DAO;

import java.util.*;
import javax.swing.JTable;
import java.beans.*;
import java.lang.reflect.*;
import java.sql.*;
import Connection.*;

/**
 * Clasa generica in care sunt definite operatiile comune (Update, Delete,
 * FindById, SelectAll) utilizate pentru a accesa un tabel.
 * 
 * @author Andreea Roxana Hadarean
 *
 * @param <T> poate fi oricare dintre clasele din pachetul Model.
 */
public class AbstractDAO<T> {

	public final Class<T> type;

	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Metoda prin care se creeaza o interogare generica de tipul "SELECT * FROM
	 * table WHERE field = value".
	 * 
	 * @param field reprezinta campul utilizat in conditia "WHERE" a interogarii.
	 * @return Un String ce va reprezenta interogarea generica.
	 */
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName().toLowerCase());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}

	/**
	 * Metoda realizaeaza conexiunea la baza de date ordersdb prin metoda
	 * getConnection() din clasa ConnectionFactory. Se pregateste interogarea ce va
	 * fi executata. Valoarea parametrului id se va folosi pentru conditia
	 * interogarii Se exe ecuta interogarea si rezultatul se pastreaza intr-un
	 * obiect de tipul ResultSet.
	 * 
	 * @param id valoarea intreaga utilizata in interogare.
	 * @return Un obiect de tipul T.
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
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
	 * Pentru fiecare rezultat al interogarii se creeaza o noua instanta de tip T.
	 * Pentru fiecare camp al clasei T se obtine valuarea campului respectiv, se
	 * obtine setterul pentru camp si se seteaza valoarea.
	 * 
	 * @param resultSet rezultatul interogarii.
	 * @return O lista de obiecte de tipul T.
	 */
	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Se creeaza un String ce contine o interogare de forma "SELECT * FROM table".
	 * 
	 * @return String-ul ce contine interogarea.
	 */
	private String createSelectAllQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName().toLowerCase());
		return sb.toString();
	}

	/**
	 * Metoda utilizata pentru a extrage toate elementele dintr-un tabel din baza de
	 * date ordersdb. Se creeaza conexiunea la baza de date. Se pregateste
	 * interogarea si mai apoi se executa, rezultatul stocandu-se intr-un obiect de
	 * tipul ResultSet.
	 * 
	 * @return O lista de obiecte de tipul T.
	 */
	public List<T> selectAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAllQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	protected String createUpdateQuery(String col, String cond) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName().toLowerCase());
		sb.append(" SET ");
		sb.append(col + "=" + "?");
		sb.append(" WHERE ");
		sb.append(cond + "=" + "?");
		return sb.toString();
	}

	/**
	 * Metoda utilizata pentru a executa o interogare de tipul "UPDATE tabel SET col
	 * = val1 WHERE cond = val2. Se creeaza conexiunea la baza de date ordersdb. Se
	 * pregateste interogarea. Se seteaza parametrii. Se executa operatia de update.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return Null in cazul in care operatia s-a realizat cu succes.
	 */
	public T update(String col, String cond, String val1, int val2) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateQuery(col, cond);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, val1);
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

	private String createDeleteQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName().toLowerCase());
		sb.append(" WHERE ");
		sb.append(field + "=?");
		return sb.toString();
	}

	/**
	 * Metoda utilizata pentru stergerea unui element din baza de date. Se creeaza
	 * conexiunea la baza de date. Se pregateste interogarea de tipul "DELETE FROM
	 * table WHERE field = value". Se executa interogarea.
	 * 
	 * @param field numele coloanei ce va juca rolul conditiei.
	 * @param value valoarea in functie de care se va realiza stergerea.
	 */
	public void delete(String field, int value) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createDeleteQuery(field);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, value);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * Metoda utilizata pentru a obtine coloanele unui tabel din baza de date
	 * ordersdb. Se creeaza conexiunea la baza de date. Se executa o interogare de
	 * tipul "SELECT * FROM table" ce se stocheaza in resultSet. Numarul de coloane
	 * si numele acestora se obtin din MetaDate-le obiectului de tipul ResultSet.
	 * 
	 * @return Un sir de String-uri ce contin numele coloanelor tabelului respectiv.
	 */
	public String[] retrieveColumns() {
		String[] columnsRetrieved;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData rsmd = null;
		String query = createSelectAllQuery();
		int columnNr = 0;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			rsmd = resultSet.getMetaData();
			columnNr = rsmd.getColumnCount();
			columnsRetrieved = new String[columnNr + 1];
			String[] columns = new String[columnNr];
			int j = 0;
			for (int i = 1; i <= columnNr; i++) {
				columnsRetrieved[i] = rsmd.getColumnName(i);
				columns[j] = columnsRetrieved[i];
				j++;
			}
			return columns;
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
	 * Metoda utilizata pentru a crea un tabel. Se obtin coloanele respectivului
	 * tabel. Se pregateste o matrice ce va contine datele Pentru fiecare obiect se
	 * parcurge fiecare camp, se face public, se obtine valoarea acestuia si se
	 * adauga in matrice
	 * 
	 * @param objects lista ce contine datele ce vor fi adaugate in tabel
	 * @return Un obiect de tipul JTable
	 */
	public JTable createTable(List<T> objects) {
		JTable table;
		String[] columns = retrieveColumns();
		String[][] data = new String[50][columns.length];
		int columnNr = 0;
		int lineNr = 0;
		for (int i = 0; i < objects.size(); i++) {
			for (Field field : objects.get(i).getClass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object value = field.get(objects.get(i));
					data[lineNr][columnNr] = value.toString();
					columnNr++;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			lineNr++;
			columnNr = 0;
		}
		table = new JTable(data, columns);
		return table;
	}
}
