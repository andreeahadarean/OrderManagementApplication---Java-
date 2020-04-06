package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import Model.*;

public class ViewComanda extends JFrame {
	public JComboBox clienti;
	public Vector<String> clientVector = new Vector<String>();
	public JComboBox produse;
	public Vector<String> productVector = new Vector<String>();
	public JTextField quantity;
	public JTextField output;
	public JButton comanda;

	public ViewComanda() {

		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("Logo.png");
		Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		comanda = new JButton("Order");
		comanda.setFont(f);
		comanda.setBackground(Color.WHITE);
		comanda.setForeground(new Color(98, 89, 102));
		clienti = new JComboBox(clientVector);
		clienti.setFont(f);
		clienti.setBackground(Color.WHITE);
		clienti.setForeground(new Color(98, 89, 102));
		produse = new JComboBox(productVector);
		produse.setFont(f);
		produse.setBackground(Color.WHITE);
		produse.setForeground(new Color(98, 89, 102));
		quantity = new JTextField(20);
		quantity.setFont(f);
		quantity.setBorder(b);
		output = new JTextField(20);
		output.setFont(f);
		output.setBorder(b);
		JLabel h = new JLabel(header);
		JLabel l1 = new JLabel("Choose a client ");
		l1.setFont(f);
		l1.setForeground(new Color(98, 89, 102));
		JLabel l2 = new JLabel("Choose a product ");
		l2.setFont(f);
		l2.setForeground(new Color(98, 89, 102));
		JLabel l3 = new JLabel("Insert a quantity ");
		l3.setFont(f);
		l3.setForeground(new Color(98, 89, 102));

		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(clienti, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(produse, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(quantity, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(comanda, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(output, gbc);

		p.add(h);
		p.add(l1);
		p.add(clienti);
		p.add(l2);
		p.add(produse);
		p.add(l3);
		p.add(quantity);
		p.add(comanda);
		p.add(output);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void addCombo1Listener(ActionListener a) {
		clienti.addActionListener(a);
	}

	public void addCombo2Listener(ActionListener a) {
		produse.addActionListener(a);
	}

	public void addTextListener(ActionListener a) {
		quantity.addActionListener(a);
	}

	public void addButtonListener(ActionListener a) {
		comanda.addActionListener(a);
	}
}
