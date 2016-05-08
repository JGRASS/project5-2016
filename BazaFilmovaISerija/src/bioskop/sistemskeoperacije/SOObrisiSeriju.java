package bioskop.sistemskeoperacije;

import java.util.LinkedList;

import projekcije.serije.Serija;

public class SOObrisiSeriju {
	public static void izvrsi(Serija s, LinkedList<Serija> serije){
		serije.remove(s);
	}
}
