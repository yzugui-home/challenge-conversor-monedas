package vista;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.ConversorMoneda;

public class VentanaMonedas extends VentanaConversorMonedas {

	private ConversorMoneda conversor = new ConversorMoneda();

	public VentanaMonedas() {
		super();

		this.agregarListaDivisas();
		this.editarBotonInversion();
		this.editarBotonConversor();
		this.editarBotonCopiar();
	}

	private void agregarListaDivisas() {
		String[] monedas = { "",
				"Peso mexicano (MXN)",
				"Dólar estadounidense (USD)",
				"Euro (EUR)",
				"Libra esterlina (GBP)",
				"Yen japonés (JPY)",
				"Sol peruano (PEN)" };

		for (String moneda : monedas) {
			this.getEntradaDivisaOrigen().addItem(moneda);
			this.getEntradaDivisaDestino().addItem(moneda);

		}
	}

	private void editarBotonInversion() {

		JComboBox<String> divisaOrigen = this.getEntradaDivisaOrigen();
		JComboBox<String> divisaDestino = this.getEntradaDivisaDestino();

		this.getBotonInversor().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object seleccionadoOrigen = divisaOrigen.getSelectedItem();
				Object seleccionadoDestino = divisaDestino.getSelectedItem();

				divisaOrigen.setSelectedItem(seleccionadoDestino);
				divisaDestino.setSelectedItem(seleccionadoOrigen);
			}
		});

		this.getBotonInversor().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getBotonInversor().doClick();
				}
			}
		});
	}

	private void editarBotonConversor() {
		JTextField entrada = this.getCajaEntrada();
		JComboBox<String> divisaOrigen = this.getEntradaDivisaOrigen();
		JComboBox<String> divisaDestino = this.getEntradaDivisaDestino();
		JLabel salida = this.getLabelSalida();
		JLabel salidaUnidadCambio = this.getSalidaUnidadDivisa();
		JButton copiar = this.getBotonCopiar();

		this.getBotonConversor().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getBotonConversor().doClick();
				}
			}
		});

		this.getBotonConversor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CharSequence seleccionadoOrigen = (CharSequence) divisaOrigen.getSelectedItem();
				CharSequence seleccionadoDestino = (CharSequence) divisaDestino.getSelectedItem();

				String origen = "", destino = "";
				double conversion, tasa;

				if (seleccionadoOrigen == "" || seleccionadoDestino == "" || entrada.getText() == "") {
					return;
				}

				Pattern pattern = Pattern.compile("(\\()(.*?)(\\))");
				Matcher matcherOrigen = pattern.matcher(seleccionadoOrigen);
				Matcher matcherDestino = pattern.matcher(seleccionadoDestino);
				Double entradaCantidad;

				try {
					entradaCantidad = Double.valueOf(entrada.getText());
					if (entradaCantidad < 0) {
						JOptionPane.showMessageDialog(copiar, "Por favor, ingrese solo valores positivos");
						return;
					}
				} catch (NumberFormatException eString) {
					JOptionPane.showMessageDialog(copiar, "Por favor, ingrese un valor numérico");
					return;
				}

				while (matcherOrigen.find()) {
					origen = matcherOrigen.group(2);
				}

				while (matcherDestino.find()) {
					destino = matcherDestino.group(2);
				}

				conversor.setCantidad(entradaCantidad);
				conversor.setMonedaOrigen(origen);
				conversor.setMonedaDestino(destino);
				conversion = conversor.ConvertirMonedas();
				tasa = conversor.getTasa();

				salida.setText(conversion + " " + destino);
				salidaUnidadCambio.setText("1 " + seleccionadoOrigen + " = " + tasa + " " + seleccionadoDestino);
				copiar.setEnabled(true);

			}
		});

	}

	private void editarBotonCopiar() {

		this.getBotonCopiar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double cantidad = conversor.getActualConversion();
				Clipboard click = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(String.valueOf(cantidad));

				click.setContents(stringSelection, null);
			}
		});

	}

}
