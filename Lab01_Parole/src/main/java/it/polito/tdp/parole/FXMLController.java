package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private TextArea txtTempiDiEsecuzione;

	@FXML
	private Button btnReset;

	@FXML
	private Button btnCancella;

	@FXML
	void doInsert(ActionEvent event) {
		String parola = txtParola.getText();
		if (parola.length() == 0) {
			txtResult.setText("Inserisci una parola!");
			return;
		}
		boolean verbale = false;
		try {

			Integer.parseInt(parola);

		} catch (Exception e) {
			verbale = true;
		}
		
		if(!verbale) {
			txtResult.setText("Hai inserito un numero!");
			return;
		}
		elenco.addParola(parola);
		String risultato = "";
		for (String s : elenco.getElenco())
			risultato += s + "\n";
		txtResult.setText(risultato);

		txtTempiDiEsecuzione.appendText("" + System.nanoTime() + "\n");

	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		txtResult.setText("");
		txtTempiDiEsecuzione.appendText("" + System.nanoTime() + "\n");
	}

	@FXML
	void doCancella(ActionEvent event) {
		String parola = txtResult.getSelectedText();
		elenco.cancellaParola(parola);
		String risultato = "";
		for (String s : elenco.getElenco())
			risultato += s + "\n";
		txtResult.setText(risultato);
		txtTempiDiEsecuzione.appendText("" + System.nanoTime() + "\n");

	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
