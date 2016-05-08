package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import korisnici.Korisnik;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * Klasa koja sluzi kao prozor za dodavanje  novog korisnika u listu.
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic.
 *
 */
public class DodajKorisnikaGUI extends JFrame{
	private JScrollPane scrollPane;
	private static JTable tableKorisnik;
	private JPanel panel;
	private JButton btnIzbrisi;
	public DodajKorisnikaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
		setMinimumSize(new Dimension(400, 500));
		setTitle("Lista korisnika");
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
	}
	
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableKorisnik());
		}
		return scrollPane;
	}
	private JTable getTableKorisnik() {
		if (tableKorisnik == null) {
			tableKorisnik = new JTable();
			tableKorisnik.setModel(new KorisnikTableModel(null));
		}
		return tableKorisnik;
	}
	/**
	 * Metoda osvezava tabelicu korisnika.
	 */
	public static void osveziTabeluKorisnika(){
		KorisnikTableModel model = (KorisnikTableModel) tableKorisnik.getModel();
		model.ucitajKorisnika(GUIKontroler.vratiSveKorinike());
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
					int index = tableKorisnik.getSelectedRow();
					if (index == -1) {
						GUIKontroler.porukaGreskeBiranjeReda();
					} else {
						int opcija = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete izabranog korisnika?", "Poruka",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							KorisnikTableModel model = (KorisnikTableModel) tableKorisnik.getModel();
							Korisnik k = model.getKorisnikByIndex(index);
							GUIKontroler.izbrisiKorisnika(k);
						}
					}
				}
			});
		}
		return btnIzbrisi;
	}
}
