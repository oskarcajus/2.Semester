package KAS.gui;

import controller.Controller;
import model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javax.swing.*;

public class KonferenceInputWindow extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Konference");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		deltagerInputWindow = new DeltagerInputWindow("Deltagerinformation", stage);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -----------------------------------------------
	private ListView<Konference> lstChoice;
	private TextArea txaDesc;
	private DeltagerInputWindow deltagerInputWindow;

	// -----------------------------------------------
	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10.0));
		pane.setHgap(10);
		pane.setVgap(10);
		// -------------------------------------------
		GridPane screen = new GridPane();
		pane.add(screen, 0, 0);
		screen.setGridLinesVisible(false);
		screen.setPadding(new Insets(10.0));
		screen.setHgap(10);
		screen.setVgap(10);
		// -------------------------------------------
		lstChoice = new ListView<>();
		txaDesc = new TextArea();
		// -------------------------------------------
		// Valg af konference
		Controller.initStorage();
		screen.add(lstChoice, 1, 1);
		for (Konference k : Controller.getKonferencer()) {
			lstChoice.getItems().add(k);
		}
		lstChoice.setMaxSize(150.0, 200.0);
		// -------------------------------------------
		// Beskrivelse af konference
		screen.add(txaDesc, 10, 1);
		txaDesc.setMaxSize(150.0, 200.0);
		txaDesc.setEditable(false);
		// -------------------------------------------
		// Lytter til beskrivelse og valg af konference
		ChangeListener<? super Konference> listener = (ov, oldString, newString) -> this.selectionChanged();
		lstChoice.getSelectionModel().selectedItemProperty().addListener(listener);
		// -------------------------------------------
		// Tilmeld
		Button btnProceed = new Button("Tilmeld.");
		screen.add(btnProceed, 10, 2);
		btnProceed.setOnAction(event -> buttonClicked());
	}

	private void selectionChanged() {
		Konference newKonference = lstChoice.getSelectionModel().getSelectedItem();
		if (newKonference != null) {
			txaDesc.setText("Adresse: " + newKonference.getAdresse() + "\nPris (pr dag): "
					+ newKonference.getPrisPrDag() + "\nBeskrivelse: " + newKonference.getBeskrivelse() + "\nStart: "
					+ newKonference.getStartDato() + "\nSlut: " + newKonference.getSlutDato());
		} else {
			txaDesc.clear();
		}
	}

	private void buttonClicked() {
		Konference newKonference = lstChoice.getSelectionModel().getSelectedItem();
		if (newKonference != null) {
			JOptionPane.showMessageDialog(null, "Du har valgt følgende: " + newKonference.getNavn());
			Controller.createRegistrering(newKonference, newKonference.getStartDato(), newKonference.getSlutDato());
		} else {
			txaDesc.clear();
		}
		deltagerInputWindow.showAndWait();
	}
	
}