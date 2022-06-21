package com.example.demo.student.service;

import com.example.demo.student.models.Student;
import com.example.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
       return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
         studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
       boolean exists =  studentRepository.existsById(studentId);
       if (!exists){
           throw new IllegalStateException("STUDENT NOT EXISTS");
       }
         studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException( "student with id " + studentId +
                        "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }

        studentRepository.save(student);


    }
}
