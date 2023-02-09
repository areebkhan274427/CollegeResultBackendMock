package com.example.CollegeResult.Dtos;

import com.example.CollegeResult.Enums.BranchName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    private String rollNo;

    private String name;


    private int marks;

    private int branchId;


}
