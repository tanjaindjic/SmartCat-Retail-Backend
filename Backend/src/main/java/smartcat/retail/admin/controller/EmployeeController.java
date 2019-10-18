package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.model.dto.EmployeeDTO;
import smartcat.retail.admin.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getEmployee(@PathVariable long id){
        Employee employee = employeeService.getEmployee(id);
        if(employee != null)
            return ResponseEntity.ok(new EmployeeDTO(employee, employee.getShop().getId()));
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not found.");
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO e){
        return ResponseEntity.ok(employeeService.createEmployee(e));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO e){
        Employee updatedEmployee = employeeService.updateEmployee(id, e);
        return updatedEmployee != null ? ResponseEntity.ok(employeeService) : ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not updated.");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmploye(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
