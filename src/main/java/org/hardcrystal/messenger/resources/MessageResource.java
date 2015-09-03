package org.hardcrystal.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hardcrystal.messenger.model.Message;
import org.hardcrystal.messenger.resources.beans.MessageFilterBean;
import org.hardcrystal.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if (filterBean.getYear() > 0){
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@POST
	public Response addMessage(Message message){
		Message newMessage = messageService.addMessage(message);
		return Response.status(Response.Status.CREATED)
				.entity(newMessage)
				.build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}

	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId")long messageId){
		return messageService.getMessage(messageId);
	}

	@Path("/{messageId}/comments")
	public CommentResourse getCommenResource(){
		return new CommentResourse();
	}

}
