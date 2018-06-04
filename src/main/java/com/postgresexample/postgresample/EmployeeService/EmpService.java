package com.postgresexample.postgresample.EmployeeService;
import com.postgresexample.postgresample.EmployeeDto.Employee;
import com.postgresexample.postgresample.EmployeeModel.EmployeeRep;
import com.postgresexample.postgresample.EmployeeRepository.EmpRepository;
import com.postgresexample.postgresample.ExceptionEmployee.CharOverflowException;
import com.postgresexample.postgresample.ExceptionEmployee.EmpNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmpService {

//    @Autowired
    private EmpRepository empRep;

    @Autowired
    private EmpService(EmpRepository empRep){
        this.empRep = empRep;
    }

    public String createEmployeeService(Employee emp) throws CharOverflowException {

        if(emp.getName().length() > 10){
            throw new CharOverflowException("char greater than 10");
        }

        if(!empRep.existsById(emp.getName())) {
            EmployeeRep empCreated = new EmployeeRep();
            BeanUtils.copyProperties(emp,empCreated);
            empRep.save(empCreated);

            return "Employee created " + empCreated.getName() + " "+empCreated.getAddress()+" "+empCreated.getAge()+" "+empCreated.getPhone();
        }

        return "could not be created";
    }

    public Employee getInfo(String name) throws EmpNotFoundException {

        Optional<EmployeeRep> empFound = empRep.findById(name);

        if(!empFound.isPresent()) {
            throw new EmpNotFoundException("not found employee");
        }

        Employee emp = new Employee();
        BeanUtils.copyProperties(empFound,emp);
        return emp;

    }

    @Transactional
    public void deleteInfoEmp(String name) throws EmpNotFoundException {
        Employee empFoundDto = getInfo(name);
        empRep.deleteById(empFoundDto.getName());
    }

    public String updateEmpInfo(Employee employeeDto) throws EmpNotFoundException {
        Employee empFoundDto = getInfo(employeeDto.getName());

        EmployeeRep employeeRep = new EmployeeRep();
        BeanUtils.copyProperties(empFoundDto,employeeRep);
        empRep.save(employeeRep);

        return "Employee updated successfully ";
    }
}
