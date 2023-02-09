package com.example.CollegeResult.Dtos;

import com.example.CollegeResult.Enums.BranchName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class BranchResponseDto {

    private int id;
    private String branchName;

    private String hodName;

    private String contactNo;

    private Date addedDate;

    private int grantGiven;
}
