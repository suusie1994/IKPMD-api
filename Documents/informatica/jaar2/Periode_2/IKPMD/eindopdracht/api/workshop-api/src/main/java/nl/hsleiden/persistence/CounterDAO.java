package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import nl.hsleiden.model.Counter;

@Singleton
public class CounterDAO extends AbstractDAO<Counter> {
 @Inject
 public CounterDAO(SessionFactory sessionFactory){
     super(sessionFactory);
 }
 public Counter findById(int id) {
     return get(id);
 }
 public List<Counter> findAll(){
        return (List<Counter>) query("select c from Counter c").list();
    }
    
    public Counter save(Counter counter){
        return persist(counter);
    }
    public void delete(Counter counter) {
        currentSession().delete(counter);
    }
}
