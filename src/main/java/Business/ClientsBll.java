package Business;

import java.util.*;

import javax.swing.JTable;

import DAO.ClientsDAO;
import Model.Clients;

/**
 * Clasa este utilizata pentru a efectua operatii logice asupra claselor din
 * pachetul Model. Clasa poate fi instantiata doar din clasele existente in
 * pachetul Presentation.
 * 
 * @author Andreea Roxana Hadarean
 *
 */
public class ClientsBll {

	public ClientsDAO clientDAO = new ClientsDAO();

	/**
	 * Metoda are rolul de a gasi clientul cu un anumit id. Se apeleaza metoda
	 * findById(id) din clasa ClientsDAO, metoda mostenita din clasa AbstractDAO. In
	 * caz de succes, clientul cu id-ul specificat este returnat.
	 * 
	 * @param id reprezinta o valoare intreaga, unica pentru fiecare client.
	 * @return un obiect de tipul Clients.
	 */
	public Clients findByID(int id) {
		Clients client = clientDAO.findById(id);
		if (client == null)
			System.out.println("Clientul nu exista in baza de date!");
		return client;
	}

	/**
	 * Metoda are rolul de a gasi toti clientii din baza de date. Se apeleaza metoda
	 * selectAll() din clasa ClientsDAO, metoda mostenita din clasa AbstractDAO. In
	 * caz de succes, metoda va returna o lista de clienti.
	 * 
	 * @return o lista de clienti.
	 */
	public List<Clients> selectAll() {
		List<Clients> clienti = clientDAO.selectAll();
		if (clienti == null)
			System.out.println("Nu exista clienti in baza de date!");
		return clienti;
	}

	/**
	 * Metoda are rolul de a modifica numele/adresa unui client din baza de date. Se
	 * apeleaza metoda de update din clasa ClientsDAO, metoda mostenita din clasa
	 * AbstractDAO.
	 * 
	 * @param col  numele coloanei din tabel ce va fi modificata.
	 * @param cond numele coloanei din tabel ce va fi utilizata pentru a alege
	 *             elementul de modificat.
	 * @param val1 noua valoare a campului.
	 * @param val2 valoarea ce va fi utilizata pentru conditia din clauza WHERE.
	 * @return null in caz de succes.
	 */
	public Clients update(String col, String cond, String val1, int val2) {
		Clients client = clientDAO.update(col, cond, val1, val2);
		if (client != null)
			System.out.println("Clientul nu poate fi modificat!");
		return client;
	}

	/**
	 * Metoda are rolul de a sterge un client din baza de date. Se apeleaza metoda
	 * de stergere din clasa ClientsDAO, metoda mostenita din clasa AbstractDAO.
	 * 
	 * @param field campul in functie de care se va realiza stergerea.
	 * @param val   valoarea in functie de care se va realiza stergerea.
	 */
	public void delete(String field, int val) {
		clientDAO.delete(field, val);
	}

	/**
	 * Metoda are rolul de a insera un client in baza de date. Se apeleaza metoda de
	 * insert, metoda implementata in clasa ClientsDAO.
	 * 
	 * @param id     valoare unica pentru fiecare client.
	 * @param name   String ce reprezinta numele clientului ce va fi inserat.
	 * @param adress String ce reprezinta adresa clientului ce va fi inserat.
	 * @return null in caz de succes.
	 */
	public Clients insert(int id, String name, String adress) {
		Clients client = clientDAO.insert(id, name, adress);
		if (client != null)
			System.out.println("Clientul nu a fost introdus in baza de date");
		return client;
	}

	/**
	 * Metoda utilizata pentru a crea un tabel ce va contine clientii din baza de
	 * date. Se apeleaza metoda pentru a crea tabelul, metoda mostenita de clasa
	 * ClientsDAO din clasa parinte AbstractDAO.
	 * 
	 * @param clients o lista de clienti ce va fi inserata in tabel.
	 * @return un obiect de tipul JTable.
	 */
	public JTable createTable(List<Clients> clients) {
		JTable table;
		table = clientDAO.createTable(clients);
		return table;
	}

}
