package pr.grifyl;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/lettres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LetterResource {
    
    @Inject
    LetterService letterService;

    @POST
    public Response createLetter(Letter letter) {
        Letter created = letterService.createLetter(letter);
        return Response.ok(created).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Letter getLetter(@PathParam("id") String id) {
        return letterService.findById(id);
    }

    @GET
    public List<Letter> getAllLetters() {
        return letterService.findAll();
    }

    @PUT
    @Path("/{id}/status")
    public Response updateStatus(@PathParam("id") String id, String status) {
        letterService.updateStatus(id, status);
        return Response.noContent().build();
    }
}
