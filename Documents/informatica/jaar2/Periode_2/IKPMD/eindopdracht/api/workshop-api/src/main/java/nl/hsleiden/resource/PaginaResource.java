package nl.hsleiden.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.Pagina;
import nl.hsleiden.service.PaginaService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;

@Singleton
@Path("/pages")
@Produces(MediaType.APPLICATION_JSON)
public class PaginaResource {
    private final PaginaService service;
    
    @Inject
    public PaginaResource(PaginaService service){
        this.service = service;
    }
    
    @GET
    @Path("/{id}")
    // @RolesAllowed(Role.GUEST)
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Pagina getPageById(@PathParam("id") int id) {
        return this.service.getById(id);
    }
    
    @GET
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Pagina[] getPages(){
        return this.service.getAll();
    }
    
    @PUT
    @Path("/create")
    //@RolesAllowed(Role.ADMIN)
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Pagina create(@Valid Pagina page){
        return this.service.create(page);
    }
    
    @POST
    @Path("/update")
    //@RolesAllowed(Role.ADMIN)
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Pagina update(@Valid Pagina page){
        return this.service.update(page);
    }
    
    @DELETE
    @Path("/{id}")
    //@RolesAllowed(Role.ADMIN)
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public void delete(@PathParam("id")int id) {
        this.service.remove(id);
    }

    
}
