package bioskop.gui;

import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Locale.FilteringMode;

import korisnici.Korisnik;
import projekcije.filmovi.Film;
import projekcije.serije.Serija;

public class GUIKontroler {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BioskopGUI frame = new BioskopGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void prikaziDodajProzor(){
		DodajFilm prozor = new DodajFilm();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	public static void prikaziDodajSeriju(){
		DodajSeriju prozor1 = new DodajSeriju();
		prozor1.setVisible(true);
		prozor1.setLocationRelativeTo(null);
	}
	public static void unesiFilm(String ime, String zanr, int ocena,  double trajanje){
		Film f = new Film();
		
		f.setIme(ime);
		f.setZanr(zanr);
		f.setOcena(ocena);
		f.setTrajanje(trajanje);
		
		projekcije.Metode.napuniListuFilmova(f);
		BioskopGUI.osveziTabelu();
		
	}
	public static void unesiSeriju(String ime, int ocena, double trajanje){
		Serija s = new Serija();
		
		s.setImeSerije(ime);
		s.setOcenaSerije(ocena);
		s.setTrajanjeSerije(trajanje);
		
		projekcije.Metode.napuniListuSerija(s);
		
	}

	public static void unesiKorisnika(String ime, int ID){
		Korisnik k = new Korisnik();
		
		k.setImeIPrezime(ime);
		k.setID(ID);
		
		projekcije.Metode.napuniListuKorisnika(k);
		}


	public static List<Film> vratiSveFilmove() {
		return projekcije.Metode.vratiListuFilmova();
	}
}
