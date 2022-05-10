package dao;

import bean.Participant;
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
public class ParticipantDAO extends DAO<Participant> {

    public ParticipantDAO() {
        table = "participant";
    }

    @Override
    public Participant find(Long id) {
        Participant participant = null;

        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                participant = new Participant();
                participant.setID(id);
                participant.setNom(rs.getString("Nom"));
                participant.setPrenom(rs.getString("Prenom"));
                participant.setTel(rs.getLong("tel"));
                participant.setEntree(rs.getString("Entrée"));
                participant.setPlats(rs.getString("Plat"));
                participant.setDessert(rs.getString("Dessert"));
                participant.setBoisson(rs.getString("Boisson"));
                participant.setNbrParticipant(rs.getInt("nbrParticipant"));
                participant.setRemarque(rs.getString("Remarque"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participant;
    }

    @Override
    public void update(Participant obj) {
        String sql = "UPDATE " + table
                + " SET nom=?, prenom=?, tel=?, entree=?, plats=?, dessert=?"
                + "boisson=?, nbrParticipant=?, remarque=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getNom());
            pstmt.setString(2, obj.getPrenom());
            pstmt.setLong(3, obj.getTel());
            pstmt.setString(4, obj.getEntree());
            pstmt.setString(5, obj.getPlats());
            pstmt.setString(6, obj.getDessert());
            pstmt.setString(7, obj.getBoisson());
            pstmt.setInt(8, obj.getNbrParticipant());
            pstmt.setString(9, obj.getRemarque());
            pstmt.setLong(10, obj.getID());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Participant obj) {
        String sql = "INSERT INTO " + table
                + " (nom, prenom, tel, entree, plats, dessert, boisson, nbrParticipant, remarque) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getNom());
            pstmt.setString(2, obj.getPrenom());
            pstmt.setLong(3, obj.getTel());
            pstmt.setString(4, obj.getEntree());
            pstmt.setString(5, obj.getPlats());
            pstmt.setString(6, obj.getDessert());
            pstmt.setString(7, obj.getBoisson());
            pstmt.setInt(8, obj.getNbrParticipant());
            pstmt.setString(9, obj.getRemarque());

            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setID(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Participant> all() {
        ArrayList<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // Pour chaque ligne de résultat
                // On crée un utilisateur
                Participant participant = new Participant();
                participant.setID(rs.getLong("ID"));
                participant.setNom(rs.getString("Nom"));
                participant.setPrenom(rs.getString("Prenom"));
                participant.setTel(rs.getLong("tel"));
                participant.setEntree(rs.getString("Entrée"));
                participant.setPlats(rs.getString("Plat"));
                participant.setDessert(rs.getString("Dessert"));
                participant.setBoisson(rs.getString("Boisson"));
                participant.setNbrParticipant(rs.getInt("nbrParticipant"));
                participant.setRemarque(rs.getString("Remarque"));
                // On l'ajoute à la liste
                participants.add(participant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participants;
    }

}
