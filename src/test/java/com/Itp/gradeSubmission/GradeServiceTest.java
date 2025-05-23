package com.Itp.gradeSubmission;

import com.Itp.gradeSubmission.repository.GradeRepository;
import com.Itp.gradeSubmission.entity.Grade;
import com.Itp.gradeSubmission.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest() {
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                new Grade("Harry", "Potions", "C-"),
                new Grade("Hermione", "Arithmancy", "A+")
        ));
        List<Grade> result = gradeService.getGrades();
        assertEquals("Harry", result.get(0).getName());
        assertEquals("Arithmancy", result.get(1).getSubject());
    }

    @Test
    public void gradeIndexTest() {
        Grade grade = new Grade("A", "Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(999, notFound);
    }

    @Test
    public void returnGradeByIdTest() {
        Grade grade = new Grade("A", "Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);

        assertEquals(grade, result);
    }

    @Test
    public void addGradeTest() {
        Grade grade = new Grade("A", "Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade("C", "George", "Arithmancy", "A+");

        gradeService.submitGrade(newGrade);
        verify(gradeRepository, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest() {
        Grade grade = new Grade("A", "Harry", "Potions", "C-");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        grade.setScore("A-");
        gradeService.submitGrade(grade);

        verify(gradeRepository, times(1)).updateGrade(grade, 0);
    }

}
