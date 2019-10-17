package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Employee;
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
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not found.");
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee e){
        return ResponseEntity.ok(employeeService.createEmployee(e));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id, @RequestBody Employee e){
        Employee updatedEmployee = employeeService.updateEmployee(id, e);
        return updatedEmployee != null ? ResponseEntity.ok(employeeService) : ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not updated.");
    }
}
