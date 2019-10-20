package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.model.dto.EmployeeDTO;
import smartcat.retail.admin.service.EmployeeService;

import javax.validation.constraints.NotNull;

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
            return ResponseEntity.ok(new EmployeeDTO(employee));
        if(employee != null)
            return ResponseEntity.ok(employee);
        return ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not found.");
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody @NotNull EmployeeDTO e){
        return ResponseEntity.ok(employeeService.createEmployee(e));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id, @RequestBody @NotNull EmployeeDTO e){
        Employee updatedEmployee = employeeService.updateEmployee(id, e);
        if(updatedEmployee != null)
            return ResponseEntity.ok(employeeService);
        return ResponseEntity.badRequest().body("Employee with a given ID: " + id + " was not updated.");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmploye(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
