package codeblaze.cbtwebapp.service;

import codeblaze.cbtwebapp.model.Student;
import codeblaze.cbtwebapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
   StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
return studentRepository.findAll();
    }

    @Override
    public Student storeStudentData(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentData(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


}
