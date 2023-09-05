package com.example.proj1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    //www.domain.com/get?q=2000 & name = pravin
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return db.get(regNo);
    }
        //requestparam : take variable as input in the url
         //requestbody : entire object as input

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";
    }
    @GetMapping("/getByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }

    @PutMapping("/update-age/{id}")
    public Student updateage(@PathVariable("id") int regNo, @RequestParam("q") int newage){
        db.get(regNo).setAge(newage);
        return db.get(regNo);
    }
//    @PutMapping("/update-age")
//    public Student updateage(@RequestParam("id") int regNo, @RequestParam("q") int newage, @RequestBody Student student){
//        db.get(regNo).setAge(newage);
//        return db.get(regNo);
//    }


    //delete a student --> request param
//    @DeleteMapping("/delete")
//    public String deleteStudent(@RequestParam("id")int regNo){
//        db.remove(regNo);
//        return " Student record has been deleted successfully";
//    }

    //delete a student --> using path variable
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int regNo){
        db.remove(regNo);
        return "Sudent record has been deleted successfully";
    }

    //change course of a student(regNo, course) --> both as request params


    //change course and age -->regNo as request param , entire student object as requetbody

//    @PutMapping("/update-course")
//    public Student updatecourse(@RequestParam("id") int regNo,@RequestParam("course") String newcourse){
//        db.get(regNo).setCourse(newcourse);
//        return db.get(regNo);
//    }


    //change course of a student --> both as path varaibles
//    @PutMapping("/update-course/{id}/{course}")
//    public Student updatecourse(@PathVariable ("id") int regNo,@PathVariable ("course") String newcourse){
//        db.get(regNo).setCourse(newcourse);
//        return db.get(regNo);
//    }


    //change course -->. one as request param, one as path variable
    @PutMapping("/update-course/{cour}")
    public Student updateCourse(@RequestParam ("ide") int regNo,@PathVariable ("cour") String newcourse){
        db.get(regNo).setCourse(newcourse);
        return db.get(regNo);
    }
}

