package com.ibm.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeBean addNewEmployee(EmployeeBean employeeBean) {
        System.out.println(" start slow work");
        try {
            Thread.sleep(6000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" finish slow work");
        return new EmployeeBean(employeeBean.getFirstname(), employeeBean.getLastname());       // return view's name
    }
}