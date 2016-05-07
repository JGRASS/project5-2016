package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import projekcije.filmovi.Film;
import projekcije.serije.Serija;

public class SerijeTableModel extends AbstractTableModel{
	
	private final String[] kolone = new String[] {"Ime serije", "Ocena serije", "Trajanje serije"};
	private LinkedList<Serija> listaSerija;
	
	public SerijeTableModel(LinkedList<Serija> listaSerija) {
		if (listaSerija == null) {
			this.listaSerija = new LinkedList<>();
		} else {
			this.listaSerija = listaSerija;
		}
	}
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return listaSerija.size();
	}

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
