package dao;

import java.util.List;

import domain.Customer;

public interface CustomerDao {
	Customer get(Integer id);
	Integer save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	void delete(Integer id);
	List<Customer> findAll();
	Customer findById(Integer id);
	Customer findByName(String customerName);
	List<String> queryByName(String customerName);
}
