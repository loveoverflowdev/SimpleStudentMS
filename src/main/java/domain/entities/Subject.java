package domain.entities;

import infrastructure.utils.tprinter.TPrinter;

import java.time.format.DateTimeFormatter;

public final class Subject {
    private String code;

    private String name;

    private int credit;

    public Subject(String code, String name, int credit) {
        this.name = name;
        this.credit = credit;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        try {
            final TPrinter table = new TPrinter();

            table.setHeader("Code", "Name");
            table.addRow(this.code, this.name);

            table.printTable();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
