package smartcat.retail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.model.Shop;
import smartcat.retail.admin.model.dto.EmployeeDTO;
import smartcat.retail.admin.repository.EmployeeRepository;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShopService shopService;

    public Collection getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(EmployeeDTO e){
        Shop shop = shopService.getShop(e.shop);
        if(shop == null)
            return null;
        Employee newEmployee = employeeRepository.save(new Employee(e));
        shop.getEmployees().add(newEmployee);
        shop = shopService.saveShop(shop);
        newEmployee.setShop(shop);
        newEmployee = employeeRepository.save(newEmployee);
        return newEmployee;

    }

    public Employee updateEmployee(long id, EmployeeDTO e){
        Employee oldEmployee = getEmployee(id);
        if(oldEmployee == null)
            return null;
        long oldShopId = oldEmployee.getShop().getId();
        Shop oldShop = shopService.getShop(oldShopId);
        oldEmployee.updateInfo(e);
        if(oldShopId != e.shop){
            oldShop.getEmployees().remove(oldEmployee);
            shopService.saveShop(oldShop);

            Shop newShop = shopService.getShop(e.shop);
            newShop.getEmployees().add(oldEmployee);
            shopService.saveShop(newShop);

            oldEmployee.setShop(newShop);
        }
        return employeeRepository.save(oldEmployee);

    }

    public void deleteEmployee(long id){
        Employee employee = getEmployee(id);
        Shop shop = employee.getShop();
        shop.getEmployees().remove(employee);
        shopService.saveShop(shop);
        employeeRepository.deleteById(id);
    }
}

