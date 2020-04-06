package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class View3 extends JFrame {
	public JTextField id;
	public JTextField name;
	public JTextField producer;
	public JTextField quantity;
	public JTextField price;
	public JTextField output;
	public JButton insert;

	public View3() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("Logo.png");
		Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		id = new JTextField(20);
		id.setFont(f);
		id.setBorder(b);
		name = new JTextField(20);
		name.setFont(f);
		name.setBorder(b);
		producer = new JTextField(20);
		producer.setFont(f);
		producer.setBorder(b);
		quantity = new JTextField(20);
		quantity.setFont(f);
		quantity.setBorder(b);
		price = new JTextField(20);
		price.setFont(f);
		price.setBorder(b);
		output = new JTextField(20);
		output.setFont(f);
		output.setBorder(b);
		insert = new JButton("Insert");
		insert.setFont(f);
		insert.setBackground(Color.WHITE);
		insert.setForeground(new Color(98, 89, 102));
		JLabel h = new JLabel(header);
		JLabel l1 = new JLabel("Product ID ");
		l1.setFont(f);
		l1.setForeground(new Color(98, 89, 102));
		JLabel l2 = new JLabel("Product Name: ");
		l2.setFont(f);
		l2.setForeground(new Color(98, 89, 102));
		JLabel l3 = new JLabel("Producer ");
		l3.setFont(f);
		l3.setForeground(new Color(98, 89, 102));
		JLabel l4 = new JLabel("Quantity ");
		l4.setFont(f);
		l4.setForeground(new Color(98, 89, 102));
		JLabel l5 = new JLabel("Price ");
		l5.setFont(f);
		l5.setForeground(new Color(98, 89, 102));

		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(id, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(name, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(producer, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l4, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(quantity, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l5, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(price, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(insert, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(output, gbc);

		p.add(h);
		p.add(l1);
		p.add(id);
		p.add(l2);
		p.add(name);
		p.add(l3);
		p.add(producer);
		p.add(l4);
		p.add(quantity);
		p.add(l5);
		p.add(price);
		p.add(insert);
		p.add(output);
		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void AddButtonListener(ActionListener a) {
		insert.addActionListener(a);
	}
}
