package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import projekcije.serije.Serija;

import java.awt.Dimension;
import java.util.LinkedList;

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
	
	public static LinkedList<Serija> vratiSveSerije() {
		return projekcije.Metode.vratiListuSerija();
	}
	public static void osveziTabeluSerija(){
		SerijeTableModel model = (SerijeTableModel) table.getModel();
		model.uciitajSerije(vratiSveSerije());
	}
}
