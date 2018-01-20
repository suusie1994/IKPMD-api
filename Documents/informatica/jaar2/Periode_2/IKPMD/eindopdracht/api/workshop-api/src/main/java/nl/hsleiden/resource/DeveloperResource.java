package nl.hsleiden.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.Developer;
import nl.hsleiden.service.DeveloperService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;

@Singleton
@Path("/developers")
@Produces(MediaType.APPLICATION_JSON)
public class DeveloperResource {
    private final DeveloperService service;
    
    @Inject
    public DeveloperResource(DeveloperService service){
        this.service = service;
    }
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Developer getPageById(@PathParam("id") int id) {
        return this.service.getById(id);
    }
    
    @GET
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Developer[] getDevelopers(){
        return this.service.getAll();
    }
    
    @PUT
    @Path("/create")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Developer create(@Valid Developer developer){
        return this.service.create(developer);
    }
    
    @POST
    @Path("/update")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Developer update(@Valid Developer developer){
        return this.service.update(developer);
    }
    
    @DELETE
    @Path("/{id}")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public void delete(@PathParam("id")int id) {
        this.service.remove(id);
    }
}
