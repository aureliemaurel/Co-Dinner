package bean;

import dao.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class Participant  implements Serializable, Identifiable{
    
    private static final long serialVersionUID = 1L;
    
    private Long ID;
    private String nom;
    private String prenom;
    private Long tel;
    private String entree;
    private String plats;
    private String dessert;
    private String boisson;
    private int nbrParticipant;
    private String remarque;

    public Participant() {
    }

    public Participant(Long ID, String nom, String prenom, Long tel, String entree, String plats, String dessert, String boisson, int nbrParticipant, String remarque) {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.entree = entree;
        this.plats = plats;
        this.dessert = dessert;
        this.boisson = boisson;
        this.nbrParticipant = nbrParticipant;
        this.remarque = remarque;
    }
    
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getPlats() {
        return plats;
    }

    public void setPlats(String plats) {
        this.plats = plats;
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

    public int getNbrParticipant() {
        return nbrParticipant;
    }

    public void setNbrParticipant(int nbrParticipant) {
        this.nbrParticipant = nbrParticipant;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Participant{nom=").append(nom);
        sb.append(", prenom=").append(prenom);
        sb.append(", tel=").append(tel);
        sb.append(", entree=").append(entree);
        sb.append(", plats=").append(plats);
        sb.append(", dessert=").append(dessert);
        sb.append(", boisson=").append(boisson);
        sb.append(", nbrParticipant=").append(nbrParticipant);
        sb.append(", remarque=").append(remarque);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    

}
