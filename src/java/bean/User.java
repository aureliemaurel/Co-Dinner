package bean;

/**
 *
 * @author stag
 */
public class User {
    
    private Long id;
    private String email;
    private String pseudo;
    private String pwd;

    public User() {
    }
    
    

    public User(Long id, String email, String pseudo, String pwd) {
        this.id = id;
        this.email = email;
        this.pseudo = pseudo;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", pseudo=").append(pseudo);
        sb.append(", pwd=").append(pwd);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
