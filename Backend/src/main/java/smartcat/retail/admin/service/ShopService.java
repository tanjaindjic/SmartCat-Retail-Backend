package smartcat.retail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartcat.retail.admin.model.Employee;
import smartcat.retail.admin.model.Shop;
import smartcat.retail.admin.model.Territory;
import smartcat.retail.admin.model.dto.ShopDTO;
import smartcat.retail.admin.repository.ShopRepository;

import java.util.Collection;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private TerritoryService territoryService;

    @Autowired
    private EmployeeService employeeService;

    public Collection getAllShops(){
        return shopRepository.findAll();
    }

    public Shop getShop(long id){
        return shopRepository.findById(id).orElse(null);
    }

    public Shop createShop(ShopDTO s){
        Territory t = territoryService.getTerritory(s.territoryId);
        if(t != null){
            Shop newShop = shopRepository.save(s.shop);
            t.getShops().add(newShop);
            territoryService.updateTerritory(t.getId(), t);
            newShop.setTerritory(t);
            newShop = shopRepository.save(newShop);
            return newShop;
        }
        else return null;
    }

    public Shop updateShop(long id, ShopDTO s) {
        Shop oldShop = getShop(id);
        long oldTerritoryId = oldShop.getTerritory().getId();
        Territory oldTerritory = territoryService.getTerritory(oldTerritoryId);
        shopRepository.save(s.shop);
        if(oldShop != null) {
            if(oldTerritoryId != s.territoryId){
                oldTerritory.getShops().remove(oldShop);
                territoryService.updateTerritory(oldTerritoryId, oldTerritory);

                Territory newTerritory = territoryService.getTerritory(s.territoryId);
                newTerritory.getShops().add(oldShop);
                territoryService.updateTerritory(s.territoryId, newTerritory);

                oldShop.setTerritory(newTerritory);
            }else{
                oldShop.setTerritory(oldTerritory);
            }
            return shopRepository.save(oldShop);
        }
        return null;
    }

    public Shop saveShop(Shop s){
        return shopRepository.save(s);
    }

    public void deleteShop(long id){
        shopRepository.deleteById(id);

    }
}
