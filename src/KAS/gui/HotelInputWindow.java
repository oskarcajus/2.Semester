package KAS.gui;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;
import controller.*;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class HotelInputWindow extends Stage {

	public HotelInputWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(true);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		samletPrisWindow = new SamletPrisWindow("Samlet pris", owner);
		this.setScene(scene);
	}

	private SamletPrisWindow samletPrisWindow;
	private ListView<Hotel> listChoice;
	private ListView<Facilitet> listfaciliteter;
	private TextArea description;
	private TextField facilitetpris;
	private Registrering registrering;
	

	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		Label lblName = new Label("hoteller");
		pane.add(lblName, 0, 0);
		Label lblName2 = new Label("beskrivelse og pris");
		pane.add(lblName2, 1, 0);
		Label lblName3 = new Label("faciliteter");
		pane.add(lblName3, 0, 6);
		Label lblName4 = new Label("facilitetspris");
		pane.add(lblName4, 1, 6);

		GridPane screen = new GridPane();
		pane.add(screen, 1, 12, 1, 1);
		screen.setGridLinesVisible(false);
		screen.setHgap(10);
		screen.setVgap(10);
		listChoice = new ListView<Hotel>();

		for (Hotel h : Controller.getHoteller()) {
			listChoice.getItems().add(h);
		}

		pane.add(listChoice, 0, 1, 1, 3);
		listChoice.setPrefHeight(10);

		listfaciliteter = new ListView<Facilitet>();

		pane.add(listfaciliteter, 0, 7, 1, 4);
		listfaciliteter.setPrefHeight(30);

		description = new TextArea();
		pane.add(description, 1, 1, 1, 1);
		description.setMaxSize(220.0, 200.0);

		facilitetpris = new TextField();
		pane.add(facilitetpris, 1, 7);
		facilitetpris.setMaxSize(70.0, 200.0);

		Button btnProceed = new Button("bekræft");
		pane.add(btnProceed, 2, 16, 1, 1);
		btnProceed.setOnAction(event -> buttonClicked());

		ChangeListener<? super Hotel> listener = (ov, oldString, newString) -> this.selectionChanged();
		listChoice.getSelectionModel().selectedItemProperty().addListener(listener);

		ChangeListener<Facilitet> listener2 = (ov, oldString, newString) -> this.selectionChanged2();
		listfaciliteter.getSelectionModel().selectedItemProperty().addListener(listener2);

		listfaciliteter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	private void selectionChanged() {
		Hotel newString = listChoice.getSelectionModel().getSelectedItem();
		if (newString != null) {
			listfaciliteter.getItems().clear();
			description.setText("hotel navn: " + newString.getName() + "\n" + "Adresse: " + newString.getAdresse()
					+ "\n" + "pris for enkelt værelse: " + newString.getPrisEnkeltVærelse() + "\n"
					+ "Pris for dobbelt værelse: " + newString.getPrisDobbeltVærelse());
			for (Facilitet f : Controller.getFaciliteter(newString)) {
				listfaciliteter.getItems().add(f);
			}
		} else {
			description.clear();
		}
	}

	private void selectionChanged2() {
		Facilitet newString2 = listfaciliteter.getSelectionModel().getSelectedItem();
		ObservableList<Facilitet> selectedfaciliteter = listfaciliteter.getSelectionModel().getSelectedItems();
		if (newString2 != null) {
			double pris = 0;
			for (Facilitet f : selectedfaciliteter) {
				pris += f.getPris();
			}
			facilitetpris.setText(pris + "Kr");
		}

		else {
			description.clear();
		}
	}

	private void buttonClicked() {
		int index = Controller.getKonferencer().get(0).getRegistreringer().size();
		registrering = Controller.getKonferencer().get(0).getRegistreringer().get(index - 1);
		Hotel hotel = (Hotel) listChoice.getSelectionModel().getSelectedItem();

		ObservableList<Facilitet> selectedFacilitet = listfaciliteter.getSelectionModel().getSelectedItems();
		ObservableList<Hotel> selectedHotel = listChoice.getSelectionModel().getSelectedItems();
		if (!selectedHotel.isEmpty()) {
			if (registrering.getLedsager() != null) {

			}
			Controller.addHotelToRegistrering(registrering, hotel);
		}

		for (Facilitet f : selectedFacilitet) {
			if (!selectedFacilitet.isEmpty()) {
				Controller.addFacilitetToRegistrering(registrering, f);
			}
		}
		// Initialiserer den samlede pris for næste vindue (SamletPris)
		samletPrisWindow.visPriser();

		// Viser næste vindue
		samletPrisWindow.showAndWait();

	}

}
