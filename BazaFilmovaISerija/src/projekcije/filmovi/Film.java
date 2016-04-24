package projekcije.filmovi;
import korisnici.Korisnik;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import termin.Termin;

public class Film {
	
	private LinkedList<Termin> listaTermina;
	private static String imeFilma;
	private static int brojBioskopa;
	private static int ocenaFilma;
	private static String zanrFilma;
	private static double trajanjeFilma;
	private LinkedList <Korisnik> publika = new LinkedList<Korisnik>(); //oni koji su ikad gledali taj film
	
	public LinkedList <Termin>getTermini(){
		return listaTermina;
	}
	public void setTermini(GregorianCalendar t1, GregorianCalendar t2, GregorianCalendar t3){ //pretostavimo da za svaki film postoje 3 termina
		listaTermina.get(0).setTermin(t1);
		listaTermina.get(1).setTermin(t2);
		listaTermina.get(2).setTermin(t3);
	}
	public static String getIme() {
		return imeFilma;
	}
	public static void setIme(String ime) {
		if(ime==null || ime.isEmpty())
			throw new RuntimeException("Greska!");
		imeFilma = ime;
	}
	public static int getBrojBioskopa() {
		return brojBioskopa;
	}
	public static void setBrojBioskopa(int broj) {
		if(brojBioskopa<=0)
			throw new RuntimeException("Greska!");
		brojBioskopa = broj;
	}
	public static int getOcena() {
		return ocenaFilma;
	}
	public static void setOcena(int ocena) {
		if(ocena>5 || ocena<0)
			throw new RuntimeException("Greska!");
		ocenaFilma = ocena;
	}
	public static String getZanr() {
		return zanrFilma;
	}
	public static void setZanr(String zanr) {
		if(zanr==null || zanr.isEmpty())
			throw new RuntimeException("Greska!");
		zanrFilma = zanr;
	}
	
	
	public static double getTrajanje() {
		return trajanjeFilma;
	}
	public static void setTrajanje(double trajanje) {
		if(trajanje<=0)
			throw new RuntimeException("Greska!");
		trajanjeFilma = trajanje;
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
