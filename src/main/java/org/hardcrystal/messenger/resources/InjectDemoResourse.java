package org.hardcrystal.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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

    @GET
    @Path("context")
    public  String getParamsUsingContex(@Context UriInfo uriInfo, @Context HttpHeaders headers){
        String cookies = headers.getCookies().toString();
        String path = uriInfo.getAbsolutePath().toString();
        return "Path: " + path + " Cookies: " + cookies;
    }
}
