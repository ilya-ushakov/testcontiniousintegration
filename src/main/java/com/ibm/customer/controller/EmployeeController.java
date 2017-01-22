package com.ibm.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.Callable;

@Controller

public class EmployeeController {


    private final  EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
        map.addAttribute("employee", new EmployeeBean());
        map.addAttribute("employeeList", EmployeeStorage.getInstance().getEmployeeBeans());

        return "employeeAsynch";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Callable<String> addEmployeeAsynch(@ModelAttribute(value="employee") final EmployeeBean employee, BindingResult result)
    {
        System.out.println("addEmployeeAsynch method enterring controller \n" + employee);

        Callable<String> asyncTask = new Callable<String>() {

            @Override
            public String call() throws Exception {
                EmployeeStorage.getInstance().getEmployeeBeans().add(employeeService.addNewEmployee(employee));
                return "redirect:/";
            }
        };

        System.out.println("addEmployeeAsynch method leaving controller");
        return asyncTask;
    }


    @RequestMapping(value = "/showEmpl", method = RequestMethod.POST)
    public Callable<String> showEmplAsynch(@ModelAttribute(value="employee") final EmployeeBean employee, final BindingResult result)
    {
        System.out.println("showEmplAsynch method enterring controller \n" + employee);

        Callable<String> asyncTask = new Callable<String>() {

            @Override
            public String call() throws Exception {
                for(EmployeeBean employee1: EmployeeStorage.getInstance().getEmployeeBeans()) {
                    if(employee.equals(employee1)) {
                        System.out.println("employee was found  \n" + employee);
                        result.getModel().put("respData", employee);

                        return "async";
                    }
                }
                result.getModel().put("respData", "no employee was found");
                return "async";
            }
        };

        System.out.println("showEmplAsynch method leaving controller");
        return asyncTask;
    }


}