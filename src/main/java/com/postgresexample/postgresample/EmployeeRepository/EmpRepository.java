package com.postgresexample.postgresample.EmployeeRepository;

import com.postgresexample.postgresample.EmployeeModel.EmployeeRep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends CrudRepository<EmployeeRep, String> {


}
