package main;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ptit.hungvu.model.Student;
import view.AddStudentFrm;

public class Main {

    public static void main(String[] args) throws ParseException {
        AddStudentFrm addStudentFrm = new AddStudentFrm();
        addStudentFrm.setVisible(true);
    }
}
