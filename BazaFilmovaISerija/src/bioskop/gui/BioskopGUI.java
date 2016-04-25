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
		
		JLabel lblPrikaziFilmove = new JLabel("Prikazi filmove");
		lblPrikaziFilmove.setPreferredSize(new Dimension(90, 25));
		panel.add(lblPrikaziFilmove);
		
		JButton btnPrikaziFilmove = new JButton("Prikazi filmove");
		btnPrikaziFilmove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnPrikaziFilmove.setPreferredSize(new Dimension(120, 25));
		panel.add(btnPrikaziFilmove);
		
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
				for(int i = 0; i < projekcije.serije.Serija.serije.size(); i++){
					System.out.println(projekcije.serije.Serija.serije.get(i));
				}
			}
		});
		btnPrikaziSerije.setPreferredSize(new Dimension(120, 25));
		panel.add(btnPrikaziSerije);
		
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
	
	
	public static void osveziTabelu(){
		FilmTableModel model = (FilmTableModel) table.getModel();
		model.ucitajFilmove(GUIKontroler.vratiSveFilmove());
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
}
