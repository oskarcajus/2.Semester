package DAOS_Jdbc.Opgave1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {

	public static void main(String[] args) {
		try {
			Connection minConnection;
			minConnection = 
					DriverManager.getConnection("jdbc:sqlserver://DESKTOP-19ADO3U\\SQLExpress;databaseName=Lektion3_Tidsregistrering;user=sa;password=Blobber1;");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select * rom Medarbejder");
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2) + " \t "  +res.getString(3) + " \t "  +res.getString(4) );
			}

			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();
		} 
//		catch (SQLException sqlE) {
//			System.out.println("fejl: " + sqlE.getMessage() + sqlE.getErrorCode());
//		}
		
		catch (Exception e) {
			System.out.println("fejl:  " + ((SQLException) e).getMessage());
		}

	}

}
