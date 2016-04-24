package bioskop;
import java.util.LinkedList;

import korisnici.Korisnik;

public class Bioskop {
	private int ID;
	private String naziv;
	private String lokacija;
	private int kapacitet;
	private LinkedList<Korisnik> listaGledalaca = new LinkedList<Korisnik>(); //koji su ikad bili u tom bioskopu
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		if(iD == 0)
			throw new RuntimeException("Greska!");
		ID = iD;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv==null || naziv.isEmpty())
			throw new RuntimeException("Greska!");
		this.naziv = naziv;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		if(lokacija==null || lokacija.isEmpty())
			throw new RuntimeException("Greska!");
		this.lokacija = lokacija;
	}
	public int getKapcitet() {
		return kapacitet;
	}
	public void setKapcitet(int kapacitet) {
		if(kapacitet<=20 || kapacitet>=200)
			throw new RuntimeException("Greska!");
		this.kapacitet = kapacitet;
	}
	@Override
	public String toString() {
		return "Bioskop [ID=" + ID + ", naziv=" + naziv + ", lokacija="
				+ lokacija + ", kapcitet=" + kapacitet + "]";
	}
	
	
}
