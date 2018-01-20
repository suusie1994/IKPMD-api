package nl.hsleiden.service;

import nl.hsleiden.model.Pagina;
import nl.hsleiden.persistence.PaginaDAO;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PaginaService {
    private final PaginaDAO dao;
    
    @Inject
    public PaginaService(PaginaDAO dao){
        this.dao = dao;
    }
    
    public Pagina create(Pagina page) {
        return dao.save(page);
    }
    
    public Pagina getById(int id) {
        return dao.findById(id);
    }
    
    public Pagina[] getAll(){
        return dao.findAll().toArray(new Pagina[0]);
    }
    
    public Pagina update(Pagina page){
        return dao.save(page);
    }
    
    public void remove(int id){
        Pagina page = this.getById(id);
        dao.delete(page);
    }
}
