package dao;

/**
 *
 * @author stag
 */
public class DAOFactory {

    public static UserDAO getUserDAO() {
        return new UserDAO();
    }

    public static ParticipantDAO getArticleDAO() {
        return new ParticipantDAO();
    }
}