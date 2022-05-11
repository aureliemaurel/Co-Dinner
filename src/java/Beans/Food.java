package Beans;

import DAO.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class Food implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;

    private Long id_food;
    private Long nb_entree;
    private Long nb_plat;
    private Long nb_dessert;
    private Long nb_boisson;
    private Long nbparticipant;
    private String entree;
    private String plat;
    private String dessert;
    private String boisson;
    private String remarque;
    
    

    @Override
    public Long getId() {
        return id_food;
    }

    public Long getId_food() {
        return id_food;
    }

    public void setId_food(Long id_food) {
        this.id_food = id_food;
    }

    public Long getNb_entree() {
        return nb_entree;
    }

    public void setNb_entree(Long nb_entree) {
        this.nb_entree = nb_entree;
    }

    public Long getNb_plat() {
        return nb_plat;
    }

    public void setNb_plat(Long nb_plat) {
        this.nb_plat = nb_plat;
    }

    public Long getNb_dessert() {
        return nb_dessert;
    }

    public void setNb_dessert(Long nb_dessert) {
        this.nb_dessert = nb_dessert;
    }

    public Long getNb_boisson() {
        return nb_boisson;
    }

    public void setNb_boisson(Long nb_boisson) {
        this.nb_boisson = nb_boisson;
    }

    public Long getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(Long nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Food{id_food=").append(id_food);
        sb.append(", nb_entree=").append(nb_entree);
        sb.append(", nb_plat=").append(nb_plat);
        sb.append(", nb_dessert=").append(nb_dessert);
        sb.append(", nb_boisson=").append(nb_boisson);
        sb.append(", nbparticipant=").append(nbparticipant);
        sb.append(", entree=").append(entree);
        sb.append(", plat=").append(plat);
        sb.append(", dessert=").append(dessert);
        sb.append(", boisson=").append(boisson);
        sb.append(", remarque=").append(remarque);
        sb.append('}');
        return sb.toString();
    }
    
    

}
