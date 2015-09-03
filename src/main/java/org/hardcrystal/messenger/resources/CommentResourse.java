package org.hardcrystal.messenger.resources;

import org.hardcrystal.messenger.model.Comment;
import org.hardcrystal.messenger.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CommentResourse {

    public CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId){
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
        return CommentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commetnId}")
    public Comment updateComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long id,
                                 Comment comment){
        comment.setId(id);
        return CommentService.updateComment(messageId, comment);
    }

    @GET
    @Path("/{commentId}")
        public String getCommentById(@PathParam("messageId")long messageId, @PathParam("commentId") long commentId){
        return "Method return comment ID: " + commentId + " for message " + messageId;
    }
}
