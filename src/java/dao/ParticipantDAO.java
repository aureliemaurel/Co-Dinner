package dao;

import bean.Participant;
import java.util.List;

/**
 *
 * @author stag
 */
public class ParticipantDAO extends DAO<Participant> {
    
    public ParticipantDAO(){
        table = "participant";
    }

    @Override
    public Participant find(Long id) {
        Participant participant= null;
        return participant;
    }

    @Override
    public void update(Participant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Participant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participant> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
