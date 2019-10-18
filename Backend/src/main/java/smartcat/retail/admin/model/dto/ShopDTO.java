package smartcat.retail.admin.model.dto;

import smartcat.retail.admin.model.Shop;

public class ShopDTO {
    public Shop shop;
    public long territoryId;

    public ShopDTO() {
    }

    public ShopDTO(Shop shop, long territoryId) {
        this.shop = shop;
        this.territoryId = territoryId;
    }
}
