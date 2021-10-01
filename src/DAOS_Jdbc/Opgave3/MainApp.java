package DAOS_Jdbc.Opgave3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

	public static void main(String[] args) {
		try {
			System.out.println("Find telefonnr på medarbejder ");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Indtast navn: ");
			String inputNavn = inLine.readLine();

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-19ADO3U\\SQLExpress;databaseName=Lektion3_Tidsregistrering;user=sa;password=Blobber1;");

			String sql = "select Medarbejder.mobil from Medarbejder where ? = Medarbejder.navn"; // preparedStatement
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setString(1, inputNavn);
			
			ResultSet res = prestmt.executeQuery();
			
			while (res.next()) {
				System.out.println(res.getString(1));
			}

			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
