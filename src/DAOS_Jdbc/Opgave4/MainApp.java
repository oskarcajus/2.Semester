package DAOS_Jdbc.Opgave4;

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
			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-19ADO3U\\SQLExpress;databaseName=Lektion3_Tidsregistrering;user=sa;password=Blobber1;");

			String sql = "EXEC medarbejdernavn_medarbejdertlfnr;";
			Statement stmt = minConnection.createStatement();

			
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				System.out.println(res.getString(1) + "\t" + res.getString(2));
			}

			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
