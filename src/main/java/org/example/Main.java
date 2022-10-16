package org.example;

import org.checkerframework.checker.units.qual.A;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Students*/
        Student std1 = new Student("Bob Marley", 18, DateTime.parse("2000-12-13T21:39:45.618-08:00"), 19723725);
        Student std2 = new Student("Joe Blogs", 19, DateTime.parse("2000-12-14T21:39:45.618-08:00"), 19723726);
        Student std3 = new Student("Will Smith", 20, DateTime.parse("2000-12-14T21:39:45.618-08:00"), 19723727);
        Student std4 = new Student("Elon Musk", 18, DateTime.parse("2000-12-13T21:39:45.618-08:00"), 19723725);
        Student std5 = new Student("Jeff Brennan", 19, DateTime.parse("2000-12-14T21:39:45.618-08:00"), 19723726);
        Student std6 = new Student("Sam Cohen", 20, DateTime.parse("2000-12-14T21:39:45.618-08:00"), 19723727);

        /*LECTURES*/
        Lecturer l1 = new Lecturer("Eminem", 50, DateTime.parse("1980-12-13T21:39:45.618-08:00"), 123);
        Lecturer l2 = new Lecturer("Rihanna", 51, DateTime.parse("1981-12-13T21:39:45.618-08:00"), 124);
        Lecturer l3 = new Lecturer("Steve", 52, DateTime.parse("1982-12-13T21:39:45.618-08:00"), 125);

        /*Modules*/
        Module m1 = new Module("ECE301");
        Module m2 = new Module("ECE302");
        Module m3 = new Module("EE404");
        Module m4 = new Module("EE301");
        Module m5 = new Module("CS302");
        Module m6 = new Module("CS404");

        /*CourseProgramme*/
        CourseProgramme cp1 = new CourseProgramme("ECE", DateTime.parse("1022-09-01T09:00:00.618-08:00"), DateTime.parse("1022-12-21T09:00:00.618-08:00"));
        CourseProgramme cp2 = new CourseProgramme("EE", DateTime.parse("1022-09-01T09:00:00.618-08:00"), DateTime.parse("1022-12-21T09:00:00.618-08:00"));
        CourseProgramme cp3 = new CourseProgramme("Comp Sci", DateTime.parse("1022-09-01T09:00:00.618-08:00"), DateTime.parse("1022-12-21T09:00:00.618-08:00"));

        /*Setting up students modules*/
        std1.setModules(Arrays.asList(m1, m2));
        std2.setModules(Arrays.asList(m1, m2));
        std3.setModules(Arrays.asList(m3, m4));
        std4.setModules(Arrays.asList(m3, m4));
        std5.setModules(Arrays.asList(m5, m5));
        std6.setModules(Arrays.asList(m5,m6));

        /*Setting up students course programmes*/
        std1.setCourse(cp1);
        std2.setCourse(cp1);
        std3.setCourse(cp2);
        std4.setCourse(cp2);
        std5.setCourse(cp3);
        std6.setCourse(cp3);

        /*Setting up Lectures modules*/
        l1.setlModules(Arrays.asList(m1, m2));
        l2.setlModules(Arrays.asList(m3, m4));
        l3.setlModules(Arrays.asList(m5, m6));

        /*Setting up Course Programme modules and lecturer*/
        cp1.setModules(Arrays.asList(m1, m2));
        cp1.setStudents(Arrays.asList(std1, std2));
        cp2.setModules(Arrays.asList(m3, m4));
        cp2.setStudents(Arrays.asList(std3, std4));
        cp3.setModules(Arrays.asList(m5, m6));
        cp3.setStudents(Arrays.asList(std5, std6));

        /*Setting up Modules students and courseprogrammes*/
        m1.setStudents(Arrays.asList(std1, std2));
        m1.setLecturer(l1);
        m2.setStudents(Arrays.asList(std1, std2));
        m2.setLecturer(l1);
        m3.setStudents(Arrays.asList(std3, std4));
        m3.setLecturer(l2);
        m4.setStudents(Arrays.asList(std3, std4));
        m4.setLecturer(l2);
        m5.setStudents(Arrays.asList(std5, std6));
        m5.setLecturer(l3);
        m6.setStudents(Arrays.asList(std5, std6));
        m6.setLecturer(l3);

        /*Storing all created objects in lists respectively*/
        List<Student> allStd = new ArrayList<Student>();
        allStd.add(std1);
        allStd.add(std2);
        allStd.add(std3);
        allStd.add(std4);
        allStd.add(std5);
        allStd.add(std6);

        List<Lecturer> allL = new ArrayList<Lecturer>();
        allL.add(l1);
        allL.add(l2);
        allL.add(l3);

        List<Module> allM = new ArrayList<Module>();
        allM.add(m1);
        allM.add(m2);
        allM.add(m3);
        allM.add(m4);
        allM.add(m5);
        allM.add(m6);

        List<CourseProgramme> allCP = new ArrayList<CourseProgramme>();
        allCP.add(cp1);
        allCP.add(cp2);
        allCP.add(cp3);

        for(CourseProgramme CP: allCP){
            System.out.println("Course Name: " + CP.getCpName() + "\nThe Modules in this Course are:");
                for(Module m: CP.getModules()){
                    System.out.println(m.getmName());
                    System.out.println("Lecturer name: " + m.getLecturer().getlName() + " with username: " + m.getLecturer().getlUsername());
                    for(Student s: m.getStudents()){
                        System.out.println("Student: " + s.getName() + " with username: " + s.getUsername());
                    }
                    System.out.println();
                }
        }
        for(Student std: allStd){
            System.out.println("This is student: " + std.getName());
            System.out.println("His username is: " + std.getUsername());
            System.out.println("The course he studies is: " + std.getCourses().getCpName());
            System.out.println("The modules he studies are: ");
            for(Module m: std.getModules()) {
                System.out.println("Module name: " + m.getmName());
            }
            System.out.println();

        }
    }




}