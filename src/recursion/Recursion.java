/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Naveen Kumar, Chandaluri
 */
public class Recursion {

    int oddNumber = 0;
    int oddNumber2 = 0;
    int j = 1, jj = 0;
    boolean flag2 = false;
    int count = 1;

    /**
     * This is the sumOfOdd method with parameter of integer type.
     *
     * @param n of type integer.
     * @return value of type integer.
     */
    public int sumOfOdd(int n) {
        if (n < 1) {
            return 1;
        }
        if (n % 2 != 0) {
            oddNumber = oddNumber + n;
        }
        sumOfOdd(n - 1);
        return oddNumber;
    }

    /**
     * This method takes as number.
     *
     * @param n of integer type.
     * @return the value of integer type.
     */
    public int sumOfOdd2(int n) {
        if (flag2 == false) {
            jj = n;
            flag2 = true;
        }
        if (j < 1) {
            return 1;
        }
        if (j % 2 != 0 && count <= jj) {
            oddNumber2 = oddNumber2 + j;
            count++;
        }
        if (count <= jj) {
            j = j + 1;
            sumOfOdd2(j);
        }
        return oddNumber2;
    }

    private String name;
    int k = 0;
    int y = 0;
    boolean flag = false;
    private static ArrayList<ArrayList<Student>> arrangement = new ArrayList<ArrayList<Student>>();

    /**
     * this is the organizeSeats method
     *
     * @param studentList of arrayList of Student type.
     * @param k of integer type
     * @return the arrayList of ArrayList of student type.
     */
    public ArrayList<ArrayList<Student>> organizeSeats(ArrayList<Student> studentList, int k) {

        ArrayList<Student> listOfStudent = new ArrayList<Student>();

        if (k == studentList.size()) {
            for (int i = 0; i < studentList.size(); i++) {
                listOfStudent.add(studentList.get(i));
            }
            if (listOfStudent.size() == studentList.size()) {
                arrangement.add(listOfStudent);
            }
        } else {
            for (int i = k; i < studentList.size(); i++) {

                Student temp = studentList.get(k);
                studentList.set(k, studentList.get(i));
                studentList.set(i, temp);

                organizeSeats(studentList, k + 1);

                temp = studentList.get(k);
                studentList.set(k, studentList.get(i));
                studentList.set(i, temp);

            }
            k += 1;
        }
        return arrangement;
    }

    /**
     * this method to list of arrangement of the students.
     *
     * @param studentList of ArrayList of Student type.
     * @return the ArrayList of ArrayLis of Student type.
     */
    public ArrayList<ArrayList<Student>> organizeSeats(ArrayList<Student> studentList) {
        ArrayList<Student> a;
        ArrayList<Student> d;
        ArrayList<ArrayList<Student>> res1 = new ArrayList<>();
        int sort = 0;
        ArrayList<ArrayList<Student>> res = new ArrayList<>();
        for (Student s : studentList) {
            a = (ArrayList<Student>) studentList.clone();
            Collections.swap(a, 0, sort);
            sort++;
            d = (ArrayList<Student>) a.clone();
            if (a.size() > 2) {
                a.remove(0);
                res = organizeSeats(a);
            }
            if (studentList.size() == 2) {
                res1.add(a);
            }
            if (studentList.size() == 1) {
                res1.add(d);
            }
            if (studentList.size() > 2) {
                for (ArrayList<Student> item : res) {
                    item.add(0, d.get(0));
                    res1.add(item);
                }
                res.clear();
            }
        }
        return res1;
    }

    /**
     * This is the evaluteExpression is evaluate the math expression.
     *
     * @param str takes parameter as a String.
     * @return the value of integer type.
     */
    public int evaluateExpression(String str) {
        int count12 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count12++;
            }
            if (str.charAt(i) == ')') {
                count12--;
            }

        }
        if (count12 == 0) {
            ArrayList<Integer> in = new ArrayList<>();
            ArrayList<Integer> in1 = new ArrayList<>();
            ArrayList<String> operator = new ArrayList<String>();

            ArrayList<Integer> out = new ArrayList<>();
            if (str.indexOf(")") == str.length() - 1 && str.lastIndexOf("(") == 0 && str.contains("<")) {
                int a = 0, j = 0, k = 0, oper = 0;
                a = Integer.parseInt(str.substring(1, str.indexOf("<")));
                j = Integer.parseInt(str.substring(str.indexOf(">") + 1, str.length() - 1));
                oper = str.indexOf("<") + 1;

                switch (str.charAt(oper)) {
                    case '-':
                        k = a - j;
                        break;
                    case '/':
                        k = a / j;
                        break;
                    case '%':
                        k = a % j;
                        break;
                    case '+':
                        k = a + j;
                        break;
                    case '*':
                        k = a * j;
                        break;
                    default:
                        break;
                }
                return k;
            } else {
                for (int i = 0; i <= str.length() - 1; i++) {
                    if (str.charAt(i) == '(') {
                        in.add(i);
                        operator.add(str.substring(i, i + 1));
                        in1.add(i);
                    }
                    if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'
                            || str.charAt(i) == '%') {
                        if (str.charAt(i - 1) == ')') {

                            while ((!operator.isEmpty()) && (!operator.get(operator.size() - 1).matches("\\+|-"))
                                    && (!"(".equals(operator.get(operator.size() - 1)))) {

                                int fo = out.remove(out.size() - 1), so = out.remove(out.size() - 1);
                                String q = "(" + so + "<"
                                        + operator.remove(operator.size() - 1) + ">" + fo + ")";

                                out.add(evaluateExpression(q));
                            }
                            operator.add(str.substring(i, i + 1));
                        }
                    }
                    if (str.charAt(i) == ')') {
                        if (str.charAt(i) == ')' && str.charAt(i - 1) != ')') {
                            String exp = str.substring(in.get(in.size() - 1) + 1, i);
                            for (int j = exp.length() - 1; j >= 0; j--) {
                                if (exp.substring(j, j + 1).equals("/") || exp.substring(j, j + 1).equals("*")
                                        || exp.substring(j, j + 1).equals("%")
                                        || exp.substring(j, j + 1).equals("+") || exp.substring(j, j + 1).equals("-")) {
                                    if ((exp.substring(j - 1, j).equals("/") || exp.substring(j - 1, j).equals("%")
                                            || exp.substring(j - 1, j).equals("+")
                                            || exp.substring(j - 1, j).equals("-") || exp.substring(j - 1, j).equals("*"))) {
                                        if (exp.charAt(j) == '+' || exp.charAt(j) == '-') {
                                        } else {

                                        }
                                        out.add(Integer.parseInt(exp.substring(j).trim()));
                                        out.add(Integer.parseInt(exp.substring(0, j - 1).trim()));

                                        operator.add("" + exp.charAt(j - 1));
                                        break;
                                    } else {
                                        operator.add("" + exp.charAt(j));
                                        out.add(Integer.parseInt(exp.substring(j + 1, j + 2).trim()));
                                        out.add(Integer.parseInt(exp.substring(0, j).trim()));

                                        break;
                                    }
                                }
                            }
                        }
                        if (str.charAt(i - 1) != ')') {

                            String s = "(" + out.remove(out.size() - 1) + "<"
                                    + operator.remove(operator.size() - 1) + ">" + out.remove(out.size() - 1) + ")";
                            out.add(evaluateExpression(s));
                            operator.remove(operator.size() - 1);
                            in.remove(in.size() - 1);

                        } else {

                            int L = operator.lastIndexOf("(");
                            int count = 0;
                            for (int c = 0; c < L; c++) {
                                String s = operator.get(c);
                                if (s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+") || s.equals("%")) {
                                    count++;
                                }

                            }

                            while (L != operator.size() - 1) {

                                out.add(
                                        evaluateExpression(
                                                "(" + out.remove(count) + "<" + operator.remove(L + 1) + ">"
                                                + out.remove(count) + ")"));
                            }
                            operator.remove(operator.size() - 1);
                            in.remove(in.size() - 1);

                        }

                    }
                }
                while (!operator.isEmpty() && !operator.get(operator.size() - 1).equals("(")) {

                    int fo = out.remove(out.size() - 1), so = out.remove(out.size() - 1);
                    out.add(
                            evaluateExpression(
                                    "(" + so + "<" + operator.remove(operator.size() - 1) + ">"
                                    + fo + ")"));
                }
            }

            return out.remove(out.size() - 1);
        } else {
            System.out.println("Enter valid expression check ) and (");
            return 0;
        }
    }
}
