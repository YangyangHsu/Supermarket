package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.CashierDao;
import dao.CustomerDao;
import dao.ItemDao;
import dao.PaymentDao;
import domain.Customer;
import domain.Payment;
import exception.SupermarketException;
import service.CustomerPayment;

public class CustomerPaymentImpl implements CustomerPayment{
	private CashierDao cashierDao;
	private CustomerDao customerDao;
	private PaymentDao paymentDao;
	private ItemDao thingDao;
	
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
		this.thingDao = thingDao;
	}
	
	@Override
	public List<Payment> getAllPayment(Customer customer) throws SupermarketException{
		List<Payment> payments = paymentDao.findByCustomer(customer);
		List<Payment> paymentResult = new ArrayList<Payment>();
		for (Payment p : payments){
			paymentResult.add(new Payment(p.getPaymentStatus(),p.getCustomerId(),p.getCashierId(),p.getItemId()));
		}
		return paymentResult;
	}
	
	
	@Override
	public boolean receiveCashierPayment(Payment payment) throws SupermarketException{
		paymentDao.save(payment);
		return true;
	}
	
	@Override
	public boolean payCashierPayment(Payment payment) throws SupermarketException{
		payment.setPaymentStatus(1);
		return true;
	}
	
	@Override
	public boolean addCustomer(String customerName) throws SupermarketException{
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customerDao.save(customer);
		return true;
	}
	
	@Override
	public List<String> queryCustomer(String customerName) throws SupermarketException{
		List<String> names = customerDao.queryByName(customerName);
		return names;
	}
}
