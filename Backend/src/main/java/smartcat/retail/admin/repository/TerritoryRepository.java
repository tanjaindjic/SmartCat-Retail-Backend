package smartcat.retail.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartcat.retail.admin.model.Territory;

public interface TerritoryRepository extends JpaRepository<Territory, Long> {
}
