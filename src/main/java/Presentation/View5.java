package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class View5 extends JFrame {

	public JComboBox coloana;
	public JComboBox cond;
	public JTextField valoare;
	public JTextField conditie;
	public JTextField output;
	public JButton update;
	public String[] coloane = { "ID", "Name", "Producer", "Quantity", "Price" };

	public View5() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("Logo.png");
		Border b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		coloana = new JComboBox(coloane);
		coloana.setSelectedIndex(0);
		coloana.setFont(f);
		coloana.setBackground(Color.WHITE);
		coloana.setForeground(new Color(98, 89, 102));
		cond = new JComboBox(coloane);
		cond.setSelectedIndex(0);
		cond.setFont(f);
		cond.setBackground(Color.WHITE);
		cond.setForeground(new Color(98, 89, 102));
		valoare = new JTextField(20);
		valoare.setFont(f);
		valoare.setBorder(b);
		conditie = new JTextField(20);
		conditie.setFont(f);
		conditie.setBorder(b);
		output = new JTextField(20);
		output.setFont(f);
		output.setBorder(b);
		update = new JButton("Update");
		update.setFont(f);
		update.setBackground(Color.WHITE);
		update.setForeground(new Color(98, 89, 102));
		JLabel h = new JLabel(header);
		JLabel l1 = new JLabel("Choose the field to be updated");
		l1.setFont(f);
		l1.setForeground(new Color(98, 89, 102));
		JLabel l2 = new JLabel("Insert a new value ");
		l2.setFont(f);
		l2.setForeground(new Color(98, 89, 102));
		JLabel l3 = new JLabel("Choose a filed for the condition ");
		l3.setFont(f);
		l3.setForeground(new Color(98, 89, 102));
		JLabel l4 = new JLabel("Insert a value for the condition ");
		l4.setFont(f);
		l4.setForeground(new Color(98, 89, 102));

		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(h, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(coloana, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(valoare, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(cond, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l4, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(conditie, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(update, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output, gbc);

		p.add(h);
		p.add(l1);
		p.add(coloana);
		p.add(l2);
		p.add(valoare);
		p.add(l3);
		p.add(cond);
		p.add(l4);
		p.add(conditie);
		p.add(update);
		p.add(output);

		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void AddButtonListener(ActionListener a) {
		update.addActionListener(a);
	}
}
