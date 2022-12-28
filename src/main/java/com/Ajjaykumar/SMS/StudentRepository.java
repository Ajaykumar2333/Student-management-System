package com.Ajjaykumar.SMS;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository //to tell java this is the repository class
public class StudentRepository {


    HashMap<Integer,Student> map = new HashMap<>();
   String  addStudenttoDb(Student student){
       int key = student.id;
       map.put(key,student);
       return "Successfully added";
    }

    Student getStudent(int id){
       if(map.containsKey(id)){
           return map.get(id);
       }else{
           return null;
       }
    }

    Student getStudentName(String name){
        for(Student s:map.values()){
            if(s.name.equals(name)){
                return s;
            }
        }
        return null;
    }

    Student UpdateStudent(Student student){
        int key = student.id;
        map.put(key,student);
        return student;
    }
    String removeStudent(int id){
       if(map.containsKey(id)){
           map.remove(id);
       }else {
           return "there is no matches";
       }

        return "Succesfully removed";
    }
}
