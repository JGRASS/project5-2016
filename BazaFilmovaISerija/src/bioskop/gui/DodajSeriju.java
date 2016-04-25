package bioskop.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
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
			textFieldS.setBounds(94, 22, 86, 20);
			textFieldS.setColumns(10);
		}
		return textFieldS;
	}
	private JTextField getTextField_1S() {
		if (textField_1S == null) {
			textField_1S = new JTextField();
			textField_1S.setBounds(94, 59, 86, 20);
			textField_1S.setColumns(10);
		}
		return textField_1S;
	}
	private JTextField getTrajanjeS() {
		if (trajanjeS == null) {
			trajanjeS = new JTextField();
			trajanjeS.setBounds(94, 99, 86, 20);
			trajanjeS.setColumns(10);
		}
		return trajanjeS;
	}
	private JLabel getLblOcenaSerije() {
		if (lblOcenaSerije == null) {
			lblOcenaSerije = new JLabel("Ocena serije:");
			lblOcenaSerije.setBounds(10, 58, 86, 22);
		}
		return lblOcenaSerije;
	}
	private JLabel getLblTrajanjeSerije() {
		if (lblTrajanjeSerije == null) {
			lblTrajanjeSerije = new JLabel("Trajanje serije:");
			lblTrajanjeSerije.setBounds(10, 97, 74, 22);
		}
		return lblTrajanjeSerije;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Dodaj");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bioskop.gui.GUIKontroler.unesiSeriju(textFieldS.getText(),
							Integer.parseInt(textField_1S.getText()), Double.parseDouble(trajanjeS.getText()));
					
				}
			});
			button.setBounds(122, 128, 61, 23);
		}
		return button;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnOdustani.setBounds(191, 128, 75, 23);
		}
		return btnOdustani;
	}
}
