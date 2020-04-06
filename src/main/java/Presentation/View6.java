package Presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class View6 extends JFrame {
	JLabel output;

	public View6() {
		JPanel p = new JPanel();
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		output = new JLabel("Elementul a fost sters din baza de date!");
		output.setFont(f);
		output.setForeground(new Color(98, 89, 102));
		output.setAlignmentX(JFrame.CENTER_ALIGNMENT);
		output.setAlignmentY(JFrame.CENTER_ALIGNMENT);
		p.add(output);
		this.setContentPane(p);
		this.setSize(600, 90);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

}
