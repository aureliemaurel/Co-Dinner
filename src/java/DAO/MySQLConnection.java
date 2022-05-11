package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Etablissemant d'une connexion de la DB selon le pattern Singleton
 * @author stag
 */
public final class MySQLConnection {
    
    //Variables dont nous aurons besoin pour établir la connexion avec la base de données
    private static Connection connection = null;
    
    //constructeur sans paramètre
    private MySQLConnection() {
    }
    
    // fonction qui permet de récupérer les données dans la base de données en automatisant la connection 
    public static Connection getConnection() throws RuntimeException{
       
        if (connection == null) {
             //variable locale à la fonction getConnection() qui permet de récupérer la conncetion à la base de donnée
        String login = "groupe04";
        String password = "P7O/WOBPVoKTY";
        String host = "wp.ldnr.fr";
        String database = "groupe04";
        int port = 3306;
        String driver = "mysql";
        
// version produite : jdbc:mysql://localhost:3306/Blog
        String url = "jdbc:" + driver + "://" + host + ":" + port + "/" + database;
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                throw new RuntimeException("Connexion à la base de données impossible");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("Driver " + driver + " inconnu.");
            }
        }   
        return connection;
    }
}
