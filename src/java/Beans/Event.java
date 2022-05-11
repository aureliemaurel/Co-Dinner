package Beans;

import DAO.Identifiable;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author stag
 */
public class Event implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;

    private Long id_event;
    private String titre;
    private String lieu;
    private Date date_event;

    @Override
    public Long getId() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event{id_event=").append(id_event);
        sb.append(", titre=").append(titre);
        sb.append(", lieu=").append(lieu);
        sb.append(", date_event=").append(date_event);
        sb.append('}');
        return sb.toString();
    }

    public void setDate_event(String date_event) {
//        int j = Integer.parseInt(date_event.substring(0, 2));
//        int m = Integer.parseInt((date_event.substring(3, 5)));
//        int a = Integer.parseInt(date_event.substring(6, 10));
//        setDate_event(new Date(a, m, j));
        setDate_event(Date.valueOf(date_event));
    }
    

}
