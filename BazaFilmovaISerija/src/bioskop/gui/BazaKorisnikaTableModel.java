package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import korisnici.Korisnik;
import projekcije.filmovi.Film;

public class BazaKorisnikaTableModel extends AbstractTableModel {
	
	private final String[] kolone = new String[] {"ID", "Ime i prezime korisnika"};
	private List<Korisnik> listaKorisnika;
	public BazaKorisnikaTableModel(List<Korisnik> listaKorisnika) {
		if (listaKorisnika == null) {
			this.listaKorisnika = new LinkedList<>();
		} else {
			this.listaKorisnika = listaKorisnika;
		}
	}
	
	
	@Override
	public int getColumnCount() {
		
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		
		return listaKorisnika.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Korisnik k = listaKorisnika.get(rowIndex);
		switch(columnIndex){
		case 0 : return k.getID();
		case 1: return k.getImeIPrezime();
		
		default: return "NN";
	}

}
}