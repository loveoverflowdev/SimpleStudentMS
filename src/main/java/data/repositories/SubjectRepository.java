package data.repositories;

import java.util.Scanner;


import domain.entities.Subject;
import domain.repositories.ISubjectRepository;

public class SubjectRepository implements ISubjectRepository {
    @Override
    public Subject getSubjectFromInput() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma mon hoc: ");
        final String code = scanner.nextLine();

        System.out.print("Nhap ten mon hoc: ");
        final String name = scanner.nextLine();

        System.out.print("Nhap so tin chi cua mon hoc: ");
        final int credit = scanner.nextInt();

        return new Subject(code, name, credit);
    }
}
