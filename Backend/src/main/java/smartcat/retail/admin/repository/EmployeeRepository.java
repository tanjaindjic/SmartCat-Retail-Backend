package smartcat.retail.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartcat.retail.admin.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
