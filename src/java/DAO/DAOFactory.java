package DAO;

/**
 *
 * @author stag
 */
public class DAOFactory {

    public static GuestDAO getGuestDAO() {
        return new GuestDAO();
    }

    public static FoodDAO getFoodDAO() {
        return new FoodDAO();
    }
    
    public static EventDAO getEventDAO(){
        return new EventDAO();
    }
}
