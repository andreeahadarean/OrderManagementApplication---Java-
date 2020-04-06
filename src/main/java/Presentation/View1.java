package Presentation;

import java.awt.*;
import javax.swing.*;

public class View1 extends JFrame {

	JTable table;

	public View1(JTable table) {
		this.table = table;
		JPanel p = new JPanel();
		p.setBackground(new Color(253, 198, 244));
		Font f = new Font("Sanserif", Font.ITALIC, 20);
		ImageIcon header = new ImageIcon("Logo.png");
		JLabel h = new JLabel(header);
		h.setAlignmentX(CENTER_ALIGNMENT);
		h.setAlignmentY(TOP_ALIGNMENT);
		table.setFont(f);
		table.setForeground(new Color(98, 89, 102));
		table.setRowHeight(30);
		table.setEnabled(false);
		changeColumnWidth();
		table.setPreferredScrollableViewportSize(new Dimension(600, 200));
		table.setFillsViewportHeight(true);
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setAlignmentX(CENTER_ALIGNMENT);
		scrollPane.setAlignmentY(BOTTOM_ALIGNMENT);
		p.add(h);
		p.add(scrollPane);
		this.setContentPane(p);
		this.setSize(720, 1000);
		this.setTitle("Make-Up Store");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void changeColumnWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		for (int i = 1; i <= table.getColumnCount() - 1; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(80);
		}
	}

}
