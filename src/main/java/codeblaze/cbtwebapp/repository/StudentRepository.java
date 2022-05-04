package codeblaze.cbtwebapp.repository;

import codeblaze.cbtwebapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {
}
