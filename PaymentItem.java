package service;

import java.util.List;

import domain.Item;
import domain.Payment;
import exception.SupermarketException;


public interface PaymentItem {
	List<Item> getAllThing() throws SupermarketException;
	List<Item> getItem(Payment payment) throws SupermarketException;
}
