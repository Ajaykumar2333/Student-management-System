package com.Ajjaykumar.SMS;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.*;

@RestController //telling the java application --> this class will contain API end Points
public class StudentController {
    @Autowired
    Studentservice studentservice;


    //sending data  request in 3 ways
    //1) Request Params //2)requestbody --> it will be JSON format --> in this format it is an object it contains KEy- value pairs
    // 3)PathVariables


    @PostMapping(value =  "/addStudent") //postman actually acts like a client
    public  ResponseEntity<String> addStudent( @RequestBody() Student student){
        String response = studentservice.addStudent(student);

        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("get_student_by_id")
    public ResponseEntity<Student> getStudent(@RequestParam("id")int id){  //http://localhost:8080/get_student_by_id?id=1 this is the way of asking in postman

       Student resultStudent =  studentservice.getStudent(id);
       if(resultStudent == null){
           return new ResponseEntity<>(resultStudent,HttpStatus.BAD_REQUEST);
       }else {
           return new ResponseEntity<>(resultStudent, HttpStatus.OK);
       }
    }
    @GetMapping("get_student_by_name")
    public  ResponseEntity<Student> getStudent(@RequestParam("name") String searchName){

          Student result = studentservice.getStudentByName(searchName);

          if(result == null){
              return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
          }else{
              return new ResponseEntity<>(result,HttpStatus.OK);
          }
        }
        @GetMapping("get_by_path/{id}")
        public ResponseEntity<Student> getByPath(@PathVariable("id") Integer id) { //its same as request param but clean url in pathvariable

        //we are reutilizing those functions --> of the service and repository  layer
            Student resultStudent = studentservice.getStudent(id);
            if (resultStudent == null) {
                return new ResponseEntity<>(resultStudent, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(resultStudent, HttpStatus.OK);
            }
        }


    @PutMapping("Update_student_by_id")
    public ResponseEntity<Student> updateStudent(@RequestBody() Student student){
       Student student1 = studentservice.updateeStudent(student);

       return new ResponseEntity<>(student1,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("delete_Student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id){
      String resu = studentservice.deleteStudent(id);
      return new ResponseEntity<>(resu, HttpStatus.OK);
    }

}
