package korisnici;

import java.util.LinkedList;


import korisnici.interfejs.InterfejsKorisnik;
import projekcije.filmovi.Film;
import projekcije.filmovi.zanr.Zanr;
import projekcije.serije.Serija;

public class Korisnik implements InterfejsKorisnik{
		
		private String imeIPrezime;
		private int ID;
		private LinkedList<Film> odgledaniFilmovi = new LinkedList<Film>();
		private LinkedList<Serija> ogledaneSerije = new LinkedList<Serija>();
		private LinkedList<Film> filmoviZaGledanje = new LinkedList<Film>();
		private LinkedList<Serija> serijeZaGledanje = new LinkedList<Serija>();
		
		public String getImeIPrezime() {
			return imeIPrezime;
		}
		public void setImeIPrezime(String imeIPrezime) {
			if(imeIPrezime==null || imeIPrezime.isEmpty())
				throw new RuntimeException("Greska!");
			this.imeIPrezime = imeIPrezime;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			if(ID>6)
				throw new RuntimeException("Greska!");
			ID = iD;
		}
		
		
		public LinkedList<Film> getOdgledaniFilmovi() {
			return odgledaniFilmovi;
		}
		public void setOdgledaniFilmovi(LinkedList<Film> odgledaniFilmovi) {
			this.odgledaniFilmovi = odgledaniFilmovi;
		}
		public LinkedList<Serija> getOgledaneSerije() {
			return ogledaneSerije;
		}
		public void setOgledaneSerije(LinkedList<Serija> ogledaneSerije) {
			this.ogledaneSerije = ogledaneSerije;
		}
		public LinkedList<Film> getFilmoviZaGledanje() {
			return filmoviZaGledanje;
		}
		public void setFilmoviZaGledanje(LinkedList<Film> filmoviZaGledanje) {
			this.filmoviZaGledanje = filmoviZaGledanje;
		}
		public LinkedList<Serija> getSerijeZaGledanje() {
			return serijeZaGledanje;
		}
		public void setSerijeZaGledanje(LinkedList<Serija> serijeZaGledanje) {
			this.serijeZaGledanje = serijeZaGledanje;
		}
		@Override
		public String toString() {
			return "Korisnik [Ime i prezime= " + imeIPrezime + ", ID= " + ID + "]";
		}
		@Override
		public void dodajUListuOdgledanihFilmova(LinkedList<Film> odgledaniFilmovi, Film film) {
			odgledaniFilmovi.add(film);
			
		}
		@Override
		public void dodajUListuFilmovaZaGledanje(LinkedList<Film> filmoviZaGledanje, Film film) {
			filmoviZaGledanje.add(film);
			
		}
		@Override
		public void dodajUListuOdgledanihSerija(LinkedList<Serija> odgledaneSerije, Serija serija) {
			odgledaneSerije.add(serija);
			
		}
		@Override
		public void dodajUListuSerijaZaGledanje(LinkedList<Serija> serijeZaGledanje, Serija serija) {
			serijeZaGledanje.add(serija);
			
		}
		@Override
		public LinkedList<Film> filmoviOdredjenogZanra(LinkedList<Film> filmovi, Zanr zanr) {
			LinkedList<Film> filmoviOdredjenogZanra = new LinkedList<Film>();
			for (int i = 0; i < filmovi.size(); i++) {
					if(filmovi.get(i).getZanr().equals(zanr))
						filmoviOdredjenogZanra.add(filmovi.get(i));
			}
			
			return filmoviOdredjenogZanra;
		}
			
		
	}


