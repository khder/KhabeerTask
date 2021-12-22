package com.va.khabeertask.data;

import java.util.ArrayList;

public class PayRoll {
    private String employeeName;
    private String employeeSpecialist;
    private ArrayList<Deductions>deductions;

    public ArrayList<Deductions> getDeductions() {
        return deductions;
    }

    public void setDeductions(ArrayList<Deductions> deductions) {
        this.deductions = deductions;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSpecialist() {
        return employeeSpecialist;
    }

    public void setEmployeeSpecialist(String employeeSpecialist) {
        this.employeeSpecialist = employeeSpecialist;
    }
}
