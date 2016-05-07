package bioskop.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projekcije.filmovi.Film;
import projekcije.serije.Serija;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class BioskopGUI extends JFrame {

	private JPanel contentPane;
	private Film f = new Film();
	private Serija s = new Serija();
	private JTextField txtImeKorisnika;
	private static JTable table;
	private JLabel lblIdKorisnika;
	private JTextField textField;
	private JButton btnDodajKorisnika;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public BioskopGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BioskopGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bold.png")));
		setTitle("Baza bioskopa");
		setMinimumSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new FilmTableModel(null));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(170, 10));
		contentPane.add(panel, BorderLayout.EAST);
		
		JLabel lblDodajFilm = new JLabel("Dodaj film");
		lblDodajFilm.setPreferredSize(new Dimension(90, 25));
		panel.add(lblDodajFilm);
		
		JButton btnDodajFilm = new JButton("Dodaj Film");
		btnDodajFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.prikaziDodajProzor();
			}
		});
		btnDodajFilm.setPreferredSize(new Dimension(120, 25));
		panel.add(btnDodajFilm);
		
		JLabel lblZapamtiListuFilmova = new JLabel("Sacuvaj listu filmova");
		lblZapamtiListuFilmova.setMinimumSize(new Dimension(100, 14));
		lblZapamtiListuFilmova.setPreferredSize(new Dimension(120, 25));
		panel.add(lblZapamtiListuFilmova);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiSerijalizaciju();
			}
		});
		btnSacuvaj.setPreferredSize(new Dimension(120, 25));
		panel.add(btnSacuvaj);
		
		JLabel lblOtvoriListuFilmova = new JLabel("Otvori listu filmova\r\n");
		lblOtvoriListuFilmova.setPreferredSize(new Dimension(120, 25));
		panel.add(lblOtvoriListuFilmova);
		
		JButton btnOtvori = new JButton("Otvori\r\n");
		btnOtvori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiDeserijalizaciju();
			}
		});
		btnOtvori.setPreferredSize(new Dimension(120, 25));
		panel.add(btnOtvori);

		
		JLabel lblDodajSeriju = new JLabel("Dodaj seriju");
		lblDodajSeriju.setPreferredSize(new Dimension(90, 25));
		panel.add(lblDodajSeriju);
		
		JButton btnDodajSeriju = new JButton("Dodaj seriju");
		btnDodajSeriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.prikaziDodajSeriju();
			}
		});
		btnDodajSeriju.setPreferredSize(new Dimension(120, 25));
		panel.add(btnDodajSeriju);
		
		JLabel lblPrikaziSerije = new JLabel("Prikazi serije");
		lblPrikaziSerije.setPreferredSize(new Dimension(90, 25));
		panel.add(lblPrikaziSerije);
		
		JButton btnPrikaziSerije = new JButton("Prikazi serije");
		btnPrikaziSerije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziListuSerija();
			}
		});
		
		btnPrikaziSerije.setPreferredSize(new Dimension(120, 25));
		panel.add(btnPrikaziSerije);
		
		JLabel lblSacuvajListuSerija = new JLabel("Sacuvaj listu serija\r\n");
		lblSacuvajListuSerija.setPreferredSize(new Dimension(110, 25));
		lblSacuvajListuSerija.setMinimumSize(new Dimension(100, 14));
		panel.add(lblSacuvajListuSerija);
		
		JButton button = new JButton("Sacuvaj");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiSerijalizaciju();
			}
		});
		button.setPreferredSize(new Dimension(120, 25));
		panel.add(button);
		
		JLabel lblOtvoriListuSerija = new JLabel("Otvori listu serija\r\n");
		lblOtvoriListuSerija.setPreferredSize(new Dimension(110, 25));
		lblOtvoriListuSerija.setMinimumSize(new Dimension(100, 14));
		panel.add(lblOtvoriListuSerija);
		
		JButton button_1 = new JButton("Otvori\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiDeserijalizaciju();
			}
		});
		button_1.setPreferredSize(new Dimension(120, 25));
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(150, 120));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		

		JLabel lblImeKorisnika = new JLabel("Ime korisnika:");
		lblImeKorisnika.setBounds(29, 11, 86, 14);
		panel_1.add(lblImeKorisnika);
		
		txtImeKorisnika = new JTextField();
		txtImeKorisnika.setBounds(132, 8, 86, 20);
		panel_1.add(txtImeKorisnika);
		txtImeKorisnika.setColumns(10);
		panel_1.add(getLblIdKorisnika());
		panel_1.add(getTextField());
		panel_1.add(getBtnDodajKorisnika());
		
	}
	
	private JLabel getLblIdKorisnika() {
		if (lblIdKorisnika == null) {
			lblIdKorisnika = new JLabel("ID korisnika:");
			lblIdKorisnika.setBounds(29, 37, 86, 14);
		}
		return lblIdKorisnika;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(132, 34, 86, 20);
		}
		return textField;
	}
	private JButton getBtnDodajKorisnika() {
		if (btnDodajKorisnika == null) {
			btnDodajKorisnika = new JButton("Dodaj korisnika");
			btnDodajKorisnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					bioskop.gui.GUIKontroler.unesiKorisnika(txtImeKorisnika.getText(),
							Integer.parseInt(textField.getText()));
				}
			});
			btnDodajKorisnika.setBounds(50, 65, 130, 23);
		}
		return btnDodajKorisnika;
	}
	/**
	 *  Metoda koja osvezava tabelicu filmova.
	 */
	public static void osveziTabeluFilmova(){
		FilmTableModel model = (FilmTableModel) table.getModel();
		model.ucitajFilmove(GUIKontroler.vratiSveFilmove());
	}


}
