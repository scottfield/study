package com.jackie.patterns.creational.prototype;

import org.junit.Test;

/**
 * Created by jackie on 5/27/2016.
 */
public class EmployeesTest {
    @Test
    public void testPrototype() throws Exception {
        Employees employees = new Employees();
        employees.loadData();
        Employees employees1 = (Employees) employees.clone();
        employees1.getEmpList().add("jackie");
        Employees employees2 = (Employees) employees.clone();
        employees2.getEmpList().add("tom");
        System.out.println("employees:"+employees);
        System.out.println("employees1:"+employees1);
        System.out.println("employees2:"+employees2);

    }
}