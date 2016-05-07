package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import korisnici.Korisnik;

public class KorisnikTableModel extends AbstractTableModel {
	
	private final String[] kolone = new String[] {"Ime i prezime korisnika", "ID korisnika"};
	private List<Korisnik> korisnici;
	
	public KorisnikTableModel(List<Korisnik> korisnici) {
		if(korisnici == null){
			this.korisnici = new LinkedList<>();
		}else {
			this.korisnici = korisnici;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return korisnici.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Korisnik k = korisnici.get(rowIndex);
		switch(columnIndex){
		case 0: return k.getImeIPrezime();
		case 1: return k.getID();
		default: return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void ucitajKorisnika(List<Korisnik> korisnici){
		this.korisnici = korisnici;
		fireTableDataChanged();
	}

}
