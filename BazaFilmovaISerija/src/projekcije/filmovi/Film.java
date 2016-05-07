package projekcije.filmovi;
import korisnici.Korisnik;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import termin.Termin;
/**
 * Klasa Film.
 * @author Olivera, Ana i Jana
 *
 */
public class Film implements Serializable{
	/**
	 * Lista termina u kojima se prikazuje dati film.
	 */
	private LinkedList<Termin> listaTermina;
	/**
	 *Atribut koji predstavlja naziv filma.
	 */
	private static String imeFilma;
	/**
	 * Atribut koji predstavlja ocenu filma.
	 */
	private static int ocenaFilma;
	/**
	 * Atribut koji predstavlja zanr filma.
	 */
	private static String zanrFilma;
	/**
	 * Atribut koji oznacava trajanje filma.
	 */
	private static double trajanjeFilma;
	/**
	 * Atribut publika predstavlja listu gledalaca koji su ikad gledali dati film.
	 */
	private LinkedList <Korisnik> publika = new LinkedList<Korisnik>(); //oni koji su ikad gledali taj film
	/**
	 * Metoda koja predstavlja geter za atribut listaTermina
	 * @return listaTermina
	 */
	public LinkedList <Termin>getTermini(){
		return listaTermina;
	}
	/**
	 * Metoda koja predstavlja seter za atribut listaTermina. Prima kao parametre tri termina (t1, t2 i t3). 
	 * Pretpostavili smo da se svaki film prikazuje u tri termina.
	 * @param t1
	 * @param t2
	 * @param t3
	 */
	public void setTermini(GregorianCalendar t1, GregorianCalendar t2, GregorianCalendar t3){ //pretostavimo da za svaki film postoje 3 termina
		listaTermina.get(0).setTermin(t1);
		listaTermina.get(1).setTermin(t2);
		listaTermina.get(2).setTermin(t3);
	}
	/**
	 * Metoda koja predstavlja geter za ime.
	 * @return imeFilma
	 */
	public static String getIme() {
		return imeFilma;
	}
	/**
	 * Metoda koja predstavlja seter za ime.
	 * @throws java.lang.RuntimeException  U slucaju da je ime null ili prazan String, metoda baca izuzetak.
	 * @param ime
	 */
	public static void setIme(String ime) {
		if(ime==null || ime.isEmpty())
			throw new RuntimeException("Greska!");
		imeFilma = ime;
	}
	/**
	 * Metoda koja predstavlja geter za ocenu filma.
	 * @return ocenaFilma
	 */
	public static int getOcena() {
		return ocenaFilma;
	}
	/**
	 * Metoda koja predstavlja seter za ocenu filma.
	 * @throws java.lang.RuntimeException Izuzetak se baca u slucaju da je ocena veca od 5 ili manja od 0.
	 * @param ocena
	 */
	public static void setOcena(int ocena) {
		if(ocena>5 || ocena<0)
			throw new RuntimeException("Greska!");
		ocenaFilma = ocena;
	}
	/**
	 * Metoda koja predstavlja geter za zanr filma.
	 * @return zanrFilma
	 */
	public static String getZanr() {
		return zanrFilma;
	}
	/**
	 * Metoda koja predstavlja seter za zanr filma.
	 * @throws java.lang.RuntimeException Izuzetak se baca u slucaju da je zanr null ili prazan String.
	 * @param zanr
	 */
	public static void setZanr(String zanr) {
		if(zanr==null || zanr.isEmpty())
			throw new RuntimeException("Greska!");
		zanrFilma = zanr;
	}
	/**
	 * Metoda koja predstavlja geter za trajanje filma.
	 * @return trajanjeFilma
	 */
	
	public static double getTrajanje() {
		return trajanjeFilma;
	}
	/**
	 * Metoda koja predstavlja seter za trajanje filma.
	 * @throws java.lang.RuntimeException Izuzetak se baca u slucaju da je trajanje manje ili jednako od 0.
	 * @param trajanje
	 */
	public static void setTrajanje(double trajanje) {
		if(trajanje<=0)
			throw new RuntimeException("Greska!");
		trajanjeFilma = trajanje;
	}
	/**
	 * Metoda koja predstavlja geter za atribut publika.
	 * @return publika
	 */
	public LinkedList <Korisnik> getPublika(){
		return publika;
	}
	/**
	 * Predefinisana toString() metoda klase Object.
	 */
	@Override
	public String toString() {
		return "film [Ime= " + imeFilma + ","
				+ "Ocena= " + ocenaFilma + ", Zanr= " + zanrFilma + "Vreme trajanja= " + trajanjeFilma+ " Termini=" +listaTermina.toString()+"]";
	}
	//sta radi ovo poslednje?
	
	
}
