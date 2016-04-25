package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import projekcije.filmovi.Film;

public class FilmTableModel extends AbstractTableModel {
	
	private final String[] kolone = new String[] {"Ime filma", "Zanr filma", "Ocena filma", "Trajanje filma"};
	private List<Film> listaFilmova;
	public FilmTableModel(List<Film> listaFilmova) {
		if (listaFilmova == null) {
			this.listaFilmova = new LinkedList<>();
		} else {
			this.listaFilmova = listaFilmova;
		}
	}
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return listaFilmova.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Film f = listaFilmova.get(rowIndex);
		switch(columnIndex){
		case 0 : return f.getIme();
		case 1: return f.getZanr();
		case 2: return f.getOcena();
		case 3: return f.getTrajanje();
		default: return "NN";
		}
			
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void ucitajFilmove(List<Film> listaFilmova){
		this.listaFilmova = listaFilmova;
		fireTableDataChanged();
	}
	
	public Film getFilmByIndex(int index){
		return listaFilmova.get(index);
	}
}
