package DAO;

import Beans.Event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class EventDAO extends DAO<Event> {

    public EventDAO() {
        super("event");
    }

    @Override
    public Event find(Long id) {
     Event event = null;
        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                event = new Event();
                event.setTitre(rs.getString("titre"));
                event.setLieu(rs.getString("lieu"));
                event.setDate_event(rs.getDate("date"));
                event.setId_event(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public void update(Event obj) {
        String sql = "UPDATE " + table + " SET titre=?, lieu=?, date_event=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getTitre());
            pstmt.setString(2, obj.getLieu());
            pstmt.setDate(3, obj.getDate_event());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Event obj) {
     String sql = "INSERT INTO " + table + " (titre, lieu, date_event) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getTitre());
            pstmt.setString(2, obj.getLieu());
            pstmt.setDate(3, obj.getDate_event());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId_event(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Event> all() {
        ArrayList<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // Pour chaque ligne de résultat
                // On crée un utilisateur
                Event event = new Event();
                event.setId_event(rs.getLong("id_event"));
                event.setTitre(rs.getString("titre"));
                event.setLieu(rs.getString("lieu"));
                event.setDate_event(rs.getString("date_event"));
                
                // On l'ajoute à la liste
                events.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

}
