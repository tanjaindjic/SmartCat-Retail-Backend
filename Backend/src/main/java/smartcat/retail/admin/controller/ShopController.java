package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Shop;
import smartcat.retail.admin.service.ShopService;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public ResponseEntity getAllShops(){
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getShop(@PathVariable long id){
        Shop shop = shopService.getShop(id);
        return shop != null ? ResponseEntity.ok(shop) : ResponseEntity.badRequest().body("Shop with a given ID: " + id + " was not found");
    }

    @PostMapping
    public ResponseEntity createShop(@RequestBody Shop s){
        return ResponseEntity.ok(shopService.createShop(s));
    }

    @PutMapping(value = "/id")
    public ResponseEntity updateShop(@PathVariable long id, @RequestBody Shop s){
        Shop updatedShop = shopService.updateShop(id, s);
        return updatedShop != null ? ResponseEntity.ok(updatedShop) : ResponseEntity.badRequest().body("Shop with a given ID: " + id + " was not updated.");
    }

}
