package data.repositories;

import domain.entities.Subject;
import domain.entities.SubjectGrade;
import domain.repositories.ISubjectGradeRepository;

import java.util.Scanner;

public class SubjectGradeRepository implements ISubjectGradeRepository {
    @Override
    public SubjectGrade getSubjectGradeFromInput(Subject subject) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap diem giua ki: ");
        final double midTermTestScore = scanner.nextDouble();

        System.out.print("Nhap diem thi het mon: ");
        final double finalTermTestScore = scanner.nextDouble();

        return new SubjectGrade(subject, midTermTestScore, finalTermTestScore);
    }
}
