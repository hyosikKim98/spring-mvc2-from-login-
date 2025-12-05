package hello.itemservice.domain.item;

import lombok.Data;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price + _this.quantity >= 10000")
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

//    private Boolean open;
//    private List<String> regions;
//    private ItemType itemType;
//    private String deliveryCode;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
