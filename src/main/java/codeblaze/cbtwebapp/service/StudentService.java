package codeblaze.cbtwebapp.service;

import codeblaze.cbtwebapp.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student storeStudentData(Student student);
    Student updateStudentData(Student student);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
}
