/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naveen Kumar, Chandaluri
 */
public class RecursionTest {

    /**
     * This is the no argument constructor for RecursionTest.
     */
    public RecursionTest() {
    }

    /**
     * Test of sumOfOdd method, of class Recursion.
     */
    @Test
    public void testSumOfOdd() {
        System.out.println("sumOfOdd");
        int n = 0;
        Recursion instance = new Recursion();
        int expResult = 0;
        int result = instance.sumOfOdd(5);
        assertEquals(9, result);
    }

    /**
     * Test of sumOfOdd2 method, of class Recursion.
     */
    @Test
    public void testSumOfOdd2() {
        System.out.println("sumOfOdd2");
        int n = 5;
        Recursion instance = new Recursion();
        int expResult = 0;
        int result = instance.sumOfOdd2(n);
        assertEquals(25, result);
    }

    /**
     * Test of organizeSeats method, of class Recursion.
     */
    @Test
    public void testOrganizeSeats_ArrayList() {
        System.out.println("organizeSeats");
        ArrayList<Student> studentList = new ArrayList<Student>();
        Student st = null;
        Recursion instance = new Recursion();
        st = new Student("applied");
        studentList.add(st);
        st = new Student("computer");
        studentList.add(st);

        Student str1 = null;
        ArrayList<Student> sstr = new ArrayList<Student>();
        str1 = new Student("applied");
        sstr.add(str1);
        str1 = new Student("computer");
        sstr.add(str1);

        Student str2 = null;
        ArrayList<Student> str22 = new ArrayList<Student>();
        str2 = new Student("computer");
        str22.add(str2);
        str2 = new Student("applied");
        str22.add(str2);

        ArrayList<ArrayList<Student>> expResult = new ArrayList<ArrayList<Student>>();
        expResult.add(sstr);
        expResult.add(str22);
        ArrayList<ArrayList<Student>> result = instance.organizeSeats(studentList);
        int i = 0;
        String[] result1 = new String[2];
        for (ArrayList<Student> studentLists : result) {

            result1[i] = "";
            for (Student student : studentLists) {
                result1[i] = result1[i] + student.getFname();
            }
            i++;
        }
        String exp[] = new String[2];
        exp[1] = "computerapplied";
        exp[0] = "appliedcomputer";

        assertArrayEquals(exp, result1);

    }

    /**
     * Test of evaluateExpression method, of class Recursion.
     */
    @Test
    public void testEvaluateExpression() {
        System.out.println("evaluateExpression");
        String str = "(2+4)/((7/3)+(2*4))+(8*4)/((9-2)-(-8*9))";
        Recursion instance = new Recursion();
        int expResult = 0;
        int result = instance.evaluateExpression(str);
        assertEquals(expResult, result);

    }

}
