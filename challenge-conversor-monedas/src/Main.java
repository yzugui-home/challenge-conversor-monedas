import java.awt.EventQueue;

import vista.*;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonedas window = new VentanaMonedas();
					window.getFrmConversorDeDivisas().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
