package am.itspace.student_management.repository;

import am.itspace.student_management.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findMessageByFromUserId(int fromUserId);

    List<Message> findMessageByToUserId(int toUserId);
}
