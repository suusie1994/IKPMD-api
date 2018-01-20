package nl.hsleiden.service;

import nl.hsleiden.model.Developer;
import nl.hsleiden.persistence.DeveloperDAO;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DeveloperService {
    private final DeveloperDAO dao;
    
    @Inject
    public DeveloperService(DeveloperDAO dao){
        this.dao = dao;
    }
    public Developer create(Developer developer) {
        return dao.save(developer);
    }
    
    public Developer getById(int id) {
        return dao.findById(id);
    }
    
    public Developer[] getAll(){
        return dao.findAll().toArray(new Developer[0]);
    }
    
    public Developer update(Developer developer){
        return dao.save(developer);
    }
    
    public void remove(int id){
        Developer developer = this.getById(id);
        dao.delete(developer);
    }
}
