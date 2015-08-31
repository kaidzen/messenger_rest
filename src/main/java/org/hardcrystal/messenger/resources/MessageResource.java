package org.hardcrystal.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.hardcrystal.messenger.model.Message;
import org.hardcrystal.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}

	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
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

}
