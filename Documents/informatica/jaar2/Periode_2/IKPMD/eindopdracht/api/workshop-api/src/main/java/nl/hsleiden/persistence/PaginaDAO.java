package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import nl.hsleiden.model.Pagina;

@Singleton
public class PaginaDAO extends AbstractDAO<Pagina> {
    
    @Inject
    public PaginaDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public Pagina findById(int id){
        return get(id);
    }
    public List<Pagina> findAll(){
        return (List<Pagina>) query("select p from Pagina p").list();
    }
    
    public Pagina save(Pagina page){
        return persist(page);
    }
    public void delete(Pagina page) {
        currentSession().delete(page);
    }
}
