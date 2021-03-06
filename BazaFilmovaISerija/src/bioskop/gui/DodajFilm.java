package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Character.UnicodeScript;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Color;
/**
 * Klasa koja sluzi kao prozor za dodavanje  novog filma u listu.
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 *
 */
public class DodajFilm extends JFrame {
	private static JTextField txtIme;
	private static JTextField txtOcena;
	private static JTextField txtZanr;
	private static JTextField txtTrajanje;
	public DodajFilm() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajFilm.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		setMinimumSize(new Dimension(300, 370));
		setTitle("Dodaj novi film ");
		getContentPane().setMaximumSize(new Dimension(100, 150));
		setPreferredSize(new Dimension(120, 150));
		getContentPane().setSize(new Dimension(120, 100));
		getContentPane().setPreferredSize(new Dimension(10, 10));
		getContentPane().setLayout(null);
		
		JLabel lblImefilma = new JLabel("Ime filma:");
		lblImefilma.setBounds(36, 33, 77, 14);
		getContentPane().add(lblImefilma);
		
		txtIme = new JTextField();
		txtIme.setBounds(147, 30, 86, 20);
		getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblOcenaFilma = new JLabel("Ocena filma (1-5):");
		lblOcenaFilma.setBounds(36, 95, 101, 14);
		getContentPane().add(lblOcenaFilma);
		
		txtOcena = new JTextField();
		txtOcena.setBounds(147, 92, 86, 20);
		getContentPane().add(txtOcena);
		txtOcena.setColumns(10);
		
		JLabel lblZanrFilma = new JLabel("Zanr filma:");
		lblZanrFilma.setBounds(36, 65, 91, 12);
		getContentPane().add(lblZanrFilma);
		
		txtZanr = new JTextField();
		txtZanr.setBounds(147, 61, 86, 20);
		getContentPane().add(txtZanr);
		txtZanr.setColumns(10);
		
		JLabel lblTrajanjeFilma = new JLabel("Trajanje filma (min):");
		lblTrajanjeFilma.setBounds(36, 126, 113, 14);
		getContentPane().add(lblTrajanjeFilma);
		
		txtTrajanje = new JTextField();
		txtTrajanje.setBounds(147, 123, 86, 20);
		getContentPane().add(txtTrajanje);
		txtTrajanje.setColumns(10);
		/**
		 * Na dugme Dodaj dodat je ActionEvent kojim se implementira funkcija dodavanja filma u listu preko GUIKontrolera.
		 */
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setMinimumSize(new Dimension(400, 500));
		btnDodaj.setBounds(86, 193, 130, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bioskop.gui.GUIKontroler.unesiFilm(txtIme.getText(), txtZanr.getText(),
						Integer.parseInt(txtOcena.getText()), Double.parseDouble(txtTrajanje.getText()));
				dispose();
				
			}
		});
		getContentPane().add(btnDodaj);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(86, 227, 130, 23);
		getContentPane().add(btnOdustani);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblImefilma, txtIme, lblOcenaFilma, txtOcena, lblZanrFilma, txtZanr, lblTrajanjeFilma, txtTrajanje, btnDodaj, btnOdustani}));
	}
}
