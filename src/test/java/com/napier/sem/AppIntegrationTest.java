package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetEmployee()
    {
        Employee emp = app.getEmployee(255655);
        assertEquals(emp.emp_no, 255655);
        assertEquals(emp.first_name, "Khaled");
        assertEquals(emp.last_name, "Eastman");
    }
    @Test
    void testGetDepartment()
    {
        Department dep = app.getDepartment("Sales");
        assertEquals(dep.dept_name,"Sales");
        assertEquals(dep.dept_no,"d007");
    }

    @Test
    void testAddEmployee()
    {
        Employee emp = new Employee();
        emp.emp_no = 500000;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        app.addEmployee(emp);
        emp = app.getEmployee(500000);
        assertEquals(emp.emp_no, 500000);
        assertEquals(emp.first_name, "Kevin");
        assertEquals(emp.last_name, "Chalmers");
    }

}