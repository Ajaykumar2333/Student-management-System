package com.Ajjaykumar.SMS;

import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.*;

@RestController //telling the java application --> this class will contain API end Points
public class StudentController {
    HashMap<Integer,Student> map = new HashMap<>();

    //sending data  request in 3 ways
    //1) Request Params //2)requestbody --> it will be JSON format --> in this format it is an object it contains KEy- value pairs
    // 3)PathVariables


    @PostMapping(value =  "/addStudent") //postman actually acts like a client
    public  String addStudent( @RequestBody() Student student){
        int key= student.id;
        map.put(key,student);
        return "Student added Succesfully";
    }
    @GetMapping("get_student_by_id")
    public Student getStudent(@RequestParam("id")int id){  //http://localhost:8080/get_student_by_id?id=1 this is the way of asking in postman
        return map.get(id);
    }
    @GetMapping("get_student_by_name")
    public  Student getStudent(@RequestParam("name") String searchName){

          for(Student s:map.values()){
              if(s.name.equals(searchName)){
                  return s;
              }
          }
          return null;
        }
        @GetMapping("get_by_path/{id}")
        public Student getByPath(@PathVariable("id") Integer id){ //its same as request param but clean url in pathvariable
           return map.get(id);
        }


    @PutMapping("Update_student_by_id")
    public Student updateStudent(@RequestBody() Student student){
       int key = student.id;
       map.put(key,student);
       return student;

    }
    @DeleteMapping("delete_Student")
    public  String deleteStudent(@RequestParam("id") int id){
        map.remove(id);
        return "Student has been removed";
    }


}
