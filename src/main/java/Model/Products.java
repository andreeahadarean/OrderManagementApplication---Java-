package Model;

/**
 * Clasa joaca rolul modelului pentru tabelul products din baza de date
 * ordersdb.
 * 
 * @author Andreea Roxana Hadarean
 *
 */
public class Products {
	public int id;
	public String name;
	public String producer;
	public int quantity;
	public int price;

	public Products() {

	}

	public Products(int id, String name, String producer, int quantity, int price) {
		this.id = id;
		this.name = name;
		this.producer = producer;
		this.quantity = quantity;
		this.price = price;
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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "" + id + ". " + name + " " + producer;
	}

}
