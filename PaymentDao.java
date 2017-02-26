package dao;

import java.util.List;

import domain.Cashier;
import domain.Customer;
import domain.Payment;

public interface PaymentDao {
	Payment get(Integer paymentId);
	Integer save(Payment payment);
	void update(Payment payment);
	void delete(Payment payment);
	void delete(Integer paymentId);
	List<Payment> findAll();
	List<Payment> findByCustomer(Customer customer);
	List<Payment> findByCashier(Cashier cashier);
}
