package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong();

    public Item save(Item item) {
        item.setId(sequence.incrementAndGet());
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updatedItem) {
        Item findItem = findById(itemId);

        findItem.setItemName(updatedItem.getItemName());
        findItem.setPrice(updatedItem.getPrice());
        findItem.setQuantity(updatedItem.getQuantity());
//        findItem.setOpen(updatedItem.getOpen());
//        findItem.setRegions(updatedItem.getRegions());
//        findItem.setItemType(updatedItem.getItemType());
//        findItem.setDeliveryCode(updatedItem.getDeliveryCode());
    }

    public void clearStore() {
        store.clear();
    }
}
