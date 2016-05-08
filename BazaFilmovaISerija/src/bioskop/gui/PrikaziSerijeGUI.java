package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projekcije.serije.Serija;

import java.awt.Dimension;
import java.util.LinkedList;
/**
 * Klasa koja sluzi kao prozor za prikaz tabele sa listom dodatih serija.
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 *
 */
public class PrikaziSerijeGUI extends JFrame{
	private JScrollPane scrollPane;
	private static JTable table;
	public PrikaziSerijeGUI() {
		setMinimumSize(new Dimension(400, 500));
		setTitle("Lista serija");
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
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
	/**
	 * Funkcija kojom se osvezava tabela serija.	
	 */
	public static void osveziTabeluSerija(){
		SerijeTableModel model = (SerijeTableModel) table.getModel();
		model.ucitajSerije(GUIKontroler.vratiSveSerije());
	}
}
