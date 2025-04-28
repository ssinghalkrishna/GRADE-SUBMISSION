package com.Itp.gradeSubmission.repository;

import com.Itp.gradeSubmission.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //comment to use bean in AppConfig class
public class GradeRepository {
    private List<Grade> studentgrades = new ArrayList<>();

    public Grade getGrade(int index) {
        return studentgrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentgrades.add(grade);
    }

    public void updateGrade(Grade grade, int index) {
        studentgrades.set(index, grade);
    }

    public List<Grade> getGrades() {
        return studentgrades;
    }

}
