package smartcat.retail.admin.model.dto;

import smartcat.retail.admin.model.Employee;

public class EmployeeDTO {
    public Employee employee;
    public long shopId;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee, long shopId) {
        this.employee = employee;
        this.shopId = shopId;
    }
}
