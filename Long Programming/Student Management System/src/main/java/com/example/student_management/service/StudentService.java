package com.example.student_management.service;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());

        return repository.save(student);
    }

    public void deleteStudent(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        repository.delete(student);
    }
}

