package Presentation;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame {
	public JComboBox tableList;
	public String[] tables = { "Clients", "Products", "Producers", "Orders" };
	public JComboBox operationList;
	public String[] operations = { "Select by ID", "Select all", "Insert", "Update", "Delete", "Create order" };
	public JButton show;
	public JTextField id;

	public MainView() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("Logo.png");
		Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		show = new JButton("Show");
		show.setFont(f);
		show.setBackground(Color.WHITE);
		show.setForeground(new Color(98, 89, 102));
		tableList = new JComboBox(tables);
		tableList.setSelectedIndex(0);
		tableList.setFont(f);
		tableList.setBackground(Color.WHITE);
		tableList.setForeground(new Color(98, 89, 102));
		operationList = new JComboBox(operations);
		operationList.setSelectedIndex(0);
		operationList.setFont(f);
		operationList.setBackground(Color.WHITE);
		operationList.setForeground(new Color(98, 89, 102));
		id = new JTextField(20);
		id.setFont(f);
		id.setBorder(b);
		JLabel h = new JLabel(header);
		JLabel l1 = new JLabel("Choose the table ");
		l1.setFont(f);
		l1.setForeground(new Color(98, 89, 102));
		JLabel l2 = new JLabel("Choose the operation ");
		l2.setFont(f);
		l2.setForeground(new Color(98, 89, 102));
		JLabel l3 = new JLabel("Insert an ID ");
		l3.setFont(f);
		l3.setForeground(new Color(98, 89, 102));

		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(tableList, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(operationList, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(id, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(show, gbc);

		p.add(h);
		p.add(l1);
		p.add(tableList);
		p.add(l2);
		p.add(operationList);
		p.add(l3);
		p.add(id);
		p.add(show);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addCombo1Listener(ActionListener a) {
		tableList.addActionListener(a);
	}

	public void addCombo2Listener(ActionListener a) {
		operationList.addActionListener(a);
	}

	public void addTextListener(ActionListener a) {
		id.addActionListener(a);
	}

	public void addButtonListener(ActionListener a) {
		show.addActionListener(a);
	}
}
