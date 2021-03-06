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
import javax.swing.JOptionPane;
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


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
/**
 * Klasa koja sluzi kao glavni prozor pomocu koga se kordinira ostalim funkcijama.
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 *
 */
public class BioskopGUI extends JFrame {

	private JPanel contentPane;
	private Film f = new Film();
	private Serija s = new Serija();
	private JTextField txtImeKorisnika;
	private static JTable table;
	private JLabel lblIdKorisnika;
	private JTextField textField;
	private JButton btnDodajKorisnika;
	private JButton btnPrikaziKorisnika;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public BioskopGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.izadji();
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(BioskopGUI.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bold.png")));
		setTitle("Baza bioskopa");
		setMinimumSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 434);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiDeserijalizaciju();
			}
		});
		mntmOpen.setIcon(new ImageIcon(BioskopGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiSerijalizaciju();
			}
		});
		mntmSave.setIcon(new ImageIcon(BioskopGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(BioskopGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izadji();
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziPodatke();
			}
		});
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new FilmTableModel(null));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.YELLOW);
		panel.setPreferredSize(new Dimension(170, 10));
		contentPane.add(panel, BorderLayout.EAST);
		
		JLabel lblDodajFilm = new JLabel("Dodaj film");
		lblDodajFilm.setPreferredSize(new Dimension(65, 25));
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
		lblDodajSeriju.setPreferredSize(new Dimension(80, 25));
		panel.add(lblDodajSeriju);
		/**
		 * Na dugme Dodaj dodat je ActionEvent kojim se implementira funkcija dodavanja serije u listu preko GUIKontrolera.
		 */
		JButton btnDodajSeriju = new JButton("Dodaj seriju");
		btnDodajSeriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.prikaziDodajSeriju();
			}
		});
		btnDodajSeriju.setPreferredSize(new Dimension(120, 25));
		panel.add(btnDodajSeriju);
		
		JLabel lblPrikaziSerije = new JLabel("Prikazi serije");
		lblPrikaziSerije.setPreferredSize(new Dimension(80, 25));
		panel.add(lblPrikaziSerije);
		/**
		 * Na dugme Prikazu je dodat ActionEvent kojim se implementira funkcija prikaza podataka preko GUIKontrolera.
		 */
		JButton btnPrikaziSerije = new JButton("Prikazi serije");
		btnPrikaziSerije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.prikaziListuSerija();
			}
		});
		
		btnPrikaziSerije.setPreferredSize(new Dimension(120, 25));
		panel.add(btnPrikaziSerije);
		
		JLabel lblSacuvajListuSerija = new JLabel("Sacuvaj listu serija\r\n");
		lblSacuvajListuSerija.setPreferredSize(new Dimension(120, 25));
		lblSacuvajListuSerija.setMinimumSize(new Dimension(100, 14));
		panel.add(lblSacuvajListuSerija);
		/**
		 * Na dugme Sacuvaj je dodat ActionEvent kojim se implementira funkcija cuvanja podataka preko GUIKontrolera.
		 */
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
		/**
		 * Na dugme Otvori je dodat ActionEvent kojim se implementira funkcija otvaranja podataka preko GUIKontrolera.
		 */
		JButton button_1 = new JButton("Otvori\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.izvrsiDeserijalizaciju();
			}
		});
		button_1.setPreferredSize(new Dimension(120, 25));
		panel.add(button_1);
		
		JLabel lblIzbrisiFilm = new JLabel("Izbrisi film");
		lblIzbrisiFilm.setPreferredSize(new Dimension(60, 14));
		panel.add(lblIzbrisiFilm);
		
		JButton btnIzbrisiFilm = new JButton("Izbrisi film");
		btnIzbrisiFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1) {
					GUIKontroler.porukaGreskeBiranjeReda();
				} else {
					int opcija = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da izbrisete izbrani film?", "Poruka",
							JOptionPane.YES_NO_OPTION);
					if (opcija == JOptionPane.YES_OPTION) {
						FilmTableModel model = (FilmTableModel) table.getModel();
						Film k = model.getFilmByIndex(index);
						GUIKontroler.izbrisiFilm(k);
					}
				}
			}
		});
		btnIzbrisiFilm.setPreferredSize(new Dimension(120, 23));
		panel.add(btnIzbrisiFilm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setPreferredSize(new Dimension(150, 120));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		

		JLabel lblImeKorisnika = new JLabel("Ime korisnika:");
		lblImeKorisnika.setBounds(81, 11, 86, 14);
		panel_1.add(lblImeKorisnika);
		
		txtImeKorisnika = new JTextField();
		txtImeKorisnika.setBounds(188, 8, 86, 20);
		panel_1.add(txtImeKorisnika);
		txtImeKorisnika.setColumns(10);
		panel_1.add(getLblIdKorisnika());
		panel_1.add(getTextField());
		panel_1.add(getBtnDodajKorisnika());
		panel_1.add(getBtnPrikaziKorisnika());
		
	}
	
	private JLabel getLblIdKorisnika() {
		if (lblIdKorisnika == null) {
			lblIdKorisnika = new JLabel("ID korisnika:");
			lblIdKorisnika.setBounds(81, 37, 72, 14);
		}
		return lblIdKorisnika;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(188, 34, 86, 20);
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
			btnDodajKorisnika.setBounds(51, 75, 141, 23);
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
	private JButton getBtnPrikaziKorisnika() {
		if (btnPrikaziKorisnika == null) {
			btnPrikaziKorisnika = new JButton("Prikazi korisnika");
			btnPrikaziKorisnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziKorisnike();
				}
			});
			btnPrikaziKorisnika.setBounds(214, 75, 141, 23);
		}
		return btnPrikaziKorisnika;
	}
}
