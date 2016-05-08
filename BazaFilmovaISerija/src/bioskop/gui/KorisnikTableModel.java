package bioskop.gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import korisnici.Korisnik;
/**
 * 
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 * 
 * Model tabele koja prikazuje korisnike koji se dodaju u listu.
 */
public class KorisnikTableModel extends AbstractTableModel {
	/**
	 * Lista koja imenuje kolone tabele.
	 */
	private final String[] kolone = new String[] {"Ime i prezime korisnika", "ID korisnika"};
	private List<Korisnik> korisnici;
	/**
	 * Konstuktor klase KorisnikTableModel
	 * @param korisnici
	 */
	
	public KorisnikTableModel(List<Korisnik> korisnici) {
		if(korisnici == null){
			this.korisnici = new LinkedList<>();
		}else {
			this.korisnici = korisnici;
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
		return korisnici.size();
	}
	/**
	 * Funkcija koja vraca vrednost iz kolone i reda koji su prosledjeni kao parametri funkciji.
	 */
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

	public Korisnik getKorisnikByIndex(int index) {
		return korisnici.get(index);
	}

}
