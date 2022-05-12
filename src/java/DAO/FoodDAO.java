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
                food.setEntree(rs.getString("entree"));
                food.setPlat(rs.getString("plat"));
                food.setDessert(rs.getString("dessert"));
                food.setBoisson(rs.getString("boisson"));
                food.setRemarque(rs.getString("remarque"));
                
//                food.setNbparticipant(rs.getLong("nbparticipant"));
//                food.setNb_entree(rs.getInt("nb_entree"));
//                food.setNb_plat(rs.getLong("nb_plat"));
//                food.setNb_dessert(rs.getLong("nb_dessert"));
//                food.setNb_boisson(rs.getLong("nb_boisson"));
                
                food.setId_food(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return food;
    }

    @Override
    public void update(Food obj) {
        String sql = "UPDATE " + table + " SET entree=?,  plat=?, dessert=?,  boisson=?,   remarque=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getEntree());
            pstmt.setString(2, obj.getPlat());
            pstmt.setString(3, obj.getDessert());
            pstmt.setString(4, obj.getBoisson());
            pstmt.setString(5, obj.getRemarque());
            
//            pstmt.setLong(2, obj.getNb_entree());
//            pstmt.setLong(4, obj.getNb_plat());
//            pstmt.setLong(6, obj.getNb_dessert());
//            pstmt.setLong(8, obj.getNb_boisson());
//            pstmt.setLong(9, obj.getNbparticipant());
            
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Food obj) {
        String sql = "INSERT INTO " + table + " (entree, plat, dessert,  boisson, remarque) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEntree());
            pstmt.setString(2, obj.getPlat());
            pstmt.setString(3, obj.getDessert());
            pstmt.setString(4, obj.getBoisson());
            pstmt.setString(5, obj.getRemarque());
            
//             pstmt.setLong(2, obj.getNb_entree());
//            pstmt.setLong(3, obj.getNb_plat());
//            pstmt.setLong(5, obj.getNb_dessert());
//            pstmt.setLong(7, obj.getNb_boisson());
//            pstmt.setLong(8, obj.getNbparticipant());
            
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
                food.setPlat(rs.getString("plat"));
                food.setDessert(rs.getString("dessert"));
                food.setBoisson(rs.getString("boisson"));
                food.setRemarque(rs.getString("remarque"));
                
//                food.setNb_entree(rs.getInt("nb_entree"));
//                food.setNb_plat(rs.getLong("nb_plat"));
//                food.setNb_dessert(rs.getLong("nb_dessert"));
//                food.setNb_boisson(rs.getLong("nb_boisson"));
//                food.setNbparticipant(rs.getLong("nbparticipant"));

                // On l'ajoute à la liste
                foods.add(food);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foods;
    }

}
