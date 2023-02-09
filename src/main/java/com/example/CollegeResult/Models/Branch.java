package com.example.CollegeResult.Models;

import com.example.CollegeResult.Enums.BranchName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private BranchName branchName;

    private String hodName;

    private String contactNo;

    @Temporal(TemporalType.DATE)
    private Date addedDate;

    private int grantMoney;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList<>();



}
