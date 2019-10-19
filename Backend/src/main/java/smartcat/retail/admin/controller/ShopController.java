package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Shop;
import smartcat.retail.admin.model.Territory;
import smartcat.retail.admin.model.dto.ShopDTO;
import smartcat.retail.admin.service.ShopService;
import smartcat.retail.admin.service.TerritoryService;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private TerritoryService territoryService;

    @GetMapping
    public ResponseEntity getAllShops(){
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getShop(@PathVariable long id){
        Shop shop = shopService.getShop(id);
        if(shop != null)
            return ResponseEntity.ok(new ShopDTO(shop));
        return ResponseEntity.badRequest().body("Shop with a given ID: " + id + " was not found");
    }

    @PostMapping
    public ResponseEntity createShop(@RequestBody ShopDTO s){
        return ResponseEntity.ok(shopService.createShop(s));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateShop(@PathVariable long id, @RequestBody ShopDTO s){
        Shop updatedShop = shopService.updateShop(id, s);
        return updatedShop != null ? ResponseEntity.ok(updatedShop) : ResponseEntity.badRequest().body("Shop with a given ID: " + id + " was not updated.");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteShop(@PathVariable long id){
        Shop shop = shopService.getShop(id);
        if(shop == null)
            return;
        Territory territory = shop.getTerritory();
        territory.getShops().remove(shop);
        territoryService.updateTerritory(territory.getId(), territory);
        shop.setTerritory(null);
        shopService.saveShop(shop);
        shopService.deleteShop(id);
    }

}
