package Business;

import java.util.*;
import javax.swing.JTable;
import DAO.ProducersDAO;
import Model.Producers;

/**
 * Clasa este utilizata pentru a efectua operatii logice asupra claselor din
 * pachetul Model. Clasa poate fi instantiata doar din clasele existente in
 * pachetul Presentation.
 * 
 * @author Andreea Roxana Hadarean
 *
 */

public class PoducersBll {
	public ProducersDAO producersDAO = new ProducersDAO();

	/**
	 * Metoda are rolul de a gasi producatorul cu un anumit id. Se apeleaza metoda
	 * findById(id) din clasa ProducersDAO, metoda mostenita din clasa AbstractDAO.
	 * In caz de succes, producatorul cu id-ul specificat este returnat.
	 * 
	 * @param id reprezinta o valoare intreaga, unica pentru fiecare comanda.
	 * @return un obiect de tipul Orders.
	 */
	public Producers findByID(int id) {
		Producers producator = producersDAO.findById(id);
		if (producator == null)
			System.out.println("Producatorul nu exista in baza de date!");
		return producator;
	}

	/**
	 * Metoda are rolul de a gasi toti producatorii din baza de date. Se apeleaza
	 * metoda selectAll() din clasa ProducersDAO, metoda mostenita din clasa
	 * AbstractDAO. In caz de succes, metoda va returna o lista de producatori.
	 * 
	 * @return o lista de producatori.
	 */
	public List<Producers> selectAll() {
		List<Producers> producatori = producersDAO.selectAll();
		if (producatori == null)
			System.out.println("Exista producatori in baza de date!");
		return producatori;
	}

	/**
	 * Metoda are rolul de a modifica valorile coloanelor de tipul VARCHAR a unui
	 * producator din baza de date. Se apeleaza metoda de update din clasa
	 * ProducersDAO, metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return null in caz de succes.
	 */
	public Producers update(String col, String cond, String val1, int val2) {
		Producers producator = producersDAO.update(col, cond, val1, val2);
		if (producator != null)
			System.out.println("Producatorul nu poate fi modificata!");
		return producator;
	}

	/**
	 * Metoda are rolul de a sterge un producator din baza de date. Se apeleaza
	 * metoda de stergere din clasa ProducersDAO, metoda mostenita din clasa
	 * AbstractDAO.
	 * 
	 * @param field campul in functie de care se va realiza stergerea.
	 * @param val   valoarea in functie de care se va realiza stergerea.
	 */
	public void delete(String field, int val) {
		producersDAO.delete(field, val);
	}

	/**
	 * Metoda are rolul de a insera un producator in baza de date. Se apeleaza
	 * metoda de insert, metoda implementata in clasa ProducersDAO.
	 * 
	 * @param id       valoare unica pentru fiecare producator.
	 * @param name     String ce reprezinta numele producatorului ce va fi inserat.
	 * @param products String de caractere ce reprezinta numele produsului pe care
	 *                 respectivul producator il produce.
	 * @return null in caz de succes.
	 */
	public Producers insert(int id, String name, String products) {
		Producers producator = producersDAO.insert(id, name, products);
		if (producator != null) {
			System.out.println("Producatorul nu a fost introdus in baza de date");
		}
		return producator;
	}

	/**
	 * Metoda utilizata pentru a crea un tabel ce va contine comenzile din baza de
	 * date. Se apeleaza metoda pentru a crea tabelul, metoda mostenita de clasa
	 * ProducersDAO din clasa parinte AbstractDAO.
	 * 
	 * @param producers o lista de producatori ce va fi inserata in tabel.
	 * @return un obiect de tipul JTable.
	 */
	public JTable createTable(List<Producers> producers) {
		JTable table;
		ProducersDAO p = new ProducersDAO();
		table = p.createTable(producers);
		return table;
	}
}
