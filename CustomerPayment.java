package service;

import java.util.List;

import domain.Customer;
import domain.Payment;
import exception.SupermarketException;

public interface CustomerPayment {
	public static final int PAY_FAIL = 0;
	public static final int PAY_SUCC = 1;
	
	List<Payment> getAllPayment(Customer customer) throws SupermarketException;
	boolean receiveCashierPayment(Payment payment) throws SupermarketException;
	boolean payCashierPayment(Payment payment) throws SupermarketException;
	boolean addCustomer(String customerName) throws SupermarketException;
	List<String> queryCustomer(String customerName) throws SupermarketException;
}
