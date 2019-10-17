package smartcat.retail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartcat.retail.admin.model.Shop;
import smartcat.retail.admin.repository.ShopRepository;

import java.util.Collection;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Collection getAllShops(){
        return shopRepository.findAll();
    }

    public Shop getShop(long id){
        return shopRepository.findById(id).orElse(null);
    }

    public Shop createShop(Shop s){
        return shopRepository.save(s);
    }

    public Shop updateShop(long id, Shop s) {
        if(getShop(id) != null)
            return shopRepository.save(s);
        else return null;
    }
}
