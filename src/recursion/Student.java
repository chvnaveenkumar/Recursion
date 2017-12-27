/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Naveen Kumar,Chandaluri
 */
public class Student {

    private String fname;

    /**
     * This is the constructor for the student class.
     *
     * @param fname of string type.
     */
    public Student(String fname) {
        this.fname = fname;
    }

    /**
     * This is the getter method of First Name of Student class.
     *
     * @return the string type.
     */
    public String getFname() {
        return fname;
    }

    /**
     * This is the setter method of Fname.
     *
     * @param fname of String type.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /*
    * This is the toString method of Student class.
    * @return It returns the fname of String type.
     */
    @Override
    public String toString() {
        return fname;
    }

}
