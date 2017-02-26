package dao;

import java.util.List;

import domain.Cashier;
import domain.Customer;
import domain.Payment;

public interface CashierDao {
	Cashier get(Integer cashierId);
	Integer save(Cashier cashier);
	void update(Cashier cashier);
	void delete(Cashier cashier);
	void delete(Integer cashierId);
	List<Cashier> findAll();
	Cashier findByName(Cashier cashier);
	Cashier findByPayment(Payment payment);
	Cashier findByCustomer(Customer customer);
	Cashier findByName(String cashierName);
}
