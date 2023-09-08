package data.repositories;

import domain.entities.Student;
import domain.repositories.IStudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class StudentRepository implements IStudentRepository {

    @Override
    public Student getStudentFromInput() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten sinh vien: ");
        final String name = scanner.nextLine();

        LocalDate dateOfBirth;
        while (true) {
            try {
                System.out.print("Nhap ngay sinh (dd-MM-yyyy): ");
                final String dateOfBirthStr = scanner.nextLine();
                dateOfBirth = parseDateTime(dateOfBirthStr);
                break;
            } catch (DateTimeParseException ex) {
                System.out.println("Thoi gian khong hop le, hay nhap lai: ");
            }
        }

        System.out.print("Nhap ma sinh vien: ");
        final String code = scanner.nextLine();

        return new Student(name, dateOfBirth, code);
    }

    private LocalDate parseDateTime(String dateTimeStr) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateTimeStr, formatter);
    }
}
