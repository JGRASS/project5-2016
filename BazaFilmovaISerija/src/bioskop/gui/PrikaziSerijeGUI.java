package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projekcije.serije.Serija;

import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class PrikaziSerijeGUI extends JFrame{
	private JScrollPane scrollPane;
	private static JTable table;
	private JPanel panel;
	private JButton btnIzbrisi;
	public PrikaziSerijeGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
		setMinimumSize(new Dimension(400, 500));
		setTitle("Lista serija");
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new SerijeTableModel(null));
			
		}
		return table;
	}
		
	public static void osveziTabeluSerija(){
		SerijeTableModel model = (SerijeTableModel) table.getModel();
		model.ucitajSerije(GUIKontroler.vratiSveSerije());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnIzbrisi());
		}
		return panel;
	}
	private JButton getBtnIzbrisi() {
		if (btnIzbrisi == null) {
			btnIzbrisi = new JButton("Izbrisi");
			btnIzbrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table.getSelectedRow();
					if (index == -1) {
						GUIKontroler.porukaGreskeBiranjeReda();
					} else {
						int opcija = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete izbranu seriju?", "Poruka",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							SerijeTableModel model = (SerijeTableModel) table.getModel();
							Serija s = model.getSerijaByIndex(index);
							GUIKontroler.izbrisiSeriju(s);
						}
					}
				}
			});
		}
		return btnIzbrisi;
	}
}
