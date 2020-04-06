package Model;

/**
 * Clasa joaca rolul modelului pentru tabelul orders din baza de date ordersdb.
 * 
 * @author Andreea Roxana Hadarean
 *
 */
public class Orders {
	public int id;
	public String data;
	public int total_price;
	public int client_id;

	public Orders() {

	}

	public Orders(int id, String data, int total_price, int client_id) {

		this.id = id;
		this.data = data;
		this.total_price = total_price;
		this.client_id = client_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", data=" + data + ", total_price=" + total_price + ", client_id=" + client_id
				+ "]";
	}

}
