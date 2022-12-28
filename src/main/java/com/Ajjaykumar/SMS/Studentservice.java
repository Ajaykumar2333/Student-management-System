package com.Ajjaykumar.SMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //this is the way of telling the java that it is service layer
public class Studentservice {

    @Autowired //it is used to connect the differnt classes by object --.autowired automatically take care of oject creation
    StudentRepository studentRepository;
    String addStudent(Student student){
        String result = studentRepository.addStudenttoDb(student);
        return result;

    }
    Student getStudent(int id){
       Student student = studentRepository.getStudent(id);
       return student;

    }
    Student getStudentByName(String name){
        Student student = studentRepository.getStudentName(name);
        return student;
    }
    Student updateeStudent(Student student){
        Student student1 = studentRepository.UpdateStudent(student);
        return student1;
    }

    String deleteStudent(int id){
        String res = studentRepository.removeStudent(id);
        return res;
    }
}
