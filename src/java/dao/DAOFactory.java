package dao;

/**
 *
 * @author stag
 */
public class DAOFactory {

    public static UserDAO getUserDAO() {
        return new UserDAO();
    }

    public static ArticleDAO getArticleDAO() {
        return new ArticleDAO();
    }
}
