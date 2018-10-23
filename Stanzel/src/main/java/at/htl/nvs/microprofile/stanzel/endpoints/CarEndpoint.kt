package at.htl.nvs.microprofile.stanzel.endpoints

import at.htl.nvs.microprofile.stanzel.entity.Car
import at.htl.nvs.microprofile.stanzel.persistence.CarRepository
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cars")
@RequestScoped
open class CarEndpoint {
    @Inject
    private var repository: CarRepository? = null

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    open fun getAll() = Response.ok(repository?.getAll()).build()!!

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    open fun getById(@PathParam("id") id: Long) = Response.ok(repository?.getById(id)).build()!!

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    open fun create(c: Car) = Response.ok(repository?.create(c)).build()!!

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    open fun update(c: Car) = Response.ok(repository?.update(c)).build()!!

    @DELETE
    @Path("/{id}")
    open fun delete(@PathParam("id") id: Long) = Response.ok(repository?.delete(id)).build()!!

}