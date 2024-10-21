package org.learn.regsystem.service;

import org.learn.regsystem.dtos.StudentDto;
import org.learn.regsystem.entities.Student;
import org.learn.regsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService extends AbstractService<Student, StudentDto, UUID>{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository repository, StudentRepository studentRepository) {
        super(repository);
        this.studentRepository = studentRepository;
    }

    @Override
    protected Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student login(StudentDto studentDto) throws Exception {
        return super.login(studentDto);
    }

    @Override
    public Student findByUsernameOrEmail(String username, String email) throws Exception {
        return null;
    }
}
