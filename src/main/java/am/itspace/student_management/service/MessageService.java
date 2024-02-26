package am.itspace.student_management.service;

import am.itspace.student_management.entity.Message;

import java.util.List;

public interface MessageService {

    Message save(Message message);
    List<Message> findMessageByFromUserId(int fromUserId);
    List<Message> findMessageByToUserId(int toUserId);

}
