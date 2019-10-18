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
        Shop shop = shopService.getShop(e.shopId);
        if(shop == null)
            return null;
        Employee newEmployee = employeeRepository.save(e.employee);
        shop.getEmployees().add(newEmployee);
        shop = shopService.saveShop(shop);
        newEmployee.setShop(shop);
        newEmployee = employeeRepository.save(newEmployee);
        return newEmployee;

    }

    public Employee updateEmployee(long id, EmployeeDTO e){
        Employee oldEmployee = getEmployee(id);
        long oldShopId = oldEmployee.getShop().getId();
        Shop oldShop = shopService.getShop(oldShopId);
        employeeRepository.save(e.employee);
        if(oldEmployee != null) {
            if(oldShopId != e.shopId){
                oldShop.getEmployees().remove(oldEmployee);
                shopService.saveShop(oldShop);

                Shop newShop = shopService.getShop(e.shopId);
                newShop.getEmployees().add(oldEmployee);
                shopService.saveShop(newShop);

                oldEmployee.setShop(newShop);
            }else{
                oldEmployee.setShop(oldShop);
            }
            return employeeRepository.save(oldEmployee);
        }
        return null;
    }

    public void deleteEmployee(long id){
        Employee employee = getEmployee(id);
        Shop shop = employee.getShop();
        shop.getEmployees().remove(employee);
        shopService.saveShop(shop);
        employeeRepository.deleteById(id);
    }
}

