package com.example.CollegeResult.Controllers;

import com.example.CollegeResult.Dtos.BranchRequestDto;
import com.example.CollegeResult.Dtos.BranchResponseDto;
import com.example.CollegeResult.Dtos.StudentRequestDto;
import com.example.CollegeResult.Services.BranchService;
import com.example.CollegeResult.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody BranchRequestDto branchRequestDto){
        branchService.addBranch(branchRequestDto);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_contactNo")
    public ResponseEntity<List<String>> getHodContacts(){
        List<String> result=branchService.getHodContact();

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @GetMapping("get_grant")
    public ResponseEntity<BranchResponseDto> getGrant(@RequestParam int grantMoney){
        //here we are getting the Department with maximum Absolute no of passing students
        // and setting the grant money and returning Branch
        return new ResponseEntity<>(branchService.getGrant(grantMoney),HttpStatus.FOUND);
    }




}
