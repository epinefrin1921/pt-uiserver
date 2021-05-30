package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.MessageDto;
import ba.edu.ssst.ptuiserver.model.entities.Message;
import ba.edu.ssst.ptuiserver.repositories.MessageRepository;
import ba.edu.ssst.ptuiserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/message")
public class MessageController extends GenericController<Message, MessageDto>{

    @Autowired
    private MessageService messageService;

    public MessageController(MessageRepository repository) {
        super(repository,MessageDto.class, Message.class);
    }
    @Override
    @GetMapping
    public ResponseEntity<Collection<MessageDto>> getAll(){
        return ResponseEntity.ok(messageService.get());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(messageService.get(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<MessageDto> create(@RequestBody MessageDto created){
        MessageDto newObject = messageService.create(created);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@RequestBody MessageDto created, @PathVariable Long id){
        MessageDto newObject = messageService.update(id, created);
        return ResponseEntity.ok(newObject);
    }
}
