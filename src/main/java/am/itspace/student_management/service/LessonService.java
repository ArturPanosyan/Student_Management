package am.itspace.student_management.service;

import am.itspace.student_management.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    Lesson save(Lesson lesson);
    Optional<Lesson> findById(int id);
    List<Lesson> findLessonByTeacherId(int id);
    List<Lesson> findLessonByStudentId(int id);
    List<Lesson> findAll();
    void deleteById(int id);

}
