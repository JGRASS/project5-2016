package korisnici.interfejs;

import java.util.LinkedList;

import projekcije.filmovi.Film;
import projekcije.filmovi.zanr.Zanr;
import projekcije.serije.Serija;

public interface InterfejsKorisnik {
	
	public void dodajUListuOdgledanihFilmova(LinkedList<Film> odgledaniFilmovi,Film film);
	public void dodajUListuFilmovaZaGledanje(LinkedList<Film> filmoviZaGledanje,Film film);
	public void dodajUListuOdgledanihSerija(LinkedList<Serija> odgledaneSerije,Serija serija);
	public void dodajUListuSerijaZaGledanje(LinkedList<Serija> serijeZaGledanje, Serija serija);
	public LinkedList<Film> filmoviOdredjenogZanra(LinkedList<Film> filmovi,Zanr zanr);
}
