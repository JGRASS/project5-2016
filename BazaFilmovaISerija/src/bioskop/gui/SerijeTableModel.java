package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import projekcije.filmovi.Film;
import projekcije.serije.Serija;
/**
 * 
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 * 
 * Model tabele koja prikazuje serije koji se dodaju u listu.
 */
public class SerijeTableModel extends AbstractTableModel{
	/**
	 * Lista koja imenuje kolone tabele.
	 */
	private final String[] kolone = new String[] {"Ime serije", "Ocena serije", "Trajanje serije"};
	private LinkedList<Serija> listaSerija;
	/**
	 * Konstuktor klase SerijeTableModel
	 * @param listaSerija
	 */
	
	public SerijeTableModel(LinkedList<Serija> listaSerija) {
		if (listaSerija == null) {
			this.listaSerija = new LinkedList<>();
		} else {
			this.listaSerija = listaSerija;
		}
	}
	/**
	 * Funkcija koja vraca broj kolona tabele.
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}
	/**
	* Funkcija koja vraca broj redova tabele.
	*/
	@Override
	public int getRowCount() {
		return listaSerija.size();
	}
	/**
	 * Funkcija koja vraca vrednost iz kolone i reda koji su prosledjeni kao parametri funkciji.
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Serija s = listaSerija.get(rowIndex);
		switch(columnIndex){
		case 0 : return s.getImeSerije();
		case 1: return s.getOcenaSerije();
		case 2: return s.getTrajanjeSerije();
		default: return "NN";
		}
			
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void ucitajSerije(LinkedList<Serija> listaSerija){
		this.listaSerija = listaSerija;
		fireTableDataChanged();
	}
	
	public Serija getSerijaByIndex(int index){
		return listaSerija.get(index);
	}
}
