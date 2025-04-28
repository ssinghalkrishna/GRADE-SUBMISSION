package com.Itp.gradeSubmission.repository;

import com.Itp.gradeSubmission.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository1 extends JpaRepository<Grade, Integer> {
    Grade getGrade(int index);

    List<Grade> getGrades();

    void addGrade(Grade grade);

    void updateGrade(Grade grade, int index);
}