/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Naveen Kumar, Chandaluri
 */
public class RecursionDriver {

    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Recursion recursion = new Recursion();
        Scanner sc = new Scanner(System.in);
        System.out.println("********************  Sum of odd Numbers ******************");
        System.out.println("Enter the number:");
        /*
        *   Eg: it returns 9 if the number is 5.
         */
        System.out.println("Sum of the n odd numbers:" + recursion.sumOfOdd(sc.nextInt()));

        System.out.println("Enter the number:");
        /*
        *   Eg: it returns 25 if the number is 5.
         */
        System.out.println("Sum of the n odd numbers:" + recursion.sumOfOdd2(sc.nextInt()));

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the Students : ");
        String s = scan.nextLine();
        ArrayList<Student> q = new ArrayList<>();
        String[] a = s.split(",");
        Student st = null;
        for (String listOfNames : a) {
            st = new Student(listOfNames);
            q.add(st);
        }
        Recursion seat = new Recursion();
        ArrayList<ArrayList<Student>> arrangement = seat.organizeSeats(q);
        System.out.println("\n**************Seating Arrangements.*************");
        ArrayList<String> strs = new ArrayList<String>();
        for (ArrayList<Student> c : arrangement) {
            strs.add(c + " ");
        }

        for (String ss : strs) {
            System.out.println(ss.replace('[', ' ').replace(']', ' ').trim());
        }

        System.out.println("\n*******Two students are not sitting together.***************************");
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Enter names of students never sit together with comma:");
        String name = scan1.nextLine();
        ArrayList<Student> list = new ArrayList<Student>();
        String[] lists = name.split(",");
        Student c1;

        for (String n : lists) {
            c1 = new Student(n);
            list.add(c1);
        }

        String n1 = list.get(0).getFname();
        String n2 = list.get(1).getFname();

        ArrayList<String> navee2 = new ArrayList<String>();
        int t;
        for (ArrayList<Student> studentList : arrangement) {
            ArrayList<Student> seatingList = new ArrayList<Student>();
            seatingList.add(studentList.get(0));
            for (int i = 1; i < studentList.size(); i++) {
                t = i;
                if ((studentList.get(i).getFname().trim().equals(n1) && studentList.get(--t).getFname().trim().equals(n2))
                        || (studentList.get(i).getFname().trim().equals(n2) && studentList.get(--t).getFname().trim().equals(n1))) {
                    break;
                } else {
                    seatingList.add(studentList.get(i));
                }
                if (seatingList.size() == studentList.size()) {
                    navee2.add(seatingList + " ");
                }
            }
        }
        for (String sname : navee2) {
            System.out.print(sname.replace('[', ' ').replace(']', ' ').trim());
            System.out.print("\n");
        }
        System.out.println("Enter the expression to evaluate:");
        try {
            System.out.println("Result of the Expresssion: " + recursion.evaluateExpression(scan.nextLine()));
        } catch (ArithmeticException ae) {
            System.out.println("Number is divide by zero!!!");
        }
    }
}
