package Connection;

import java.sql.*;

public class ConnectionFactory {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/ordersbd";
	private static final String USER = "root";
	private static final String PASS = "02021998";

	private static ConnectionFactory singleInstance = new ConnectionFactory();

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
			System.out.println("Conexiune reusita!");
		} catch (SQLException e) {
			System.out.println("Nu s-a putut realiza conexiunea!");
		}
		return connection;
	}

	public static Connection getConnection() {
		return singleInstance.createConection();
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}
}
