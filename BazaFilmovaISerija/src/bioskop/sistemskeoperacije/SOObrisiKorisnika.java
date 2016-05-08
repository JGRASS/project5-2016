package bioskop.sistemskeoperacije;

import java.util.LinkedList;

import korisnici.Korisnik;

public class SOObrisiKorisnika {

	public static void izvrsi(Korisnik k, LinkedList<Korisnik> korisnici){
		korisnici.remove();
	}
}
