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
        Territory t = territoryService.getTerritory(s.territory);
        if(t != null){
            Shop newShop = shopRepository.save(new Shop(s));
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
        if(oldShop == null)
            return null;
        long oldTerritoryId = oldShop.getTerritory().getId();
        Territory oldTerritory = territoryService.getTerritory(oldTerritoryId);
        oldShop.updateInfo(s);
        if(oldTerritoryId != s.territory){
            oldTerritory.getShops().remove(oldShop);
            territoryService.updateTerritory(oldTerritoryId, oldTerritory);

            Territory newTerritory = territoryService.getTerritory(s.territory);
            newTerritory.getShops().add(oldShop);
            territoryService.updateTerritory(s.territory, newTerritory);

            oldShop.setTerritory(newTerritory);
        }
        return shopRepository.save(oldShop);
    }

    public Shop saveShop(Shop s){
        return shopRepository.save(s);
    }

    public void deleteShop(long id){
        shopRepository.deleteById(id);

    }
}
