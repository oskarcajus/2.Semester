package DAOS_Jdbc.Opgave2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

	public static void main(String[] args) {
		try {
			Connection minConnection;
			minConnection = 
					DriverManager.getConnection("jdbc:sqlserver://DESKTOP-19ADO3U\\SQLExpress;databaseName=Lektion3_Tidsregistrering;user=sa;password=Blobber1;");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select navn, mobil from Medarbejder");
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2));
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}

	}

}
