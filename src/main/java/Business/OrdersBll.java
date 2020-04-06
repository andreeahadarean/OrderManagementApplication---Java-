package Business;

import java.util.*;
import javax.swing.JTable;
import DAO.OrdersDAO;
import Model.Orders;

/**
 * Clasa este utilizata pentru a efectua operatii logice asupra claselor din
 * pachetul Model. Clasa poate fi instantiata doar din clasele existente in
 * pachetul Presentation.
 * 
 * @author Andreea Roxana Hadarean
 *
 */
public class OrdersBll {

	public OrdersDAO ordersDAO = new OrdersDAO();

	/**
	 * Metoda are rolul de a gasi comanda cu un anumit id. Se apeleaza metoda
	 * findById(id) din clasa OrdersDAO, metoda mostenita din clasa AbstractDAO. In
	 * caz de succes, comanda cu id-ul specificat este returnat.
	 * 
	 * @param id reprezinta o valoare intreaga, unica pentru fiecare comanda.
	 * @return un obiect de tipul Orders.
	 */
	public Orders findByID(int id) {
		Orders comanda = ordersDAO.findById(id);
		if (comanda == null)
			System.out.println("Comanda nu exista in baza de date!");
		return comanda;
	}

	/**
	 * Metoda are rolul de a gasi toate comenzile din baza de date. Se apeleaza
	 * metoda selectAll() din clasa OrdersDAO, metoda mostenita din clasa
	 * AbstractDAO. In caz de succes, metoda va returna o lista de comenzi.
	 * 
	 * @return o lista de comenzi.
	 */
	public List<Orders> selectAll() {
		List<Orders> comenzi = ordersDAO.selectAll();
		if (comenzi == null)
			System.out.println("Exista comenzi in baza de date!");
		return comenzi;
	}

	/**
	 * Metoda are rolul de a modifica valorile coloanelor de tipul VARCHAR a unei
	 * comenzi din baza de date. Se apeleaza metoda de update din clasa OrdersDAO,
	 * metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return null in caz de succes.
	 */
	public Orders update(String col, String cond, String val1, int val2) {
		Orders comanda = ordersDAO.update(col, cond, val1, val2);
		if (comanda != null)
			System.out.println("Comanda nu poate fi modificata!");
		return comanda;
	}

	/**
	 * Metoda are rolul de a sterge o comanda din baza de date. Se apeleaza metoda
	 * de stergere din clasa OrdersDAO, metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param field campul in functie de care se va realiza stergerea.
	 * @param val   valoarea in functie de care se va realiza stergerea.
	 */
	public void delete(String field, int val) {
		ordersDAO.delete(field, val);
	}

	/**
	 * Metoda are rolul de a insera o comanda in baza de date. Se apeleaza metoda de
	 * insert, metoda implementata in clasa OrdersDAO.
	 * 
	 * @param id          valoare unica pentru fiecare comanda
	 * @param data        sir de carcatere ce reprezinta data curenta
	 * @param total_price pretul total al comenzii
	 * @param client_id   id-ul unic al clientului ce a efectuat comanda
	 * @return null in caz de succes
	 */
	public Orders insert(int id, String data, int total_price, int client_id) {
		Orders comanda = ordersDAO.insert(id, data, total_price, client_id);
		if (comanda != null) {
			System.out.println("Comanda nu a fost introdus in baza de date");
		}
		return comanda;
	}

	/**
	 * Metoda utilizata pentru a crea un tabel ce va contine comenzile din baza de
	 * date. Se apeleaza metoda pentru a crea tabelul, metoda mostenita de clasa
	 * OrdersDAO din clasa parinte AbstractDAO.
	 * 
	 * @param orders o lista de comenzi ce va fi inserata in tabel.
	 * @return un obiect de tipul JTable.
	 */
	public JTable createTable(List<Orders> orders) {
		JTable table;
		OrdersDAO o = new OrdersDAO();
		table = o.createTable(orders);
		return table;
	}

}
