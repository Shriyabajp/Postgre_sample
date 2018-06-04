package com.postgresexample.postgresample.EmployeeController;
import com.postgresexample.postgresample.EmployeeDto.Employee;
import com.postgresexample.postgresample.EmployeeService.EmpService;
import com.postgresexample.postgresample.ExceptionEmployee.CharOverflowException;
import com.postgresexample.postgresample.ExceptionEmployee.EmpNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/employee")
public class EmpControl {

    @Autowired
    private EmpService empservice;

    @RequestMapping("/greet")
    public String index(@RequestParam String name, @RequestParam int age) {
        return "welcome to employee webpage "+name + " "+age;
    }

    @RequestMapping("/create")
    public String createEmp(@RequestParam String name, @RequestParam String address, @RequestParam int age, @RequestParam int phone) throws CharOverflowException {
        return "welcome to employee webpage "+empservice.createEmployeeService((new Employee(name, address, age, phone)));
    }

    @RequestMapping(value = "/createpost", method = RequestMethod.POST)
    public String createEmployeepost(@RequestBody Employee employee) throws CharOverflowException {
        return "welcome new employee securely "+empservice.createEmployeeService(employee);
    }

    @RequestMapping(value= "/getinfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Employee getEmpInfo(@RequestParam String name) throws EmpNotFoundException {
        return empservice.getInfo(name);
    }

    @RequestMapping(value = "/deleteinfo", method = RequestMethod.DELETE)
    public String deleteEmpInfo(@RequestParam String name) throws EmpNotFoundException {
        empservice.deleteInfoEmp(name);
        return "the info is deleted";
    }

    @RequestMapping(value = "/updateinfo", method = RequestMethod.PUT)
    public String updateEmpInfo(@RequestBody Employee employeeDto) throws  EmpNotFoundException {
        return empservice.updateEmpInfo(employeeDto);
    }

}

