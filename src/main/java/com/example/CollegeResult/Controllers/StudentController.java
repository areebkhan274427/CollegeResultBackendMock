package com.example.CollegeResult.Controllers;

import com.example.CollegeResult.Dtos.StudentRequestDto;
import com.example.CollegeResult.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_student_rollNo")
    public ResponseEntity<List<String>> getStudentRollNo(){
        List<String> result=studentService.getStudentRollNo();
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }


}
