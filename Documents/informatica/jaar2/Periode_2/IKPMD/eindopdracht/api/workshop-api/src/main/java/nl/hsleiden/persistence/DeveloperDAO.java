package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import nl.hsleiden.model.Developer;

@Singleton
public class DeveloperDAO extends AbstractDAO<Developer>{
    @Inject
    public DeveloperDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }
    public Developer findById(int id){
        return get(id);
    }
    public List<Developer> findAll(){
        return (List<Developer>) query("select d from Developer d").list();
    }
    
    public Developer save(Developer developer){
        return persist(developer);
    }
    public void delete(Developer developer) {
        currentSession().delete(developer);
    }
}
