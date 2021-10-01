package KAS.gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import javafx.collections.ObservableList;

public class DeltagerInputWindow extends Stage {

	public DeltagerInputWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(true);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		hotelInputWindow = new HotelInputWindow("Hotelinformation", hotelInputWindow);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------
	// Næste vindue
	private HotelInputWindow hotelInputWindow;

	private TextField txfNavn;
	private TextField txfAdresse;
	private TextField txfAlder;
	private TextField txfTlfNr;
	private CheckBox chkErMand;
	private CheckBox chkErKvinde;
	private CheckBox chkErForedragsholder;

	private Separator separator;
	private TextField txfLedsager;
	private ListView<Udflugt> listUdflugter;

	private Registrering registrering;

	private Deltager deltager;
	

	private void initContent(GridPane pane) {
		
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblNavn = new Label("Navn: ");
		pane.add(lblNavn, 0, 0);
		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);

		Label lblAdresse = new Label("Adresse: ");
		pane.add(lblAdresse, 0, 2);
		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 3);

		Label lblAlder = new Label("Alder: ");
		pane.add(lblAlder, 0, 4);
		txfAlder = new TextField();
		pane.add(txfAlder, 0, 5);

		Label lblTlfNr = new Label("Telefon nr: ");
		pane.add(lblTlfNr, 0, 6);
		txfTlfNr = new TextField();
		pane.add(txfTlfNr, 0, 7);

		Label lblKøn = new Label("Køn: ");
		pane.add(lblKøn, 0, 8);
		chkErMand = new CheckBox("Mand");
		chkErKvinde = new CheckBox("Kvinde");
		pane.add(chkErMand, 1, 8);
		pane.add(chkErKvinde, 2, 8);

		Label lblErForedragsholder = new Label("Foredragsholder: ");
		pane.add(lblErForedragsholder, 0, 9);
		chkErForedragsholder = new CheckBox();
		pane.add(chkErForedragsholder, 1, 9);

		separator = new Separator();
		pane.add(separator, 0, 10, 8, 1);

		Label lblLedsager = new Label("Navn på evt. ledsager: ");
		pane.add(lblLedsager, 0, 11);
		txfLedsager = new TextField();
		pane.add(txfLedsager, 0, 12);

		Label lblUdflugter = new Label("Vælg evt. en eller flere udflugter til din ledsager:");
		pane.add(lblUdflugter, 0, 13);
		listUdflugter = new ListView<Udflugt>();
		listUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		for (Udflugt u : Controller.getUdflugter()) {
			listUdflugter.getItems().add(u);
		}
		listUdflugter.setMaxSize(225.0, 200.0);
		pane.add(listUdflugter, 0, 14);

		HBox buttonBox = new HBox(20);
		pane.add(buttonBox, 0, 15);
		buttonBox.setPadding(new Insets(10, 10, 0, 10));
		buttonBox.setAlignment(Pos.BOTTOM_LEFT);

		Button btnOK = new Button("Udført & Videre");
		buttonBox.getChildren().add(btnOK);
		btnOK.setOnAction(event -> this.okAction());

	}

	// -------------------------------------------------------------------------

	private void okAction() {
		// Initialiserer registreringsobjektet
		int index = Controller.getKonferencer().get(0).getRegistreringer().size();
		registrering = Controller.getKonferencer().get(0).getRegistreringer().get(index - 1);

		// Alert hvis der mangler at blive indtastet oplysninger
		if (txfNavn.getText().isEmpty() || txfAdresse.getText().isEmpty() || txfAlder.getText().isEmpty()
				|| txfTlfNr.getText().isEmpty() || (!chkErKvinde.isSelected() && !chkErMand.isSelected())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fejl");
			alert.setHeaderText("Manglende information");
			alert.setContentText("Du mangler at udfylde alle informationer");
			alert.show();
		}

		// Deltager-oprettelse og tilkobling af registrering, deltager og evt ledsager +
		// udflugt
		else {

			// Trækker alle data fra deltager-input
			String navn = txfNavn.getText().trim();
			String adresse = txfAdresse.getText().trim();
			String tlfNr = txfTlfNr.getText().trim();
			boolean erMand = this.getErMand();
			boolean erForedragsholder = chkErForedragsholder.isSelected();
			int alder = Integer.parseInt(txfAlder.getText().trim());

			// Creater deltager og tilføjer til registrering
			deltager = Controller.createDeltager(navn, adresse, alder, tlfNr, erMand, erForedragsholder);
			Controller.addDeltagerToRegistrering(registrering, deltager);

			// Creater ledsager og tilføjer til deltager, hvis ledsager er udfyldt
			if (!txfLedsager.getText().isEmpty()) {
				Ledsager ledsager = Controller.createLedsager(txfLedsager.getText().trim());
				Controller.addLedsagerToDeltager(ledsager, deltager);

				// Tilføjer udflugter til registrering
				ObservableList<Udflugt> selectedUdflugter = listUdflugter.getSelectionModel().getSelectedItems();
				for (Udflugt u : selectedUdflugter) {
					Controller.addUdflugtToRegistrering(registrering, u);
				}
			}
			// Viser næste vindue
			hotelInputWindow.showAndWait();
		}
	}

	public Deltager getActualDeltager() {
		return this.deltager;
	}

	public boolean getErMand() {
		boolean erMand = false;
		if (chkErMand.isSelected()) {
			erMand = true;
		} else if (chkErKvinde.isSelected()) {
			erMand = false;
		}
		return erMand;
	}

}
