package nl.hsleiden.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.Counter;
import nl.hsleiden.service.CounterService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;

@Singleton
@Path("/counters")
@Produces(MediaType.APPLICATION_JSON)
public class CounterResource {
     private final CounterService service;
    
    @Inject
    public CounterResource(CounterService service){
        this.service = service;
    }
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Counter getcountById(@PathParam("id") int id) {
        return this.service.getById(id);
    }
    @GET
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Counter[] getCounters(){
        return this.service.getAll();
    }
    @PUT
    @Path("/create")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Counter create(@Valid Counter counter){
        return this.service.create(counter);
    }
    
    @POST
    @Path("/update")
    @JsonView(View.Public.class)
    @Timed
    @UnitOfWork
    public Counter update(@Valid Counter counter){
        return this.service.update(counter);
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
