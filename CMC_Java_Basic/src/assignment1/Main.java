/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HungVu
 */
public class Main {

    static String[] firstNames = {"Vu ", "Nguyen ", "Duong ", "Hoang ", "Tran ", "Quach ", "Luong "};
    static String[] midNames = {"Thi ", "Mai ", "Van ", "Quang ", "Manh ", "The ", "Duc"};
    static String[] lastNames = {"Truong", "Hieu", "Anh", "Khanh", "Linh", "Hung", "Hiep"};
    static String[] subjects = {"RA", "SD", "CP", "CUT", "FMT"};
    static Random rd = new Random();
    static Hashtable fullNames = new Hashtable();
    static Hashtable studentIDs = new Hashtable();
    static Hashtable dateOfBirths = new Hashtable();
    static Hashtable subjectMarks = new Hashtable();
    static int lengFirstNames = firstNames.length - 1;
    static int lengMidNames = midNames.length - 1;
    static int lengLastNames = lastNames.length - 1;

    public static void main(String[] args) {
        String tempFullName;
        String tempID;
        String tempDOB;
        for (int i = 0; i < 10; i++) {
            // create fullname
            tempFullName = getFullName();
            while (checkExisted(tempFullName, fullNames)) {
                tempFullName = getFullName();
            }
            fullNames.put(i, tempFullName);
            // create id
            tempID = getStudentID();
            while (checkExisted(tempID, studentIDs)) {
                tempID = getStudentID();
            }
            studentIDs.put(i, tempID);
            // create date of birth
            tempDOB = getDateOfBirth();
            while (checkExisted(tempDOB, dateOfBirths)) {
                tempDOB = getDateOfBirth();
            }
            dateOfBirths.put(i, tempDOB);
        }
        // add marks for subjects 
        for (int i = 0; i < subjects.length; i++) {
            subjectMarks.put(subjects[i], getMarksForASubject());
        }
        // show result
        String col1 = "Full name             ";
        String col2 = "ID               ";
        String col3 = "Date             ";
        String col4 = "RA    ";
        String col5 = "SD    ";
        String col6 = "CP    ";
        String col7 = "CUT   ";
        String col8 = "FMT   ";
        String col9 = "AVG";
        System.out.println(col1 + col2 + col3 + col4 + col5 + col6 + col7 + col8 + col9);
        for (int i = 0; i < 10; i++) {
            String fullName = (String)fullNames.get(i);
            String id = (String)studentIDs.get(i);
            String dob = (String)dateOfBirths.get(i);
            int marksRA[] = (int[])subjectMarks.get("RA");
            int ra = marksRA[i];
            int marksSD[] = (int[])subjectMarks.get("SD");
            int sd = marksSD[i];
            int marksCP[] = (int[])subjectMarks.get("CP");
            int cp = marksCP[i];
            int marksCUT[] = (int[])subjectMarks.get("CUT");
            int cut = marksCUT[i];
            int marksFMT[] = (int[])subjectMarks.get("FMT");
            int fmt = marksFMT[i];
            float avg = (float)(ra + sd + cp + cut + fmt) / 5; 
            String space1 = String.format("%" + (col1.length() - fullName.length()) + "s", "");
            String space2 = String.format("%" + (col2.length() - id.length()) + "s", "");
            String space3 = String.format("%" + (col3.length() - dob.length()) + "s", "");
            String space4 = String.format("%" + (col4.length() - Integer.toString(ra).length()) + "s", "");
            String space5 = String.format("%" + (col5.length() - Integer.toString(sd).length()) + "s", "");
            String space6 = String.format("%" + (col6.length() - Integer.toString(cp).length()) + "s", "");
            String space7 = String.format("%" + (col7.length() - Integer.toString(cut).length()) + "s", "");
            String space8 = String.format("%" + (col8.length() - Integer.toString(fmt).length()) + "s", "");
            System.out.println(fullName + space1 + id + space2 + dob + space3 + ra + space4
                + sd + space5 + cp + space6 + cut + space7 + fmt + space8 + avg);   
        }
    }

    public static int[] getMarksForASubject() {
        int marks[] = {rd.nextInt(3) + 8
                , rd.nextInt(3) + 5, rd.nextInt(3) + 5, rd.nextInt(3) + 5
                , rd.nextInt(2) + 3, rd.nextInt(2) + 3, rd.nextInt(2) + 3
                , rd.nextInt(2) + 1, rd.nextInt(2) + 1
                , 0};
        return marks;
    }

    public static String getFullName() {
        String fullName = firstNames[rd.nextInt(lengFirstNames)]
                + midNames[rd.nextInt(lengMidNames)]
                + lastNames[rd.nextInt(lengLastNames)];
        return fullName;
    }

    public static String getDateOfBirth() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse("01/02/1991");
            d2 = df.parse("31/12/1991");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));
        return df.format(randomDate);
    }

    public static String getStudentID() {
        return "HV" + Integer.toString(rd.nextInt(8999999) + 1000000);
    }

    public static boolean checkExisted(String value, Hashtable fullNames) {
        return fullNames.contains(value);
    }
}
