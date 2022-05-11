package forms;

import Beans.Event;
import Beans.Guest;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stag
 */
public class EventFormCheker extends FormChecker<Event> {

    public EventFormCheker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Event check() {
        
        Map<String, String> msgMap = new HashMap<>();
        
        String titre = request.getParameter("titre");
        String lieu = request.getParameter("lieu");
        String date_event = request.getParameter("date_event");
        
        Event event = new Event();
        
        event.setTitre(titre);
        event.setLieu(lieu);
        event.setDate_event(date_event);
        request.setAttribute("event", event);
        
        try {
            mandatoryField(titre);
            
        } catch (Exception ex) {
            errors.put("titre", ex.getMessage());
        }
        
       try {
            mandatoryField(lieu);
           
        } catch (Exception ex) {
            errors.put("lieu", ex.getMessage());
        }
       
       try {
            mandatoryField(date_event);
           
        } catch (Exception ex) {
            errors.put("date_event", ex.getMessage());
        }
       
       request.setAttribute("errors", errors);
        if (errors.isEmpty()) {
            request.setAttribute("eventMessage", "Event " + request.getParameter("titre") + " est bien crée");
        } else {
            request.setAttribute("eventMessage", "Votre formulaire comporte des erreurs");
        }
        
        
        return event;
    }

   

}
