package Model;

/**
 * 
 * Clasa joaca rolul modelului pentru tabelul clients din baza de date ordersdb.
 * 
 * @author Andreea Roxana Hadarean
 * 
 */
public class Clients {
	public int id;
	public String name;
	public String adress;

	public Clients() {

	}

	public Clients(int id, String name, String adress) {
		this.id = id;
		this.name = name;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "" + id + ". " + name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
