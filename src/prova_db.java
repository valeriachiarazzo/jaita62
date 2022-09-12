
// Java program to insert records to a table using JDBC
import java.sql.*;
public class prova_db {
    public static void main (String args[]) {
        try {
// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
// Creiamo la stringa di connessione
            String url = "jdbc:mysql://localhost:3306/rubrica";
// Creiamo un oggetto Statement per poter interrogare il db
            try (// Otteniamo una connessione con username e password
                 Connection con = DriverManager.getConnection (url, "root", ""); // Creiamo un oggetto Statement per poter interrogare il db
                 Statement cmd = con.createStatement ()) {
                // Eseguiamo una query e immagazziniamone i risultati
                // in un oggetto ResultSet
                String qry = "SELECT * FROM anagrafica_clienti";

// Stampiamone i risultati riga per riga
                try (ResultSet res = cmd.executeQuery(qry)) {
                    // Stampiamone i risultati riga per riga
                    while (res.next()) {
                        System.out.println(res.getString("id_anagrafica"));
                        System.out.println(res.getString("ragione_sociale"));
                        System.out.println(res.getString("indirizzo"));
                        System.out.println(res.getString("cap"));
                        System.out.println(res.getString("localita"));
                        System.out.println(res.getString("provincia"));
                    }   }
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }
}