package Model;

/**
 * Clasa joaca rolul modelului pentru tabelul producers din baza de date
 * ordersdb.
 * 
 * @author Andreea Roxana Hadarean
 *
 */
public class Producers {
	public int id;
	public String name;
	public String products;

	public Producers() {

	}

	public Producers(int id, String name, String products) {
		this.id = id;
		this.name = name;
		this.products = products;
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

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Producers [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

}
