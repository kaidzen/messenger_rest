package org.hardcrystal.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResourse {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("authSessionID") String header,
                                            @CookieParam("JSESSIONID") String cookie){
        return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
    }
}
