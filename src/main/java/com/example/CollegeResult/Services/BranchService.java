package com.example.CollegeResult.Services;

import com.example.CollegeResult.Dtos.BranchRequestDto;
import com.example.CollegeResult.Models.Branch;
import com.example.CollegeResult.Models.Student;
import com.example.CollegeResult.Repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public void addBranch(BranchRequestDto branchRequestDto){
        Branch branch=Branch.builder().branchName(branchRequestDto.getBranchName()).hodName(branchRequestDto.getHodName())
                .addedDate(branchRequestDto.getAddedDate()).contactNo(branchRequestDto.getContactNo()).build();

        //initially grant Money will be zero
        branch.setGrantMoney(0);

        branchRepository.save(branch);

    }

    public List<String> getHodContact(){
        List<Branch> branchList=branchRepository.findAll();

        List<String> result=new ArrayList<>();
        int maxStudents=Integer.MIN_VALUE;


        for(Branch branch:branchList){
            List<Student> studentList=branch.getStudentList();
            int count=0;
            for(Student student:studentList){
                if(student.getMarks()>=40){
                    count++;
                }

            }
            if(count>=maxStudents){
                maxStudents=count;
                result.add(branch.getContactNo());
            }
        }

        return result;
    }
}












