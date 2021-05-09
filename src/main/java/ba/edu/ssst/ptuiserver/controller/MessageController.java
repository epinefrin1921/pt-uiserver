package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.MessageDto;
import ba.edu.ssst.ptuiserver.model.entities.Message;
import ba.edu.ssst.ptuiserver.repositories.MessageRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@Api(value="messages", description="Operations pertaining to messages")
public class MessageController extends GenericController<Message, MessageDto>{
    public MessageController(MessageRepository repository) {
        super(repository,MessageDto.class, Message.class);
    }
}
