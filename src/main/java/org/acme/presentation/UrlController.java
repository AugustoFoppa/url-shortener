package org.acme.presentation;

import org.acme.infra.UrlEntity;
import org.acme.infra.UrlRepositoryJpa;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/r")
public class UrlController {

    private final UrlRepositoryJpa urlRepositoryJpa;

    public UrlController(UrlRepositoryJpa urlRepositoryJpa) {
        this.urlRepositoryJpa = urlRepositoryJpa;
    }
   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "pong";
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(urlRepositoryJpa.findById(id)).build();
    }

    @POST
    public Response post(UrlEntity body) {
        return Response.ok(urlRepositoryJpa.insert(body)).build();
    }
    
}
