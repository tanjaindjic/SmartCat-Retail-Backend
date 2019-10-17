package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Territory;
import smartcat.retail.admin.service.TerritoryService;

@RestController
@RequestMapping(value = "/territory")
public class TerritoryController {

    @Autowired
    private TerritoryService territoryService;

    @GetMapping
    public ResponseEntity getTerritories(){
        return ResponseEntity.ok(territoryService.getAllTerritories());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getTerritory(@PathVariable long id){
        Territory territory = territoryService.getTerritory(id);
        return territory!=null ? ResponseEntity.ok(territory) : ResponseEntity.badRequest().body("Territory with a given ID: " + id + " was not found.");
    }

    @PostMapping
    public ResponseEntity createTerritory(@RequestBody Territory t){
        return ResponseEntity.ok(territoryService.createTerritory(t));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateTerritory(@PathVariable long id, @RequestBody Territory t){
        Territory updatedTerritory = territoryService.updateTerritory(id, t);
        return updatedTerritory != null ? ResponseEntity.ok(updatedTerritory) : ResponseEntity.badRequest().body("Territory with a given ID: " + id + " was not updated.");
    }

}
