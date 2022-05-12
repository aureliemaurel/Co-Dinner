package DAO;

import Beans.Event;
import Beans.Food;
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
 * @author Aurélie
 */
public class FoodDAO extends DAO<Food> {

    /**
     *
     */
    public FoodDAO() {
        super("food");
    }

    @Override
    public Food find(Long id) {
        Food food = null;
        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(3, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                food = new Food();
                food.setNbparticipant(rs.getLong("nbparticipant"));
                food.setEntree(rs.getString("entree"));
                food.setNb_entree(rs.getInt("nb_entree"));
                food.setPlat(rs.getString("plat"));
                food.setNb_plat(rs.getLong("nb_plat"));
                food.setDessert(rs.getString("dessert"));
                food.setNb_dessert(rs.getLong("nb_dessert"));
                food.setBoisson(rs.getString("boisson"));
                food.setNb_boisson(rs.getLong("nb_boisson"));
                food.setRemarque(rs.getString("remarque"));
                food.setId_food(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return food;
    }

    @Override
    public void update(Food obj) {
        String sql = "UPDATE " + table + " SET entree=?, nb_entree=?, plat=?, nb_plat=?"
                + " dessert=?, nb_dessert=?, boisson=?, nb_boisson=?, nbparticipant=?, remarque=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getEntree());
            pstmt.setLong(2, obj.getNb_entree());
            pstmt.setString(3, obj.getPlat());
            pstmt.setLong(4, obj.getNb_plat());
            pstmt.setString(5, obj.getDessert());
            pstmt.setLong(6, obj.getNb_dessert());
            pstmt.setString(7, obj.getBoisson());
            pstmt.setLong(8, obj.getNb_boisson());
            pstmt.setLong(9, obj.getNbparticipant());
            pstmt.setString(10, obj.getRemarque());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Food obj) {
        String sql = "INSERT INTO " + table + " (entree, plat, nb_plat, dessert"
                + " nb_dessert, boisson, nb_boisson, nbparticipant, remarque)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEntree());
            pstmt.setLong(2, obj.getNb_entree());
            pstmt.setString(3, obj.getPlat());
            pstmt.setLong(4, obj.getNb_plat());
            pstmt.setString(5, obj.getDessert());
            pstmt.setLong(6, obj.getNb_dessert());
            pstmt.setString(7, obj.getBoisson());
            pstmt.setLong(8, obj.getNb_boisson());
            pstmt.setLong(9, obj.getNbparticipant());
            pstmt.setString(10, obj.getRemarque());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId_food(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Food> all() {
        ArrayList<Food> foods = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // Pour chaque ligne de résultat
                // On crée un objet Food
                Food food = new Food();
                food.setId_food(rs.getLong("id_food"));
                food.setEntree(rs.getString("entree"));
                food.setNb_entree(rs.getInt("nb_entree"));
                food.setPlat(rs.getString("plat"));
                food.setNb_plat(rs.getLong("nb_plat"));
                food.setDessert(rs.getString("dessert"));
                food.setNb_dessert(rs.getLong("nb_dessert"));
                food.setBoisson(rs.getString("boisson"));
                food.setNb_boisson(rs.getLong("nb_boisson"));
                food.setNbparticipant(rs.getLong("nbparticipant"));
                food.setRemarque(rs.getString("remarque"));
                // On l'ajoute à la liste
                foods.add(food);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foods;
    }

}
