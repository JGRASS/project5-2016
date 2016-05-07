package bioskop.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DodajKorisnikaGUI extends JFrame{
	private JScrollPane scrollPane;
	private static JTable tableKorisnik;
	public DodajKorisnikaGUI() {
		setMinimumSize(new Dimension(400, 500));
		setTitle("Lista korisnika");
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
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
	
	public static void osveziTabeluKorisnika(){
		KorisnikTableModel model = (KorisnikTableModel) tableKorisnik.getModel();
		model.ucitajKorisnika(GUIKontroler.vratiSveKorinike());
	}
}
