package com.jackie.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 5/27/2016.
 * 原型模式
 */
public class Employees implements Cloneable {
    private List<String> empList;

    public Employees() {
        this.empList = new ArrayList<>();
    }

    public Employees(List<String> empList) {
        this.empList = empList;
    }

    public void loadData() {
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");

    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empList=" + empList +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        temp.addAll(getEmpList());
        return new Employees(temp);
    }
}
