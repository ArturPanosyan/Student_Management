package am.itspace.student_management.repository;

import am.itspace.student_management.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Integer > {

    List<Lesson> findLessonByTeacher(int userId);
    List<Lesson> findLessonByStudents(int userId);
}
