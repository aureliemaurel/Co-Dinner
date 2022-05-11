package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 * @param <T>
 */
public abstract class DAO<T extends Identifiable> {

    Connection connection;
    protected String table;

   public DAO(String table) {
        this.connection = MySQLConnection.getConnection();
        this.table = table;
    }

    /**
     * Retourne l'utilisateur ayant l'identifiant id dans la DB ou null si non
     * trouvé.
     *
     * @param id identifiant de l'utilisateur en DB
     * @return une instance de User ou null
     */
    public abstract T find(Long id);

    /**
     * Supprime l'objet dans la table guest.
     *
     * @param obj
     */
    public void delete(T obj) {
        String sql = "DELETE FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, obj.getId());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Met à jour l'objet en DB
     *
     * @param obj
     */
    public abstract void update(T obj);

    /**
     * Crée l'utilisateur en DB et récupère son identifiant.
     *
     * @param obj
     */
    public abstract void create(T obj);

    /**
     * Retourne le nombre de ligne de la table.
     *
     * @return le nombre de ligne de la table
     */
    public int count() {
        // TODO
        return 0;
    }

    /**
     * Retourne la collection de toutes les lignes de la table.
     *
     * @return
     */
    public abstract List<T> all();
}
