package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Toolkit;
/**
 * Klasa koja sluzi kao prozor za dodavanje  nove serije u listu.
 * @author Ana Jacimovic, Jana Djurovic i Olivera Kordic
 *
 */
public class DodajSeriju extends JFrame {
	private JPanel panel;
	private JLabel lblImeSerije;
	private JTextField textFieldS;
	private JTextField textField_1S;
	private JTextField trajanjeS;
	private JLabel lblOcenaSerije;
	private JLabel lblTrajanjeSerije;
	private JButton button;
	private JButton btnOdustani;
	public DodajSeriju() {
		setMinimumSize(new Dimension(300, 300));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajSeriju.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		setTitle("Dodaj seriju");
		setPreferredSize(new Dimension(150, 150));
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setMinimumSize(new Dimension(150, 150));
			panel.setPreferredSize(new Dimension(130, 130));
			panel.setLayout(null);
			panel.add(getLblImeSerije());
			panel.add(getTextFieldS());
			panel.add(getTextField_1S());
			panel.add(getTrajanjeS());
			panel.add(getLblOcenaSerije());
			panel.add(getLblTrajanjeSerije());
			panel.add(getButton());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLblImeSerije() {
		if (lblImeSerije == null) {
			lblImeSerije = new JLabel("Ime serije:");
			lblImeSerije.setBounds(10, 21, 60, 22);
		}
		return lblImeSerije;
	}
	private JTextField getTextFieldS() {
		if (textFieldS == null) {
			textFieldS = new JTextField();
			textFieldS.setBounds(133, 22, 115, 20);
			textFieldS.setColumns(10);
		}
		return textFieldS;
	}
	private JTextField getTextField_1S() {
		if (textField_1S == null) {
			textField_1S = new JTextField();
			textField_1S.setBounds(158, 53, 90, 20);
			textField_1S.setColumns(10);
		}
		return textField_1S;
	}
	private JTextField getTrajanjeS() {
		if (trajanjeS == null) {
			trajanjeS = new JTextField();
			trajanjeS.setBounds(158, 84, 90, 20);
			trajanjeS.setColumns(10);
		}
		return trajanjeS;
	}
	private JLabel getLblOcenaSerije() {
		if (lblOcenaSerije == null) {
			lblOcenaSerije = new JLabel("Ocena serije (1-5):");
			lblOcenaSerije.setBounds(10, 52, 115, 22);
		}
		return lblOcenaSerije;
	}
	private JLabel getLblTrajanjeSerije() {
		if (lblTrajanjeSerije == null) {
			lblTrajanjeSerije = new JLabel("Trajanje serije (min):");
			lblTrajanjeSerije.setBounds(10, 83, 138, 22);
		}
		return lblTrajanjeSerije;
	}
	/**
	 * Na dugme Dodaj dodat je ActionEvent kojim se implementira funkcija dodavanja serije u listu preko GUIKontrolera.
	 */
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Dodaj");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bioskop.gui.GUIKontroler.unesiSeriju(textFieldS.getText(),
							Integer.parseInt(textField_1S.getText()), Double.parseDouble(trajanjeS.getText()));
					dispose();
					
				}
			});
			button.setBounds(65, 142, 138, 23);
		}
		return button;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(65, 176, 138, 23);
		}
		return btnOdustani;
	}
}
