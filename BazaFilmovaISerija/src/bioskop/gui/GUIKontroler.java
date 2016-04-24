package bioskop.gui;

import java.awt.EventQueue;

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


}
