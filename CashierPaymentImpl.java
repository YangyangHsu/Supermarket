package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.CashierDao;
import dao.CustomerDao;
import dao.ItemDao;
import dao.PaymentDao;
import domain.Cashier;
import domain.Customer;
import domain.Item;
import domain.Payment;
import exception.SupermarketException;
import service.CashierPayment;

public class CashierPaymentImpl implements CashierPayment {
	private CashierDao cashierDao;
	private CustomerDao customerDao;
	private PaymentDao paymentDao;
	private ItemDao itemDao;
	
	public void setCashierDao(CashierDao cashierDao){
		this.cashierDao = cashierDao;
	}
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao = customerDao;
	}
	public void setPaymentDao(PaymentDao paymentDao){
		this.paymentDao = paymentDao;
	}
	public void setThingDao(ItemDao thingDao){
		this.itemDao = thingDao;
	}
	
	@Override
	public int validLogin(Cashier cashier) throws SupermarketException{
		if ( ((List<Payment>) cashierDao.findByName(cashier)).size() >= 1){
			return LOGIN_SUCC;
		}
		else{
			return LOGIN_FAIL;
		}
	}
	
	@Override
	public List<Payment> getAllPayment(Cashier cashier) throws SupermarketException{
		List<Payment> payments = paymentDao.findByCashier(cashier);
		List<Payment> paymentResult = new ArrayList<Payment>();
		for (Payment p : payments){
			paymentResult.add(new Payment(p.getPaymentStatus(),p.getCustomerId(),p.getCashierId(),p.getItemId()));
		}
		return paymentResult;
	}
	
	@Override
	public List<Payment> getPayment(Customer customer) throws SupermarketException{
		List<Payment> paymentFind = paymentDao.findByCustomer(customer);
		List<Payment> paymentResult = new ArrayList<Payment>();
		for(Payment p : paymentFind){
			paymentResult.add(new Payment(p.getPaymentStatus(),p.getCustomerId(),p.getCashierId(),p.getItemId()));
		}
		return paymentResult;
	}
	
	@Override
	public boolean addCashierPayment(String cashierName, String customerName, String itemName) throws SupermarketException{
		Payment payment = new Payment();
		payment.setPaymentStatus(0);
		payment.setCashierId(cashierDao.findByName(cashierName).getId());
		payment.setCustomerId(customerDao.findByName(customerName).getId());
		payment.setItemId(itemDao.findByThingName(itemName).getId());
		paymentDao.save(payment);
		return true;
	}
}
