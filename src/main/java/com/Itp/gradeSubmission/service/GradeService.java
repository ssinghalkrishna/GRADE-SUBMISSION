package com.Itp.gradeSubmission.service;

import com.Itp.gradeSubmission.Constants;
import com.Itp.gradeSubmission.repository.GradeRepository;
import com.Itp.gradeSubmission.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    private Logger logger;

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrade(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id) {
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade) {
        logger.info("New grade submitted: " + grade);

        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index) {
        gradeRepository.updateGrade(grade, index);
    }
}
