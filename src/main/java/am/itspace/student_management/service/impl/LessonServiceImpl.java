package am.itspace.student_management.service.impl;

import am.itspace.student_management.entity.Lesson;
import am.itspace.student_management.repository.LessonRepository;
import am.itspace.student_management.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Optional<Lesson> findById(int id) {
        return lessonRepository.findById(id);
    }

    @Override
    public List<Lesson> findLessonByTeacherId(int id) {
        return lessonRepository.findLessonByTeacher(id);
    }

    @Override
    public List<Lesson> findLessonByStudentId(int id) {
        return lessonRepository.findLessonByStudents(id);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        lessonRepository.deleteById(id);
    }
}
