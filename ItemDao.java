package dao;

import java.util.List;

import domain.Item;
import domain.Payment;

public interface ItemDao {
	Item get(Integer thingId);
	Integer save(Item thing);
	void update(Item thing);
	void delete(Item thing);
	void delete(Integer thingId);
	List<Item> findAll();
	Item findByThingName(String thingName);
	List<Item> findByPayment(Payment payment);
}
