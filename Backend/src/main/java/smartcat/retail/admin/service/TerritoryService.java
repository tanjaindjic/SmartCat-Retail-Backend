package smartcat.retail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import smartcat.retail.admin.model.Territory;
import smartcat.retail.admin.repository.TerritoryRepository;

import java.util.Collection;

@Service
public class TerritoryService {

    @Autowired
    private TerritoryRepository territoryRepository;

    public Collection<Territory> getAllTerritories(){
        return territoryRepository.findAll();
    }

    public Territory getTerritory(long id) {
        return territoryRepository.findById(id).orElse(null);
    }

    public Territory createTerritory(Territory territory) {
        return territoryRepository.save(territory);
    }

    public Territory updateTerritory(long id, Territory t) {
        if(getTerritory(id) != null)
            return territoryRepository.save(t);
        else return null;

    }

    public void deleteTerritory(long id) {
        territoryRepository.deleteById(id);
    }
}
