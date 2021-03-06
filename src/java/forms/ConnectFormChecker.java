package forms;

import Beans.Event;
import DAO.DAOFactory;
import DAO.GuestDAO;
import forms.FormChecker;
import Beans.Guest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ConnectFormChecker extends FormChecker<Guest> {

    Map<String, String> msgMap = new HashMap<>();

    private final int MIN_PWD_SIZE = 3;
    private final int MAX_PWD_SIZE = 24;

    public ConnectFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Guest check() {

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        //création d'un nouvel utilisateur
        Guest user = new Guest();
        user.setEmail(email); // on récupère le mail et le password
        user.setPwd(pwd);

        request.setAttribute("user", user);

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

        //rajout de vértification entre le mot de passe de la BD et le mot de passe saisi par l'utilisateur
        if (errors.isEmpty()) {
            String message;
            Guest fromDb = DAOFactory.getGuestDAO().find(user.getEmail());
            if (fromDb == null || !fromDb.getPwd().equals(user.getPwd())) {
                msgMap.put("error", "Identifiant ou mot de passe incorrect");
                request.getSession().invalidate();
            } else {
                user = fromDb;
                request.getSession().setAttribute("user", user);
                msgMap.put("valid", "Vous êtes maintenant connecté.");
            }
        } else {
            msgMap.put("error", "Votre formulaire comporte des erreurs");
        }

        request.setAttribute("connectMessage", msgMap);
        return user;

    }

}
