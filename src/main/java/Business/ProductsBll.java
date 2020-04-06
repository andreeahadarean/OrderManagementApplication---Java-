package Business;

import java.util.*;
import javax.swing.JTable;
import DAO.ProductsDAO;
import Model.Products;

/**
 * Clasa este utilizata pentru a efectua operatii logice asupra claselor din
 * pachetul Model. Clasa poate fi instantiata doar din clasele existente in
 * pachetul Presentation.
 * 
 * @author Andreea Roxana Hadarean
 *
 */

public class ProductsBll {

	public ProductsDAO productsDAO = new ProductsDAO();

	/**
	 * Metoda are rolul de a gasi produsul cu un anumit id. Se apeleaza metoda
	 * findById(id) din clasa ProductsDAO, metoda mostenita din clasa AbstractDAO.
	 * In caz de succes, comanda cu id-ul specificat este returnat.
	 * 
	 * @param id reprezinta o valoare intreaga, unica pentru fiecare produs.
	 * @return un obiect de tipul Products.
	 */
	public Products findByID(int id) {
		Products produs = productsDAO.findById(id);
		if (produs == null)
			System.out.println("Produsul nu exista in baza de date!");
		return produs;
	}

	/**
	 * Metoda are rolul de a gasi toate produsele din baza de date. Se apeleaza
	 * metoda selectAll() din clasa ProductsDAO, metoda mostenita din clasa
	 * AbstractDAO. In caz de succes, metoda va returna o lista de comenzi.
	 * 
	 * @return o lista de produse.
	 */
	public List<Products> selectAll() {
		List<Products> produse = productsDAO.selectAll();
		if (produse == null)
			System.out.println("Nu exista produse in baza de date!");
		return produse;
	}

	/**
	 * Metoda are rolul de a modifica valorile coloanelor de tipul VARCHAR a unui
	 * produs din baza de date. Se apeleaza metoda de update din clasa ProductsDAO,
	 * metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return null in caz de succes.
	 */
	public Products update(String col, String cond, String val1, int val2) {
		Products produs = productsDAO.update(col, cond, val1, val2);
		if (produs != null)
			System.out.println("Produsul nu poate fi modificata!");
		return produs;
	}

	/**
	 * Metoda are rolul de a modifica valorile coloanelor de tipul INT a unui produs
	 * din baza de date. Se apeleaza metoda de update din clasa ProductsDAO, metoda
	 * mostenita din clasa AbstractDAO.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return null in caz de succes.
	 */
	public Products updateInt(String col, String cond, int val1, int val2) {
		Products produs = productsDAO.updateInt(col, cond, val1, val2);
		if (produs != null)
			System.out.println("Produsul nu poate fi modificata!");
		return produs;
	}

	/**
	 * Metoda are rolul de a sterge un produs din baza de date. Se apeleaza metoda
	 * de stergere din clasa ProductsDAO, metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param field campul in functie de care se va realiza stergerea.
	 * @param val   valoarea in functie de care se va realiza stergerea.
	 */
	public void delete(String field, int val) {
		productsDAO.delete(field, val);
	}

	/**
	 * Metoda are rolul de a insera o comanda in baza de date. Se apeleaza metoda de
	 * insert, metoda implementata in clasa ProductsDAO.
	 * 
	 * @param id       valoare unica pentru fiecare produs
	 * @param name     String ce reprezinta numele unui produs
	 * @param producer String ce reprezinta numele unui producator
	 * @param quantity valoare ce reprezinta cantitatea
	 * @param price    valoare ce reprezinta pretul unui produs
	 * @return
	 */
	public Products insert(int id, String name, String producer, int quantity, int price) {
		Products produs = productsDAO.insert(id, name, producer, quantity, price);
		if (produs != null) {
			System.out.println("Produsul nu a fost introdus in baza de date");
		}
		return produs;
	}

	/**
	 * Metoda utilizata pentru a crea un tabel ce va contine produsele din baza de
	 * date. Se apeleaza metoda pentru a crea tabelul, metoda mostenita de clasa
	 * OrdersDAO din clasa parinte AbstractDAO.
	 * 
	 * @param orders o lista de produse ce va fi inserata in tabel.
	 * @return un obiect de tipul JTable.
	 */
	public JTable createTable(List<Products> products) {
		JTable table;
		ProductsDAO p = new ProductsDAO();
		table = p.createTable(products);
		return table;
	}
}
