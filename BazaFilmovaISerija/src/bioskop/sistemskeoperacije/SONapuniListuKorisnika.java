package bioskop.sistemskeoperacije;

import java.util.LinkedList;

import korisnici.Korisnik;

public class SONapuniListuKorisnika {
	public static void izvrsi(Korisnik k, LinkedList<Korisnik> korisnici){
		korisnici.add(k);
	}
}
