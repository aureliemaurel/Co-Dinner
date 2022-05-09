package dao;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author stag
 */
public class UserDAO extends DAO<User> {

    public UserDAO() {
        table = "guest";
    }

    @Override
    public User find(Long id) {
        User user = null;
        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setPseudo(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User find(String email) {
        User user = null;
        String sql = "SELECT * FROM " + table + " WHERE email=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                user = new User();
                user.setEmail(email);
                user.setPseudo(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setId(rs.getLong("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void create(User obj) {
        String sql = "INSERT INTO " + table + " (email, pwd, name) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getPwd());
            pstmt.setString(3, obj.getPseudo());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User obj) {
        String sql = "UPDATE " + table + " SET email=?, pwd=?, name=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(4, obj.getId());
            pstmt.setString(2, obj.getPwd());
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(3, obj.getPseudo());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> all() {
        ArrayList<User> users;
        users = new ArrayList<>();
        String sql = "SELECT * FROM guest";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id")); 
            user.setEmail(rs.getString("email")); 
            user.setPseudo(rs.getString("name")); 
            user.setPwd(rs.getString("pwd")); 
            users.add(user);
        }
        }catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return users;
    }
   
}


    