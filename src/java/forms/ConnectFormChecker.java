package forms;

import dao.DAOFactory;
import dao.UserDAO;
import forms.FormChecker;
import bean.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


 
public class ConnectFormChecker extends FormChecker {
    
    private final int MIN_PWD_SIZE = 3; //création de variables globales
    private final int MAX_PWD_SIZE = 24;


    public ConnectFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public User check() {
        
        //Variables 
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        //création d'un nouvel utilisateur
        User user = new User();
        user.setEmail(email); // on récupère le mail et le password
        user.setPwd(pwd);
        
        request.setAttribute("user", user);//
        
        try {
            mandatoryField(email); // vérif du mail
            isEmail(email);
        } catch (Exception ex) {
            errors.put("email", ex.getMessage());
        }
        try {
            mandatoryField(pwd); // verif du password
            minFieldLength(pwd, MIN_PWD_SIZE);
            maxFieldLength(pwd, MAX_PWD_SIZE);
        } catch (Exception ex) {
            errors.put("pwd", ex.getMessage());
        }
        request.setAttribute("errors", errors);
        
        //rajout de vértification entre le mot de passe de la BBD et le mot de passe saisi par l'utilisateur
        if (errors.isEmpty()) {
            String message = "";
            User fromDb = DAOFactory.getUserDAO().find(user.getEmail());
            if (fromDb == null) {
                message = "Utilisateur inconnu";
                request.getSession().invalidate();
            } else if (!fromDb.getPwd().equals(user.getPwd())) {
                message = "Couple utilisateur/mot de passe inconnu";
                request.getSession().invalidate();
            } else {
                user = fromDb;
                request.getSession().setAttribute("user", user);
                message = "Vous êtes maintenant connecté.";
            }
            request.setAttribute("connectMessage", message);
        } else {
            request.setAttribute("connectMessage", "Votre formulaire comporte des erreurs");
        }
        return user;
    }

}
