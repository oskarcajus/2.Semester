package KAS.gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;

public class SamletPrisWindow extends Stage {
	
	public SamletPrisWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(true);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------
	private TextField txfPrisKonference;
	private TextField txfRabatForedragsholder;
	private TextField txfPrisUdflugt;
	private TextField txfPrisHotel;
	private TextField txfPrisFacilitet;
	private TextField txfSamletPris;

	private Separator separator;

	private Registrering registrering = null;

	private void initContent(GridPane pane) {
		
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblPrisKonference = new Label("Konference: ");
		pane.add(lblPrisKonference, 0, 0);
		txfPrisKonference = new TextField();
		txfPrisKonference.setEditable(false);
		pane.add(txfPrisKonference, 0, 1);

		Label lblRabatForedragsholder = new Label("Foredragsholderrabat: ");
		pane.add(lblRabatForedragsholder, 0, 2);
		txfRabatForedragsholder = new TextField();
		txfRabatForedragsholder.setEditable(false);
		pane.add(txfRabatForedragsholder, 0, 3);

		Label lblPrisUdflugt = new Label("Udflugt: ");
		pane.add(lblPrisUdflugt, 0, 4);
		txfPrisUdflugt = new TextField();
		txfPrisUdflugt.setEditable(false);
		pane.add(txfPrisUdflugt, 0, 5);

		Label lblPrisHotel = new Label("Hotel: ");
		pane.add(lblPrisHotel, 0, 6);
		txfPrisHotel = new TextField();
		txfPrisHotel.setEditable(false);
		pane.add(txfPrisHotel, 0, 7);

		Label lblPrisFacilitet = new Label("Facilitet: ");
		pane.add(lblPrisFacilitet, 0, 8);
		txfPrisFacilitet = new TextField();
		txfPrisFacilitet.setEditable(false);
		pane.add(txfPrisFacilitet, 0, 9);
		
		separator = new Separator();
		pane.add(separator, 0, 10, 8, 1);

		Label lblSamletPris = new Label("Samletpris: ");
		pane.add(lblSamletPris, 0, 11);
		txfSamletPris = new TextField();
		pane.add(txfSamletPris, 0, 12);


		HBox buttonBox = new HBox(20);
		pane.add(buttonBox, 0, 15);
		buttonBox.setPadding(new Insets(10, 10, 0, 10));
		buttonBox.setAlignment(Pos.BOTTOM_LEFT);

		Button btnOK = new Button("Udført");
		buttonBox.getChildren().add(btnOK);
		btnOK.setOnAction(event -> this.okAction());
		
	}

	// -------------------------------------------------------------------------
	
		

	private void okAction() {
		//Clear og luk alle vinduer og start forfra.
		}
		
	public void visPriser() {
		registrering = Controller.getKonferencer().get(0).getRegistreringer().get(0);
		txfPrisKonference.setText("" + (registrering.getPrisKonference() + registrering.getRabatForedragsholder()));
		txfRabatForedragsholder.setText("" + ( -1 * registrering.getRabatForedragsholder()));
		txfPrisUdflugt.setText("" + registrering.getPrisUdflugt());
		txfPrisHotel.setText("" + registrering.getPrisHotel());
		txfPrisFacilitet.setText("" + registrering.getPrisFacilitet());
		txfSamletPris.setText("" + registrering.samletPris());
		
	}

}
