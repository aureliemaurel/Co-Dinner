package forms;

import forms.FormChecker;
import fr.ldnr.beans.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Herbert Caffarel
 */
public class RegisterFormChecker extends FormChecker {

    //constructeur avec paramètre de la requête
    public RegisterFormChecker(HttpServletRequest request) {
        super(request);  //appelle le constructeur de la classe mère qui a en param la requête  
    }
    
    //fonction check() pour vérifier les champs saisis sont valides
    @Override
    public User check() {
        
        //Variables qui permettent de récupérer les paramètres saisi par l'utilsateur dans l'objet requête qui contient les paramètres "email, "password" "confirm" et "pseudo"
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String confirm = request.getParameter("confirm");
        String pseudo = request.getParameter("pseudo");
        
        // crétaion d'un nouvel obbjet user (classe user qui est un bean (modèle objet utilisateur)
        User user = new User();
        
        user.setEmail(email); 
        user.setPseudo(pseudo);
        user.setPwd(pwd);
        request.setAttribute("user", user);
        
        // try catch pour envoyer message d'errreur si les champs ne sont pas valides
        try {
            mandatoryField(email);
            isEmail(email);
        } catch (Exception ex) {
            errors.put("email", ex.getMessage());
        }
        try {
            mandatoryField(pwd);
            minFieldLength(pwd, 3);
            maxFieldLength(pwd, 24);
        } catch (Exception ex) {
            errors.put("pwd", ex.getMessage());
        }
        try {
            mandatoryField(confirm);
            sameField(pwd, confirm);
        } catch (Exception ex) {
            errors.put("confirm", ex.getMessage());
        }
        try {
            if (pseudo.trim().length() != 0) {
                minFieldLength(pseudo, 3);
            }
        } catch (Exception ex) {
            errors.put("pseudo", ex.getMessage());
        }
        request.setAttribute("errors", errors);
        if (errors.isEmpty()) {
            request.setAttribute("registerMessage", "Bienvenue " + request.getParameter("pseudo") + ".\nVotre inscription a été acceptée, vous pouvez maintenant vous connecter.");
        } else {
            request.setAttribute("registerMessage", "Votre formulaire comporte des erreurs");
        }
        return user;
    }

        // fonction pour vérifier que le mot de passe et le confirm sont les mêmes sinon message d'erreur
    private void sameField(String one, String two) throws Exception {
        if (!one.strip().equals(two.strip())) {
            throw new Exception("Mot de passe et confirmation ne sont pas identiques.");
        }
    }
}
