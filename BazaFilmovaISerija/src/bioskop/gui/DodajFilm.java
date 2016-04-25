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
		setTitle("Dodaj novi film ");
		getContentPane().setMaximumSize(new Dimension(100, 150));
		setPreferredSize(new Dimension(120, 10));
		getContentPane().setSize(new Dimension(120, 100));
		getContentPane().setPreferredSize(new Dimension(10, 10));
		getContentPane().setLayout(null);
		
		JLabel lblImefilma = new JLabel("Ime filma");
		lblImefilma.setBounds(39, 8, 43, 14);
		getContentPane().add(lblImefilma);
		
		txtIme = new JTextField();
		txtIme.setBounds(87, 5, 86, 20);
		getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblOcenaFilma = new JLabel("Ocena filma");
		lblOcenaFilma.setBounds(178, 8, 56, 14);
		getContentPane().add(lblOcenaFilma);
		
		txtOcena = new JTextField();
		txtOcena.setBounds(239, 5, 86, 20);
		getContentPane().add(txtOcena);
		txtOcena.setColumns(10);
		
		JLabel lblZanrFilma = new JLabel("Zanr filma");
		lblZanrFilma.setBounds(113, 33, 47, 14);
		getContentPane().add(lblZanrFilma);
		
		txtZanr = new JTextField();
		txtZanr.setBounds(165, 30, 86, 20);
		getContentPane().add(txtZanr);
		txtZanr.setColumns(10);
		
		JLabel lblTrajanjeFilma = new JLabel("Trajanje filma");
		lblTrajanjeFilma.setBounds(256, 33, 65, 14);
		getContentPane().add(lblTrajanjeFilma);
		
		txtTrajanje = new JTextField();
		txtTrajanje.setBounds(326, 30, 86, 20);
		getContentPane().add(txtTrajanje);
		txtTrajanje.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(146, 55, 61, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bioskop.gui.GUIKontroler.unesiFilm(txtIme.getText(), txtZanr.getText(),
						Integer.parseInt(txtOcena.getText()), Double.parseDouble(txtTrajanje.getText()));
				
			}
		});
		getContentPane().add(btnDodaj);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOdustani.setBounds(212, 55, 75, 23);
		getContentPane().add(btnOdustani);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblImefilma, txtIme, lblOcenaFilma, txtOcena, lblZanrFilma, txtZanr, lblTrajanjeFilma, txtTrajanje, btnDodaj, btnOdustani}));
	}
	
	public static void unesiUFajl(){
		String ime =txtIme.getText();
		String zanr = txtZanr.getText();
		int ocena = Integer.parseInt(txtOcena.getText());
		double trajanje = Double.parseDouble(txtTrajanje.getText());
		
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("filmovi.txt")));
			System.out.println("Ime filma: ");
			out.println(ime);
			System.out.println("Zanr filma: ");
			out.println(zanr);
			System.out.println("Ocena filma: ");
			out.println(ocena);
			System.out.println("Trajanje filma: ");
			out.print(trajanje);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
