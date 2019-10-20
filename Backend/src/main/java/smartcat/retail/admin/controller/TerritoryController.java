package smartcat.retail.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcat.retail.admin.model.Territory;
import smartcat.retail.admin.service.TerritoryService;

import javax.validation.constraints.NotNull;

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
        if(territory != null)
            return ResponseEntity.ok(territory);
        return ResponseEntity.badRequest().body("Territory with a given ID: " + id + " was not found.");
    }

    @PostMapping
    public ResponseEntity createTerritory(@RequestBody @NotNull Territory t){
        return ResponseEntity.ok(territoryService.createTerritory(t));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateTerritory(@PathVariable long id, @RequestBody @NotNull Territory t){
        Territory updatedTerritory = territoryService.updateTerritory(id, t);
        if(updatedTerritory != null)
            return ResponseEntity.ok(updatedTerritory);
        return ResponseEntity.badRequest().body("Territory with a given ID: " + id + " was not updated.");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTerritory(@PathVariable long id){
        territoryService.deleteTerritory(id);
    }

}
