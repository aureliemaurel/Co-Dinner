package Beans;

import DAO.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class Guest implements Serializable, Identifiable {
    
     private static final long serialVersionUID = 1L;
    
    private Long id_guest;
    private String name;
    private String first_name;
    private String email;
    private String tel;
    private String pwd;
    private String pseudo;
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("guest{id_guest=").append(id_guest);
        sb.append(", name=").append(name);
        sb.append(", first_name=").append(first_name);
        sb.append(", email=").append(email);
        sb.append(", tel=").append(tel);
        sb.append(", pwd=").append(pwd);
        sb.append(", pseudo=").append(pseudo);
        sb.append('}');
        return sb.toString();
    }

    public Long getId_guest() {
        return id_guest;
    }

    public void setId_guest(Long id_guest) {
        this.id_guest = id_guest;
    }

    @Override
    public Long getId() {
        return id_guest;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    

}
