package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.*;
import ba.edu.ssst.ptuiserver.model.entities.Message;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService extends GenericService<Message>{

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public MessageService(GenericRepository<Message> repository,
                          UserRepository userRepository) {
        super(repository);
        this.userRepository=userRepository;
        this.mapper = new ModelMapper();
    }
    public List<MessageDto> get(){
        List<MessageDto> entities = super.get(MessageDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public MessageDto get(Long id){
        MessageDto entity = super.get(id, MessageDto.class);
        this.fillForeignObjects(entity);
        return entity;
    }

    @Transactional
    public MessageDto create(MessageDto newDomain){
        this.extractDtos(newDomain);
        newDomain = super.create(newDomain, MessageDto.class, Message.class);
        this.fillForeignObjects(newDomain);
        return newDomain;
    }

    @Transactional
    public MessageDto update(Long id, MessageDto updated){
        get(id, MessageDto.class);
        this.extractDtos(updated);
        updated = super.update(id, updated, MessageDto.class, Message.class);
        this.fillForeignObjects(updated);
        return updated;
    }

    private MessageDto fillForeignObjects (MessageDto messageDto){
        messageDto.setSentByDto(mapper.map(messageDto.getSentBy(), UserDto.class));
        messageDto.setSentById(messageDto.getSentBy().getId());
        messageDto.setSentToDto(mapper.map(messageDto.getSentTo(), UserDto.class));
        messageDto.setSentToId(messageDto.getSentTo().getId());
        return messageDto;
    }
    private MessageDto extractDtos (MessageDto messageDto){
        messageDto.setSentBy(userRepository.getOne(messageDto.getSentById()));
        messageDto.setSentTo(userRepository.getOne(messageDto.getSentToId()));
        return messageDto;
    }
}
