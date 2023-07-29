package alura;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import alura.models.ApiLayerResponse;
import alura.models.ImageWithDescription;
import alura.models.ShowInfo;
import utils.Exchange;
import utils.JComboBoxRenderer;
import utils.Util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class Converter {
	private JFrame frmConversorDeMonedas;
	
	private ArrayList<ImageWithDescription> imagesWithDescriptions = new ArrayList<>();
	//private Hashtable<Object, ImageIcon> items;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Converter window = new Converter();
					window.frmConversorDeMonedas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application. */
	public Converter() {		
		initialize();
	}
	
	
	

	/** Initialize the contents of the frame. */
	private void initialize() {
		frmConversorDeMonedas = new JFrame();
	
		frmConversorDeMonedas.setTitle("Conversor de Monedas");
		frmConversorDeMonedas.setBounds(100, 100, 850, 288);
		frmConversorDeMonedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmConversorDeMonedas.getContentPane().setLayout(null);

		/*Etiqueta y texto de Importe a convertir*/
		JLabel lblAmountToConvert = new JLabel("Importe");
		lblAmountToConvert.setBounds(30, 41, 55, 15);
		frmConversorDeMonedas.getContentPane().add(lblAmountToConvert);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(1000);
	    formatter.setAllowsInvalid(true);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
	    
	    JTextField tfgivenAmount = new JTextField();
	    tfgivenAmount.setBounds(30, 57, 82, 33);
	    tfgivenAmount.setText("0");
	   	frmConversorDeMonedas.getContentPane().add(tfgivenAmount);
	    tfgivenAmount.setColumns(10);
		 
		/*Etiqueta y Combo Moneda de*/
		JLabel lblSourceCoin = new JLabel("De  ");
		lblSourceCoin.setBounds(124, 41, 27, 15);
		frmConversorDeMonedas.getContentPane().add(lblSourceCoin);
		
		imagesWithDescriptions = Util.GetImagesWithDescriptions();
		
		JComboBoxRenderer render = new JComboBoxRenderer(imagesWithDescriptions); 
		
		JComboBox<ImageWithDescription> cbCurrencyFrom = new JComboBox(imagesWithDescriptions.toArray());
		cbCurrencyFrom.setRenderer(render);

		cbCurrencyFrom.setBounds(124, 57, 330, 33);
		frmConversorDeMonedas.getContentPane().add(cbCurrencyFrom);
			
		/*Etiqueta y Combo Moneda a*/
		JLabel lblTargetCoin = new JLabel("a");
		lblTargetCoin.setBounds(475, 41, 9, 15);
		frmConversorDeMonedas.getContentPane().add(lblTargetCoin);
		
		JComboBox cbCurrencyTo = new JComboBox(imagesWithDescriptions.toArray());
		cbCurrencyTo.setRenderer(render); 
		cbCurrencyTo.setBounds(475, 57, 330, 33);
		frmConversorDeMonedas.getContentPane().add(cbCurrencyTo);
		
		/*Etiqueta de Cantidad Convertida*/
		JLabel lblConvertedAmount = new JLabel();
		lblConvertedAmount.setBounds(30, 133, 700, 37);
		frmConversorDeMonedas.getContentPane().add(lblConvertedAmount);
		
		/*Etiqueta de Equivalencia monedas seleccionadas*/
		JLabel lblEquivalent = new JLabel("=");
		lblEquivalent.setBounds(30, 106, 187, 15);
		frmConversorDeMonedas.getContentPane().add(lblEquivalent);
		
		/*Boton que cancela la conversion y limpia los cambios*/
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConversorDeMonedas.dispose();
			}
		});
		btnCancel.setBounds(500, 177, 117, 25);
		frmConversorDeMonedas.getContentPane().add(btnCancel);
		
		/*Boton que hace la conversion*/
		JButton btnConvert = new JButton("Convertir");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double amount = Double.parseDouble(tfgivenAmount.getText());
				Exchange exchange = new Exchange();
				ShowInfo from = GetCode(cbCurrencyFrom);
				ShowInfo to = GetCode(cbCurrencyTo);
				ApiLayerResponse alr = exchange.Convert(from.getKey(), to.getKey() , amount.toString());
				lblConvertedAmount.setText("$" + amount + " "+ from.getValue() + " = $" + alr.getResult() + " "+ to.getValue());
			}
		});
		btnConvert.setBounds(690, 177, 117, 25);
		frmConversorDeMonedas.getContentPane().add(btnConvert);
	}
	
	private ShowInfo GetCode(JComboBox jcb) {
		ImageWithDescription item = (ImageWithDescription) jcb.getSelectedItem();
		String description = item.get_description();
		
		int indexFrom = description.indexOf(" - ");
		String code = description.substring(0, indexFrom);
		String currency = description.substring(indexFrom + 3, description.length());
		ShowInfo showInfo = new ShowInfo();
		showInfo.setKey(code);
		showInfo.setValue(currency);

		return showInfo;
	}
}
