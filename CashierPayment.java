package service;

import java.util.List;

import domain.Cashier;
import domain.Customer;
import domain.Item;
import domain.Payment;
import exception.SupermarketException;


public interface CashierPayment {
	public static final int LOGIN_FAIL = 0;
	public static final int LOGIN_SUCC = 1;
	
	public static final int PAY_FAIL = 0;
	public static final int PAY_SUCC = 1;
	
	int validLogin(Cashier cashier) throws SupermarketException ;
	List<Payment> getAllPayment(Cashier cashier) throws SupermarketException;
	List<Payment> getPayment(Customer customer) throws SupermarketException;
	boolean addCashierPayment(String cashierName, String customerName, String itemName) throws SupermarketException;
}
