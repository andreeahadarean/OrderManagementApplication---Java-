package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import Business.*;
import Model.*;

public class Controller {

	public MainView mainView;
	public View1 v1;
	public View2 v2 = new View2();
	public View3 v3 = new View3();
	public View4 v4 = new View4();
	public View5 v5 = new View5();
	public View6 v6 = new View6();
	public ViewComanda viewC = new ViewComanda();

	public Controller(MainView mainView) {
		this.mainView = mainView;
		mainView.addCombo1Listener(new OrdersListener());
		mainView.addCombo2Listener(new OrdersListener());
		mainView.addTextListener(new OrdersListener());
		mainView.addButtonListener(new OrdersListener());
		v2.AddButtonListener(new SecListener());
		v3.AddButtonListener(new SecListener());
		v4.AddButtonListener(new SecListener());
		v5.AddButtonListener(new SecListener());
		viewC.addCombo1Listener(new ComandaListener());
		viewC.addCombo2Listener(new ComandaListener());
		viewC.addTextListener(new ComandaListener());
		viewC.addButtonListener(new ComandaListener());
	}

	class OrdersListener implements ActionListener {

		public void selectClientUsingID(String s) {
			ClientsBll c = new ClientsBll();
			int id = Integer.parseInt(s);
			Clients client = c.findByID(id);
			List<Clients> clientList = new ArrayList<Clients>();
			clientList.add(client);
			JTable table = c.createTable(clientList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectProductUsingID(String s) {
			ProductsBll p = new ProductsBll();
			int id = Integer.parseInt(s);
			Products product = p.findByID(id);
			List<Products> productList = new ArrayList<Products>();
			productList.add(product);
			JTable table = p.createTable(productList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectProducerUsingID(String s) {
			PoducersBll p = new PoducersBll();
			int id = Integer.parseInt(s);
			Producers producer = p.findByID(id);
			List<Producers> productList = new ArrayList<Producers>();
			productList.add(producer);
			JTable table = p.createTable(productList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectOrderUsingID(String s) {
			OrdersBll o = new OrdersBll();
			int id = Integer.parseInt(s);
			Orders order = o.findByID(id);
			List<Orders> orderList = new ArrayList<Orders>();
			orderList.add(order);
			JTable table = o.createTable(orderList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectAllClients() {
			ClientsBll c = new ClientsBll();
			List<Clients> clientList = c.selectAll();
			JTable table = c.createTable(clientList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectAllProducts() {
			ProductsBll p = new ProductsBll();
			List<Products> productList = p.selectAll();
			JTable table = p.createTable(productList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectAllProducers() {
			PoducersBll p = new PoducersBll();
			List<Producers> productList = p.selectAll();
			JTable table = p.createTable(productList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void selectAllOrders() {
			OrdersBll o = new OrdersBll();
			List<Orders> ordersList = o.selectAll();
			JTable table = o.createTable(ordersList);
			v1 = new View1(table);
			v1.setVisible(true);
		}

		public void insertClient() {
			v2.setVisible(true);
		}

		public void insertProduct() {
			v3.setVisible(true);
		}

		public void updateClient() {
			v4.setVisible(true);
		}

		public void updateProduct() {
			v5.setVisible(true);
		}

		public void deleteClient() {
			ClientsBll c = new ClientsBll();
			c.delete("id", Integer.parseInt(mainView.id.getText()));
			v6.setVisible(true);
		}

		public void deleteProduct() {
			ProductsBll p = new ProductsBll();
			p.delete("id", Integer.parseInt(mainView.id.getText()));
			v6.setVisible(true);
		}

		public void order() {
			ClientsBll c = new ClientsBll();
			ProductsBll p = new ProductsBll();
			List<Clients> clients = c.selectAll();
			for (Clients client : clients)
				viewC.clientVector.add(client.toString());
			viewC.clienti.setSelectedIndex(0);
			List<Products> products = p.selectAll();
			for (Products product : products)
				viewC.productVector.add(product.toString());
			viewC.produse.setSelectedIndex(0);
			viewC.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mainView.show) {
				if (mainView.tableList.getSelectedIndex() == 0 && mainView.operationList.getSelectedIndex() == 0)
					selectClientUsingID(mainView.id.getText());
				if (mainView.tableList.getSelectedIndex() == 1 && mainView.operationList.getSelectedIndex() == 0)
					selectProductUsingID(mainView.id.getText());
				if (mainView.tableList.getSelectedIndex() == 2 && mainView.operationList.getSelectedIndex() == 0)
					selectProducerUsingID(mainView.id.getText());
				if (mainView.tableList.getSelectedIndex() == 3 && mainView.operationList.getSelectedIndex() == 0)
					selectOrderUsingID(mainView.id.getText());
				if (mainView.tableList.getSelectedIndex() == 0 && mainView.operationList.getSelectedIndex() == 1)
					selectAllClients();
				if (mainView.tableList.getSelectedIndex() == 1 && mainView.operationList.getSelectedIndex() == 1)
					selectAllProducts();
				if (mainView.tableList.getSelectedIndex() == 2 && mainView.operationList.getSelectedIndex() == 1)
					selectAllProducers();
				if (mainView.tableList.getSelectedIndex() == 3 && mainView.operationList.getSelectedIndex() == 1)
					selectAllOrders();
				if (mainView.tableList.getSelectedIndex() == 0 && mainView.operationList.getSelectedIndex() == 2)
					insertClient();
				if (mainView.tableList.getSelectedIndex() == 1 && mainView.operationList.getSelectedIndex() == 2)
					insertProduct();
				if (mainView.tableList.getSelectedIndex() == 0 && mainView.operationList.getSelectedIndex() == 3)
					updateClient();
				if (mainView.tableList.getSelectedIndex() == 1 && mainView.operationList.getSelectedIndex() == 3)
					updateProduct();
				if (mainView.tableList.getSelectedIndex() == 0 && mainView.operationList.getSelectedIndex() == 4)
					deleteClient();
				if (mainView.tableList.getSelectedIndex() == 1 && mainView.operationList.getSelectedIndex() == 4)
					deleteProduct();
				if (mainView.tableList.getSelectedIndex() == 3 && mainView.operationList.getSelectedIndex() == 5)
					order();
			}
		}
	}

	class SecListener implements ActionListener {

		public void insertClient() {
			ClientsBll c = new ClientsBll();
			int id = Integer.parseInt(v2.id.getText());
			Clients client = c.insert(id, v2.name.getText(), v2.adress.getText());
			if (client == null) {
				v2.output.setText("Clientul a fost adaugat cu succes!");
			} else
				v2.output.setText("Clientul nu a putut fi adaugat");
		}

		public void insertProduct() {
			ProductsBll p = new ProductsBll();
			int id = Integer.parseInt(v3.id.getText());
			int quantity = Integer.parseInt(v3.quantity.getText());
			int price = Integer.parseInt(v3.price.getText());
			Products product = p.insert(id, v3.name.getText(), v3.producer.getText(), quantity, price);
			if (product == null) {
				v3.output.setText("Produsul a fost adaugat cu succes!");
			} else
				v3.output.setText("Produsul nu poate fi adaugat!");
		}

		public void updateClient() {
			ClientsBll c = new ClientsBll();
			Clients client = c.update((String) v4.coloana.getSelectedItem(), (String) v4.cond.getSelectedItem(),
					v4.valoare.getText(), Integer.parseInt(v4.conditie.getText()));
			if (client == null)
				v4.output.setText("Clientul a fost modificat!");
			else
				v4.output.setText("Clientul nu poate fi modificat!");
		}

		public void updateProduct() {
			ProductsBll p = new ProductsBll();
			Products produs = p.update((String) v5.coloana.getSelectedItem(), (String) v5.cond.getSelectedItem(),
					v5.valoare.getText(), Integer.parseInt(v5.conditie.getText()));
			if (produs == null)
				v5.output.setText("Produsul a fost modificat!");
			else
				v5.output.setText("Produsul nu poate fi modificat!");
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == v2.insert)
				insertClient();
			if (e.getSource() == v3.insert)
				insertProduct();
			if (e.getSource() == v4.update)
				updateClient();
			if (e.getSource() == v5.update)
				updateProduct();
		}
	}

	class ComandaListener implements ActionListener {

		public int getID(String s) {
			int id;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c > 47 && c < 58)
					sb.append(c);
			}
			id = Integer.parseInt(sb.toString());
			return id;
		}

		public void actionPerformed(ActionEvent a) {
			if (a.getSource() == viewC.comanda) {
				int id = (int) (Math.random() * 1000 + 50);
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				Date date = new Date();
				String data = df.format(date).toString();
				String clientChoice = (String) viewC.clienti.getSelectedItem();
				int clientID = getID(clientChoice);
				ClientsBll c = new ClientsBll();
				Clients client = c.findByID(clientID);
				String productChoice = (String) viewC.produse.getSelectedItem();
				int productID = getID(productChoice);
				ProductsBll p = new ProductsBll();
				Products produs = p.findByID(productID);
				int desiredQuantity = Integer.parseInt(viewC.quantity.getText());
				if (desiredQuantity > produs.quantity) {
					viewC.output.setText("Stoc insuficient!");
					return;
				}
				OrdersBll o = new OrdersBll();
				Orders order = o.insert(id, data, desiredQuantity * produs.price, client.id);
				if (order == null)
					viewC.output.setText("Comanda realizata cu succes!");
				Products p1 = p.updateInt("quantity", "id", produs.quantity - desiredQuantity, produs.id);
				generateBill(id, data, produs, client, desiredQuantity);
			}
		}

		public void generateBill(int id, String data, Products p, Clients c, int q) {
			try {
				Document bill = new Document();
				PdfWriter.getInstance(bill, new FileOutputStream("Bill" + id + ".pdf"));
				bill.open();
				Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
				bill.add(new Chunk("Order: " + id, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Date: " + data, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Client: " + c.id + ". " + c.name, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Adress: " + c.adress, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Product: " + p.id + ". " + p.name, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Quantity: " + q, font));
				bill.add(new Paragraph(" "));
				bill.add(new Chunk("Total price: " + q * p.price, font));
				bill.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
}
