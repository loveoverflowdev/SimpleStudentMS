package domain.repositories;

import domain.entities.Subject;
import domain.entities.SubjectGrade;

public interface ISubjectGradeRepository {
    SubjectGrade getSubjectGradeFromInput(Subject subject);
}
