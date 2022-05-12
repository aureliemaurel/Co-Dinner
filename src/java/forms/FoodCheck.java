package forms;


import Beans.Food;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stag
 */
public class FoodCheck extends FormChecker<Food>  {

    public FoodCheck(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Food check() {
         Map<String, String> msgMap = new HashMap<>();
         
         String entree = request.getParameter("entree");
         String plat = request.getParameter("plat");
         String dessert = request.getParameter("dessert");
         String boisson = request.getParameter("boisson");
         String remarque = request.getParameter("remarque");
         
//         String  nb_entree = request.getParameter("nb_entree");
//         String  nb_plat = request.getParameter("nb_plat");
//         String  nb_dessert = request.getParameter("nb_dessert");
//         String  nb_boisson = request.getParameter("nb_boisson");
//         String  nbparticipant = request.getParameter("nbparticipant");
         
         Food food = new Food();
         
         food.setEntree(entree);
         food.setPlat(plat);
         food.setDessert(dessert);
         food.setBoisson(boisson);
         food.setRemarque(remarque);
         
//         food.setNb_entree(nb_entree);
//         food.setNb_plat(nb_plat);
//         food.setNb_dessert(nb_dessert);
//         food.setNb_boisson(nb_boisson);
//         food.setNbparticipant(nbparticipant);
         
         request.setAttribute("food", food);
         
         try {
            mandatoryField(entree);
            
        } catch (Exception ex) {
            errors.put("entree", ex.getMessage());
        }
         try {
            mandatoryField(plat);
            
        } catch (Exception ex) {
            errors.put("plat", ex.getMessage());
        }
         try {
            mandatoryField(dessert);
            
        } catch (Exception ex) {
            errors.put("dessert", ex.getMessage());
        }
         try {
            mandatoryField(boisson);
            
        } catch (Exception ex) {
            errors.put("boisson", ex.getMessage());
        }
         try {
            mandatoryField(remarque);
            
        } catch (Exception ex) {
            errors.put("remarque", ex.getMessage());
        }
//         try {
//            mandatoryField(nb_entree);
//            
//        } catch (Exception ex) {
//            errors.put("nb_entree", ex.getMessage());
//        }
//         try {
//            mandatoryField(nb_plat);
//            
//        } catch (Exception ex) {
//            errors.put("nb_plat", ex.getMessage());
//        }
//         try {
//            mandatoryField(nb_dessert);
//            
//        } catch (Exception ex) {
//            errors.put("nb_dessert", ex.getMessage());
//        }
//         try {
//            mandatoryField(nb_boisson);
//            
//        } catch (Exception ex) {
//            errors.put("nb_boisson", ex.getMessage());
//        }
//         try {
//            mandatoryField(nbparticipant);
//            
//        } catch (Exception ex) {
//            errors.put("nbparticipant", ex.getMessage());
//        }
         request.setAttribute("errors", errors);
        if (errors.isEmpty()) {
            request.setAttribute("foodMessage", "Voici votre liste de food " );
        } else {
            request.setAttribute("foodMessage", "Votre formulaire comporte des erreurs");
        }
        return food;
   }
}
