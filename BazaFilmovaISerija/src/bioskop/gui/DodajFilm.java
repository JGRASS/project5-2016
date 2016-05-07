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

public class DodajFilm extends JFrame {
	private static JTextField txtIme;
	private static JTextField txtOcena;
	private static JTextField txtZanr;
	private static JTextField txtTrajanje;
	public DodajFilm() {
		setMinimumSize(new Dimension(700, 400));
		setTitle("Dodaj novi film ");
		getContentPane().setMaximumSize(new Dimension(100, 150));
		setPreferredSize(new Dimension(150, 150));
		getContentPane().setSize(new Dimension(120, 100));
		getContentPane().setPreferredSize(new Dimension(10, 10));
		getContentPane().setLayout(null);
		
		JLabel lblImefilma = new JLabel("Ime filma");
		lblImefilma.setBounds(36, 33, 77, 14);
		getContentPane().add(lblImefilma);
		
		txtIme = new JTextField();
		txtIme.setBounds(159, 30, 86, 20);
		getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblOcenaFilma = new JLabel("Ocena filma");
		lblOcenaFilma.setBounds(36, 109, 77, 14);
		getContentPane().add(lblOcenaFilma);
		
		txtOcena = new JTextField();
		txtOcena.setBounds(159, 106, 86, 20);
		getContentPane().add(txtOcena);
		txtOcena.setColumns(10);
		
		JLabel lblZanrFilma = new JLabel("Zanr filma");
		lblZanrFilma.setBounds(36, 69, 91, 12);
		getContentPane().add(lblZanrFilma);
		
		txtZanr = new JTextField();
		txtZanr.setBounds(159, 61, 86, 20);
		getContentPane().add(txtZanr);
		txtZanr.setColumns(10);
		
		JLabel lblTrajanjeFilma = new JLabel("Trajanje filma");
		lblTrajanjeFilma.setBounds(36, 149, 113, 14);
		getContentPane().add(lblTrajanjeFilma);
		
		txtTrajanje = new JTextField();
		txtTrajanje.setBounds(159, 146, 86, 20);
		getContentPane().add(txtTrajanje);
		txtTrajanje.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setMinimumSize(new Dimension(400, 500));
		btnDodaj.setBounds(121, 193, 113, 23);
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
		btnOdustani.setBounds(271, 193, 130, 23);
		getContentPane().add(btnOdustani);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblImefilma, txtIme, lblOcenaFilma, txtOcena, lblZanrFilma, txtZanr, lblTrajanjeFilma, txtTrajanje, btnDodaj, btnOdustani}));
	}
	
	
	
}
