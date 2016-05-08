package bioskop.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.FilteringMode;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import korisnici.Korisnik;
import projekcije.Metode;
import projekcije.filmovi.Film;
import projekcije.serije.Serija;

public class GUIKontroler {
	public static BioskopGUI frame;
	public static Metode metoda;
	public static PrikaziSerijeGUI prozor;
	public static DodajKorisnikaGUI noviProzor;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					metoda = new Metode();
					frame = new BioskopGUI();
					prozor = new PrikaziSerijeGUI();
					noviProzor = new DodajKorisnikaGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
	public static void prikaziListuSerija() {
		PrikaziSerijeGUI prozor = new PrikaziSerijeGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void unesiFilm(String ime, String zanr, int ocena,  double trajanje){
		Film f = new Film();
		
		f.setIme(ime);
		f.setZanr(zanr);
		f.setOcena(ocena);
		f.setTrajanje(trajanje);
		
		metoda.napuniListuFilmova(f);
		BioskopGUI.osveziTabeluFilmova();
		
	}	
			
	public static void unesiSeriju(String ime, int ocena, double trajanje){
		Serija s = new Serija();
		
		s.setImeSerije(ime);
		s.setOcenaSerije(ocena);
		s.setTrajanjeSerije(trajanje);
		
		metoda.napuniListuSerija(s);
		prozor.osveziTabeluSerija();
		
	}
	
	public static void unesiKorisnika(String ime, int ID){
		Korisnik k = new Korisnik();
		
		k.setImeIPrezime(ime);
		k.setID(ID);
		
		metoda.napuniListuKorisnika(k);
		noviProzor.osveziTabeluKorisnika();
		
	}
	
	public static List<Film> vratiSveFilmove() {
		return metoda.vratiListuFilmova();
	}
	
	public static LinkedList<Serija> vratiSveSerije() {
		return metoda.vratiListuSerija();
	}
	
	public static void izvrsiSerijalizaciju() {
		
		JFileChooser save = new JFileChooser();
		int vrednost = save.showSaveDialog(frame.getContentPane());
		if (vrednost == JFileChooser.APPROVE_OPTION) {
			
			
			File file = new File(save.getSelectedFile().getAbsolutePath() + System.getProperty("file.separator"));

			try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
				out.writeObject(vratiSveFilmove());
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(frame.getContentPane(), "Fajl je sacuvan :)", "Poruka",
					JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	public static void izvrsiDeserijalizaciju(){
		
		JFileChooser fc = new JFileChooser();
		int value = fc.showOpenDialog(frame);
		if (value == JFileChooser.APPROVE_OPTION) {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Fajl je uspeno otvoren.", "Poruka",
					JOptionPane.PLAIN_MESSAGE);
			}
		}

	public static List<Korisnik> vratiSveKorinike() {
		return metoda.vratiListuKorisnika();
	}


	public static void prikaziKorisnike() {
		DodajKorisnikaGUI prozor = new DodajKorisnikaGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}

	public static void izbrisiFilm(Film f){
		metoda.obrisiFilm(f);
		frame.osveziTabeluFilmova();
	}
	public static void porukaGreskeBiranjeReda() {
		JOptionPane.showMessageDialog(frame.getContentPane(), "Izaberite podatke za brisanje!", "Greska!!!",
				JOptionPane.ERROR_MESSAGE);
	}


	public static void izbrisiSeriju(Serija s) {
		metoda.obrisiSeriju(s);
		prozor.osveziTabeluSerija();
		
	}


	public static void izbrisiKorisnika(Korisnik k) {
		metoda.obrisiKorisnika(k);
		noviProzor.osveziTabeluKorisnika();
	}
	
	public static void izadji() {
		int povratnaVrednost = JOptionPane.showConfirmDialog(frame.getContentPane(),
				"Da li zelite da izadjete iz programa?", "Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);

		if (povratnaVrednost == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	
	public static void prikaziPodatke() {
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(frame, "Olivera Kordic \n Ana Jacimovic \n Jana Djurovic \n FON 2016", "Informacije", 1);
		
	}

}
	

	

