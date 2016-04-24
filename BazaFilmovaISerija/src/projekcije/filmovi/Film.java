package projekcije.filmovi;

import java.util.LinkedList;

public class Film {
	
	private String imeFilma;
	private int brojBioskopa;
	private int ocenaFilma;
	private String zanrFilma;
	private double trajanjeFilma;
	private LinkedList<Film> filmovi = new LinkedList<Film>();
	
	public String getIme() {
		return imeFilma;
	}
	public void setIme(String ime) {
		if(ime==null || ime.isEmpty())
			throw new RuntimeException("Greska!");
		this.imeFilma = ime;
	}
	public int getBrojBioskopa() {
		return brojBioskopa;
	}
	public void setBrojBioskopa(int brojBioskopa) {
		if(brojBioskopa<=0)
			throw new RuntimeException("Greska!");
		this.brojBioskopa = brojBioskopa;
	}
	public int getOcena() {
		return ocenaFilma;
	}
	public void setOcena(int ocena) {
		if(ocena>5 || ocena<0)
			throw new RuntimeException("Greska!");
		this.ocenaFilma = ocena;
	}
	public String getZanr() {
		return zanrFilma;
	}
	public void setZanr(String zanr) {
		if(zanr==null || zanr.isEmpty())
			throw new RuntimeException("Greska!");
		this.zanrFilma = zanr;
	}
	
	
	public double getTrajanje() {
		return trajanjeFilma;
	}
	public void setTrajanje(double trajanje) {
		if(trajanje<=0)
			throw new RuntimeException("Greska!");
		this.trajanjeFilma = trajanje;
	}
	
	public LinkedList<Film> getFilmovi() {
		return filmovi;
	}
	public void setFilmovi(LinkedList<Film> filmovi) {
		this.filmovi = filmovi;
	}
	@Override
	public String toString() {
		return "film [Ime= " + imeFilma + ", Broj bioskopa= " + brojBioskopa + ","
				+ "Ocena= " + ocenaFilma + ", Zanr= " + zanrFilma + "Vreme trajanja= " + trajanjeFilma+ "]";
	}
	
	
}
