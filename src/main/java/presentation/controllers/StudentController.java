package presentation.controllers;

import domain.entities.Student;
import domain.entities.Subject;
import domain.entities.SubjectGrade;
import domain.repositories.IStudentRepository;
import domain.repositories.ISubjectGradeRepository;
import domain.repositories.ISubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private IStudentRepository studentRepository;
    private ISubjectRepository subjectRepository;

    private ISubjectGradeRepository subjectGradeRepository;

    private List<Student> studentList;

    public StudentController(
            IStudentRepository studentRepository,
            ISubjectRepository subjectRepository,
            ISubjectGradeRepository subjectGradeRepository
    ) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.subjectGradeRepository = subjectGradeRepository;

        this.studentList = new ArrayList<>();
    }

    public void inputStudentList() {
        System.out.print("Nhap so luong sinh vien: ");
        final Scanner scanner = new Scanner(System.in);
        int numberOfStudent = scanner.nextInt();

        System.out.printf("\n== Nhap thong tin %d sinh vien ==\n", numberOfStudent);
        for (int i = 1; i <= numberOfStudent; i++) {
            System.out.printf("- Sinh vien %d -\n", i);
            final Student student = studentRepository.getStudentFromInput();
            if (!duplicateStudent(studentList, student)) {
                studentList.add(student);
            } else {
                System.out.println("Canh bao: Ma sinh vien da ton tai !");
                i--;
            }
        }

        System.out.printf("\n== Nhap ket qua hoc tap cua %d sinh vien: ==", studentList.size());
        for (final Student student : studentList) {
            student.setGradeList(
                    getStudentGradeListFromInput(student)
            );
        }
    }

    private  List<SubjectGrade> getStudentGradeListFromInput(Student student) {
        student.display();

        final List<Subject> subjectList = getStudentSubjectListFromInput(student);
        final List<SubjectGrade> subjectGradeList = new ArrayList<>();

        for (int i = 0; i < subjectList.size(); i++) {
            System.out.print("Nhap diem mon hoc: ");
            final Subject subject = subjectList.get(i);
            subject.display();
            final SubjectGrade grade = subjectGradeRepository.getSubjectGradeFromInput(subject);
            if (!duplicateSubjectGrade(subjectGradeList, grade)) {
                subjectGradeList.add(grade);
            } else {
                System.out.println("Canh bao: Diem mon hoc nay da duoc nhap !");
                i--;
            }
        }

        return subjectGradeList;
    }

    public List<Subject> getStudentSubjectListFromInput(Student student) {
        final List<Subject> subjectList = new ArrayList<>();

        System.out.println("* Danh sach mon hoc *");
        final int numberOfSubject = 1;
        for (int i = 1; i <= numberOfSubject; i++) {
            System.out.printf("- Nhap mon hoc thu %d -\n", i);
            final Subject subject = subjectRepository.getSubjectFromInput();

            if (!duplicateSubject(subjectList, subject)) {
                subjectList.add(subject);
            } else {
                System.out.println("Canh bao: Ma mon hoc da ton tai !");
                i--;
            }
        }

        return subjectList;
    }

    public void inputSubjectList() {

    }

    private boolean duplicateSubject(List<Subject> subjectList, Subject subject) {
        for (Subject iterableSubject: subjectList) {
            final String subjectCode = subject.getCode();
            final String iterableSubjectCode = iterableSubject.getCode();
            if (subjectCode.equals(iterableSubjectCode)) {
                return  true;
            }
        }
        return false;
    }

    private boolean duplicateSubjectGrade(List<SubjectGrade> gradeList, SubjectGrade grade) {
        for (SubjectGrade iterableGrade: gradeList) {
            final String gradeCode = grade.getSubject().getCode();
            final String iterableGradeCode = iterableGrade.getSubject().getCode();
            if (gradeCode.equals(iterableGradeCode)) {
                return  true;
            }
        }
        return false;
    }

    private boolean duplicateStudent(List<Student> studentList, Student student) {
        for (Student iterableStudent: studentList) {
            final String studentCode = student.getCode();
            final String iterableStudentCode = iterableStudent.getCode();
            if (studentCode.equals(iterableStudentCode)) {
                return  true;
            }
        }
        return false;
    }
}
