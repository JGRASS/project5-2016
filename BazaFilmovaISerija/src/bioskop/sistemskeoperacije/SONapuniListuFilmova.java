package bioskop.sistemskeoperacije;

import java.util.LinkedList;

import projekcije.filmovi.Film;

public class SONapuniListuFilmova {
	public static void izvrsi (Film f, LinkedList<Film> filmovi){
		filmovi.add(f);
	}
}
