package projekcije.filmovi;
import korisnici.Korisnik;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import termin.Termin;

public class Film {
	
	private LinkedList<Termin> listaTermina;
	private String imeFilma;
	private int brojBioskopa;
	private int ocenaFilma;
	private String zanrFilma;
	private double trajanjeFilma;
	private LinkedList <Korisnik> publika = new LinkedList<Korisnik>(); //oni koji su ikad gledali taj film
	
	public LinkedList <Termin>getTermini(){
		return listaTermina;
	}
	public void setTermini(GregorianCalendar t1, GregorianCalendar t2, GregorianCalendar t3){ //pretostavimo da za svaki film postoje 3 termina
		listaTermina.get(0).setTermin(t1);
		listaTermina.get(1).setTermin(t2);
		listaTermina.get(2).setTermin(t3);
	}
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
	public LinkedList <Korisnik> getPublika(){
		return publika;
	}
	@Override
	public String toString() {
		return "film [Ime= " + imeFilma + ", Broj bioskopa= " + brojBioskopa + ","
				+ "Ocena= " + ocenaFilma + ", Zanr= " + zanrFilma + "Vreme trajanja= " + trajanjeFilma+ " Termini=" +listaTermina.toString()+"]";
	}
	//sta radi ovo poslednje?
	
	
}
