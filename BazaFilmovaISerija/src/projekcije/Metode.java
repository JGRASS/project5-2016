package projekcije;
import bioskop.Bioskop;
import termin.Termin;


import projekcije.filmovi.Film;
import projekcije.serije.Serija;
import korisnici.Korisnik;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class Metode {
	public static LinkedList<Film> filmovi = new LinkedList<Film>();
	public static LinkedList<Serija> serije = new LinkedList<Serija>();
	public static LinkedList<Korisnik> korisnici = new LinkedList<Korisnik>();
	
	public static LinkedList<Film> vratiListuFilmova(){
		return filmovi;
	}
	
	public static void napuniListuFilmova(Film f){
		filmovi.add(f);
	}
	
	
	public int vratiBrojGledalacaFilmaUTerminu(Termin t, String naziv){
		int i = 0;
		int brojac = 0;
		while(i<filmovi.size()){
			if(filmovi.get(i).getIme().equals(naziv) && filmovi.get(i).getTermini().contains(t.getTermin()))
				brojac++;
			i++;
		}
		return brojac;
	}
	public int vratiUkupanBrojGledalacaFilma(String naziv){
		int i=0;
		int brojac=0;
		while(i<filmovi.size()){
			if(filmovi.get(i).getIme().equals(naziv))
				brojac++;
			i++;
		}
			
		return brojac;
	}
	public Film najboljeOcenjen(){
		double najboljaOcena = filmovi.get(0).getOcena();
		Film najboljeOcenjen = filmovi.get(0);
		int i=0;
		while(i<filmovi.size()){
			if(filmovi.get(i).getOcena()>najboljaOcena){
				najboljaOcena = filmovi.get(i).getOcena();
				najboljeOcenjen = filmovi.get(i);
			}
			i++;
		}
		return najboljeOcenjen;
	}
	public Film najgoreOcenjen(){
		double najgoraOcena = filmovi.get(0).getOcena();
		Film najgoreOcenjen = filmovi.get(0);
		int i=0;
		while(i<filmovi.size()){
			if(filmovi.get(i).getOcena()<najgoraOcena){
				najgoraOcena = filmovi.get(i).getOcena();
				najgoreOcenjen = filmovi.get(i);
			}
			i++;
		}
		return najgoreOcenjen;
	}
	public LinkedList <Film> filmoviJednogZanra(String z){
		LinkedList<Film> filmoviJednogZanra = new LinkedList<Film>();
		for(int i=0; i<filmovi.size(); i++){
			if(filmovi.get(i).getZanr().equals(z))
				filmoviJednogZanra.add(filmovi.get(i));
		}
		return filmoviJednogZanra;
	}

	public static void napuniListuSerija(Serija s) {
		serije.add(s);
		
	}
	

	public static void napuniListuKorisnika(Korisnik k) {
		korisnici.add(k);
		
	}
	
	public static LinkedList<Korisnik> vratiListuKorisnika(){
		return korisnici;
	}

	public static LinkedList<Serija> vratiListuSerija() {
		
		return serije;
	}
}
