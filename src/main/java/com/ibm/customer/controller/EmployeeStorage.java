package com.ibm.customer.controller;


import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage {
    private static EmployeeStorage ourInstance = new EmployeeStorage();
    private List<EmployeeBean> employeeBeans = new ArrayList<EmployeeBean>();

    public static EmployeeStorage getInstance() {
        return ourInstance;
    }

    private EmployeeStorage() {
    }

    public List<EmployeeBean> getEmployeeBeans() {
        if(employeeBeans.size() == 0){
            for(int i=1; i<12;i++){
                employeeBeans.add(new EmployeeBean("firstName" + i, "lastName" + i));
            }
        }

        return employeeBeans;
    }

}
