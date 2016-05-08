package bioskop.sistemskeoperacije;

import java.util.LinkedList;

import projekcije.filmovi.Film;

public class SOObrisiListuFIlmova {
	public static void izvrsi (Film f, LinkedList<Film> filmovi){
		filmovi.remove(f);
	}
}
