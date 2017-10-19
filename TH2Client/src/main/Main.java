/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import view.AddStudentFrm;
import view.SearchStudentFrm;
import view.SearchSubjectFrm;

/**
 *
 * @author HungVu
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        AddStudentFrm addStudentFrm = new AddStudentFrm();
        addStudentFrm.setVisible(true);
        SearchStudentFrm s = new SearchStudentFrm();
        s.setVisible(true);
        SearchSubjectFrm su = new SearchSubjectFrm();
        su.setVisible(true);
    }
}
