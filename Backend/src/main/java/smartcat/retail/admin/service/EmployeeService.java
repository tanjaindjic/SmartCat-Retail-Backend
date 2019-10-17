package smartcat.retail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.repository.EmployeeRepository;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Collection getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee e){
        return employeeRepository.save(e);
    }

    public Employee updateEmployee(long id, Employee e){
        if(getEmployee(id) != null)
            return employeeRepository.save(e);
        else return null;
    }
}

