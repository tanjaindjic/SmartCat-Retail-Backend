package smartcat.retail.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartcat.retail.admin.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
