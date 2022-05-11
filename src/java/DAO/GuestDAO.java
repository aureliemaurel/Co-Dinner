package DAO;

import Beans.Guest;
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
public class GuestDAO  extends DAO<Guest>{
    public GuestDAO() {
        super("guest");
    }

    @Override
    public Guest find(Long id) {
        Guest user = null;
        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                user = new Guest();
                user.setName(rs.getString("name"));
                user.setFirst_name(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                user.setPseudo(rs.getString("pseudo"));
                user.setPwd(rs.getString("pwd"));
                user.setTel(rs.getString("tel"));
                user.setId_guest(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public Guest find(String email) {
        Guest user = null;
        String sql = "SELECT * FROM " + table + " WHERE email=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                user = new Guest();
                user.setEmail(email);
                user.setName(rs.getString("name"));
                user.setFirst_name(rs.getString("first_name"));
                user.setPseudo(rs.getString("pseudo"));
                user.setPwd(rs.getString("pwd"));
                user.setTel(rs.getString("tel"));
                user.setId_guest(rs.getLong("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void create(Guest obj) {
        String sql = "INSERT INTO " + table + " (name, first_name, email, pwd, pseudo, tel)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getFirst_name());
            pstmt.setString(3, obj.getEmail());
            pstmt.setString(4, obj.getPwd());
            pstmt.setString(5, obj.getPseudo());
            pstmt.setString(6, obj.getTel());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId_guest(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Guest obj) {
        String sql = "UPDATE " + table + " SET name=?, first_name=?, email=?,"
                + " pwd=?, tel=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getFirst_name());
            pstmt.setLong(7, obj.getId_guest());
            pstmt.setString(4, obj.getPwd());
            pstmt.setString(3, obj.getEmail());
            pstmt.setString(5, obj.getPseudo());
            pstmt.setString(6, obj.getTel());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Guest> all() {
        ArrayList<Guest> users = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // Pour chaque ligne de résultat
                // On crée un utilisateur
                Guest user = new Guest();
                user.setId_guest(rs.getLong("id_guest"));
                user.setName(rs.getString("name"));
                user.setFirst_name(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setPseudo(rs.getString("pseudo"));
                user.setTel(rs.getString("tel"));
                // On l'ajoute à la liste
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    

}
