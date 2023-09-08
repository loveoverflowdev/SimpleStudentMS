package domain.entities;

import infrastructure.utils.tprinter.TPrinter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private LocalDate dateOfBirth;
    private String code;

    private List<SubjectGrade> gradeList;

    public Student(String name, LocalDate dateOfBirth, String code) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.code = code;

        gradeList = new ArrayList<>();
    }

    public void addGrade(SubjectGrade grade) {
        gradeList.add(grade);
    }

    public List<SubjectGrade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<SubjectGrade> gradeList) {
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void display() {
        try {
            final TPrinter table = new TPrinter();

            table.setHeader("Code", "Name", "Date Of Birth");
            table.addRow(this.code, this.name, this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            table.printTable();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
