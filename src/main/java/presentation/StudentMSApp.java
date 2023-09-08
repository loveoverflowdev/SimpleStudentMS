package presentation;

import data.repositories.StudentRepository;
import data.repositories.SubjectGradeRepository;
import data.repositories.SubjectRepository;
import domain.repositories.IStudentRepository;
import domain.repositories.ISubjectGradeRepository;
import domain.repositories.ISubjectRepository;
import presentation.controllers.StudentController;

public class StudentMSApp {
    private final StudentController studentController;

    public StudentMSApp() {
        IStudentRepository studentRepository = new StudentRepository();
        ISubjectRepository subjectRepository = new SubjectRepository();
        ISubjectGradeRepository iSubjectGradeRepository = new SubjectGradeRepository();

        studentController = new StudentController(
                studentRepository,
                subjectRepository,
                iSubjectGradeRepository
        );
    }

    public void start() {
        studentController.inputStudentList();
    }
}

