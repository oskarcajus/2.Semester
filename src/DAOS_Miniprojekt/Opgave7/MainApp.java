//Laura, Alexander, Emilio, Oskar

package DAOS_Miniprojekt.Opgave7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		try {
			System.out.println("Indsæt et eksamensforsøg");
			BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Indtast karakter: ");
			int inputKarakter = Integer.parseInt(inLine.readLine());
			System.out.println("Indtast cprNr: ");
			String inputCpr = inLine.readLine();
			System.out.println("Indtast eksamensID: ");
			int eksamensID = Integer.parseInt(inLine.readLine());

			Connection minConnection;
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-19ADO3U\\SQLExpress;databaseName=EAAA_DB;user=sa;password=Blobber1;");

			String sql = "insert into Eksamensforsøg values (?, ?, ?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();

			prestmt.setInt(1, inputKarakter);
			prestmt.setString(2, inputCpr);
			prestmt.setInt(3, eksamensID);
			
			prestmt.executeUpdate();
			
			
			
			if (prestmt != null)
				prestmt.close();
			if (minConnection != null)
				minConnection.close();
		
		} catch (SQLException SQLe) {
			System.out.println("fejl:  " + SQLe.getMessage());
			System.out.println("fejlkode: " + SQLe.getErrorCode());
		} 

		 catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	

	}

}
