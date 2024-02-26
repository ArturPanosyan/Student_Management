package am.itspace.student_management.service.impl;

import am.itspace.student_management.entity.Message;
import am.itspace.student_management.repository.MessageRepository;
import am.itspace.student_management.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        message.setLocalDateTime(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findMessageByFromUserId(int fromUserId) {
        return messageRepository.findMessageByFromUserId(fromUserId);
        }

    @Override
    public List<Message> findMessageByToUserId(int toUserId) {
        return messageRepository.findMessageByToUserId(toUserId);
    }
}