package nl.hsleiden.service;

import nl.hsleiden.model.Counter;
import nl.hsleiden.persistence.CounterDAO;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CounterService {
    private final CounterDAO dao;
    @Inject
    public CounterService(CounterDAO dao){
        this.dao = dao;
    }
    public Counter create(Counter counter) {
        return dao.save(counter);
    }
    
    public Counter getById(int id) {
        return dao.findById(id);
    }
    
    public Counter[] getAll(){
        return dao.findAll().toArray(new Counter[0]);
    }
    
    public Counter update(Counter counter){
        return dao.save(counter);
    }
    
    public void remove(int id){
        Counter counter = this.getById(id);
        dao.delete(counter);
    }

}
